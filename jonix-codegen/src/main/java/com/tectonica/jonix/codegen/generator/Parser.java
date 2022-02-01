/*
 * Copyright (C) 2012-2020 Zach Melamed
 *
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.codegen.generator;

import com.tectonica.jonix.codegen.metadata.Cardinality;
import com.tectonica.jonix.codegen.metadata.OnixAttribute;
import com.tectonica.jonix.codegen.metadata.OnixClassDef;
import com.tectonica.jonix.codegen.metadata.OnixCompositeDef;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixConst;
import com.tectonica.jonix.codegen.metadata.OnixDoc;
import com.tectonica.jonix.codegen.metadata.OnixDocList;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixElementMember;
import com.tectonica.jonix.codegen.metadata.OnixEnumValue;
import com.tectonica.jonix.codegen.metadata.OnixFlagDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.metadata.OnixStructMember;
import com.tectonica.jonix.codegen.metadata.Primitive;
import com.tectonica.jonix.codegen.util.DOM;
import com.tectonica.jonix.codegen.util.DOM.ElementListener;
import com.tectonica.jonix.codegen.util.OnixSpecs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Parser {
    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);

    public static class SchemaContext {
        private final OnixSpecs.OnixVersion onixVersion;

        SchemaContext(OnixSpecs.OnixVersion onixVersion) {
            this.onixVersion = onixVersion;
        }

        private Set<String> enumNames = new HashSet<>();
        private Map<String, Element> groupNodes = new HashMap<>();
        private Map<String, Element> attributeGroupNodes = new HashMap<>();
    }

    private final SchemaContext context;
    private final OnixMetadata meta;

    public Parser(OnixSpecs.OnixVersion onixVersion, boolean isShort, String codelistIssue) {
        context = new SchemaContext(onixVersion);
        meta = new OnixMetadata(onixVersion, isShort, codelistIssue);
    }

    public OnixMetadata getMetadata() {
        return meta;
    }

    /**
     * This method is extracting metadata from ONIX official XSD files. Currently it can process either the Codelists
     * XSD or the Structure XSD (in either variant, Reference or Short).
     * <p>
     * Since processing of some data-types builds on the existence of others (previously-processed) data-types, the
     * correct order is to first call this method on the Codelists, and later on the Structure.
     */
    public void analyzeSchema(Document xsdDoc, String schemaFileName) {
        // take the top-container from of the XSD file, we'll process everything below this element
        final Element schemaElem = (Element) xsdDoc.getElementsByTagName("xs:schema").item(0);

        // process auxiliary tags (SimpleTypes, Groups, AttributeGroups) that other tags will references later
        LOGGER.debug("\n\n{}/{}: Analyzing Context ****************************************************\n",
            meta.onixVersion, schemaFileName);
        analyzeContext(schemaElem);

        // process complex tags, pertaining to Onix classes (elements, composites, flags)
        // NOTE: none are expected in Codelist XSD
        LOGGER.debug("\n\nSchema {}/{}: Analyzing Classes ****************************************************\n",
            meta.onixVersion, schemaFileName);
        analyzeClasses(schemaElem);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // CONTEXT SERVICES
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Process primitive/auxiliary top-level tags (SimpleTypes, Groups, AttributeGroups) that Onix classes are composed
     * of. SimpleTypes are stored directly in {@link #meta}, as they already represent final types. Groups and
     * AttributeGroups, on the other hand, are stored intermediately in {@link #context}, and used later in parsing.
     */
    private void analyzeContext(final Element schemaElem) {
        processSimpleTypes(schemaElem);
        processGroups(schemaElem);
        processAttributeGroups(schemaElem);
    }

    private void processSimpleTypes(final Element schemaElem) {
        DOM.forElementsOf(schemaElem, "xs:simpleType", simpleTypeElem -> {

            // ensure that the xs:simpleType has a name attribute, and use it to start an OnixSimpleType instance
            final String simpleTypeName = simpleTypeElem.getAttribute("name");
            if (simpleTypeName.isEmpty()) {
                throw new RuntimeException("unnamed top-level xs:simpleType is unsupported");
            }
            OnixSimpleType simpleType = new OnixSimpleType(simpleTypeName);

            // the heavy lifting is done here
            processSimpleType(simpleTypeElem, simpleType);

            // store the processed simpleType in the metadata
            if (simpleType.isEnum()) {
                meta.onixEnums.put(simpleType.name, simpleType);
            } else {
                meta.onixTypes.put(simpleType.name, simpleType);
            }

            // some debug logging
            String enumName = simpleType.isEnum() ? ("enum=" + simpleType.enumName) : "";
            String link = (simpleType.enumAliasFor == null) ? "" : (" -> " + simpleType.enumAliasFor);
            LOGGER.debug("processed simpleType: {} ({}{})", simpleType.name, enumName, link);
        });
    }

    private void processSimpleType(Element simpleTypeElem, final OnixSimpleType simpleType) {
        DOM.forElementsOf(simpleTypeElem, new ElementListener() {
            boolean definitionAcquired = false;

            @Override
            public void onElement(Element simpleTypeDefElem) {
                final String simpleTypeDefName = simpleTypeDefElem.getNodeName();

                if (definitionAcquired) {
                    throw new RuntimeException("simpleType " + simpleType.name + " has more than one definition");
                }

                switch (simpleTypeDefName) {
                    case "xs:annotation":
                        simpleType.description = extractAnnotationText(simpleTypeDefElem);
                        break;
                    case "xs:restriction":
                        handleRestriction(simpleTypeDefElem);
                        definitionAcquired = true;
                        break;
                    case "xs:union":
                        // currently we only handle unions containing a single <xs:simpleType>
                        processSimpleType(singleSimpleTypeChildOf(simpleTypeDefElem, true), simpleType);
                        definitionAcquired = true;
                        break;
                    case "xs:list":
                        handleList(simpleTypeDefElem);
                        definitionAcquired = true;
                        break;
                    default:
                        throw new RuntimeException("Unhandled case of " + simpleTypeDefName);
                }
            }

            /**
             * xs:annotations are used to "document" other tags in plain english
             */
            private String extractAnnotationText(Element annotationElem) {
                final StringBuilder sb = new StringBuilder();
                DOM.forElementsOf(annotationElem, "xs:documentation", documentationElem -> {
                    final String line = DOM.getChildText(documentationElem);
                    if (line != null && !line.isEmpty()) {
                        if (sb.length() != 0) {
                            sb.append("\n");
                        }
                        // make sure that the line does not contain a "\n"
                        // e.g. a line looked like: "\n           Nei Mongol Autonomous Region"
                        sb.append(line.replaceAll("\n", "").trim());
                    }
                });
                return sb.length() > 0 ? sb.toString() : null;
            }

            /**
             * xs:restriction defines a data type by extending an existing type (built-in primitive such as xs:decimal,
             * or custom type such as another xs:simpleType)
             */
            private void handleRestriction(Element restrictionElem) {
                boolean isRestrictionHasBase = restrictionElem.hasAttribute("base");

                // first we check the case of extending a built-in primitive (such as xs:decimal or xs:string)
                // this is by-far the most common restriction in ONIX (codelists are xs:string-based restrictions)
                if (isRestrictionHasBase) {
                    final String baseType = restrictionElem.getAttribute("base");

                    // we expected that the 'base' is a known primitive-type, typically one of the following:
                    // [xs:decimal, xs:int, xs:nonNegativeInteger, xs:positiveInteger, xs:string, xs:token, xs:anyURI]
                    final Primitive primitiveType = Primitive.fromXsdToken(baseType);
                    if (primitiveType != null) {
                        simpleType.primitiveType = primitiveType;

                        // xs:string types may have an xs:pattern, or have list of possible enumerated values
                        if (primitiveType == Primitive.String) {
                            final Element patternElem = DOM.firstElemChild(restrictionElem, "xs:pattern");
                            if (patternElem != null) {
                                // NOTE: currently this only happens in Elements XSD
                                simpleType.description = patternElem.getAttribute("value");
                                if (DOM.nextElemChild(patternElem, "xs:pattern") != null) {
                                    LOGGER.info("ignoring alternative xs:patterns in {}", simpleType.name);
                                }
                                //LOGGER.debug("Case 1A ({}) for {} with comment '{}'", primitiveType.name(),
                                //    simpleType.name, simpleType.comment);
                            } else {
                                // NOTE: currently this only happens in Codelist XSD
                                addEnumerations(restrictionElem);
                                //LOGGER.debug("Case 1B ({}) for {}", primitiveType.name(), simpleType.name);
                                if (simpleType.enumValues == null) {
                                    LOGGER.debug("simpleType {} is a general String (without pattern or enumerations)",
                                        simpleType.name);
                                }
                            }
                        }

                        return; // CASE 1
                    }

                    // the only case where we allow 'base' that is NOT a known primitive-type is Aliasing, which
                    // means that we expect 'base' to point to a previously-processed simpleType
                    // NOTE: currently this only happens in the Codelist XSD, and only in enums
                    final OnixSimpleType existing = meta.typeByName(baseType);
                    if (existing != null) {
                        int childCount = restrictionElem.getChildNodes().getLength();
                        if (childCount > 0) {
                            throw new RuntimeException("Inheritance of non-primitive is limited to mere aliasing");
                        }
                        // we have a situation where one type simply "inherits" another type that's NOT xsd-primitive
                        simpleType.setAsAliasFor(existing);
                        return; // CASE 2
                    }

                    throw new RuntimeException("Unknown xs:restriction base: " + baseType);
                }

                // when the xs:restriction has no 'base', it defines a simple-type from scratch (no inheritance).
                // this is only rarely used in ONIX XSDs, as a way to define a min-sized list of another xs:simpleType.
                // We support it by using the target xs:simpleType as if it were this one directly (i.e. recursively).
                final Element simpleTypeElemBelowRestriction = singleSimpleTypeChildOf(restrictionElem, false);
                LOGGER.debug("simpleType {} is a base-less restriction, a copy of another xs:simpleType",
                    simpleType.name);
                processSimpleType(simpleTypeElemBelowRestriction, simpleType); // CASE 3
            }

            private void addEnumerations(Element restrictionElem) {
                DOM.forElementsOf(restrictionElem, "xs:enumeration", enumerationElem -> {
                    final String value = enumerationElem.getAttribute("value");
                    final Element annotationElem = DOM.firstElemChild(enumerationElem, "xs:annotation");
                    String comment = extractAnnotationText(annotationElem);
                    if (comment == null) {
                        throw new NullPointerException();
                    }
                    final int lineBreak = comment.indexOf("\n");
                    final String name;
                    final String description;
                    if (lineBreak < 0) {
                        name = comment;
                        description = null;
                    } else {
                        name = comment.substring(0, lineBreak);
                        description = comment.substring(lineBreak + "\n".length());
                    }
                    simpleType.add(OnixEnumValue.create(name, value, description));
                });
            }

            /**
             * xs:list represents a collection of some other simpleType
             */
            private void handleList(Element listElem) {
                final String itemType = listElem.getAttribute("itemType");
                if (itemType.isEmpty()) {
                    throw new RuntimeException("xs:list doesn't specify an itemType attribute");
                }
                OnixSimpleType existingType = meta.typeByName(itemType);
                if (existingType == null) {
                    throw new RuntimeException(
                        "Can't create list for " + simpleType.name + " with unknown type " + itemType);
                }
                LOGGER.debug("simpleTye {} is an xs:list of {} items", simpleType.name, existingType.name);
                // we create an alias to the item-type, and then mark the alias as such that represents a list
                simpleType.setAsAliasFor(existingType);
                simpleType.isList = true;
            }

            private Element singleSimpleTypeChildOf(Element element, boolean warnOnly) {
                final Element simpleTypeChild = DOM.firstElemChild(element, "xs:simpleType");
                if (simpleTypeChild != null) {
                    if (DOM.nextElemChild(simpleTypeChild, "xs:simpleType") != null) {
                        String msg = String
                            .format("simpleType %s violated expectancy for a single <xs:simpleType>", simpleType.name);
                        if (warnOnly) {
                            LOGGER.warn(msg);
                        } else {
                            throw new RuntimeException(msg);
                        }
                    }
                    return simpleTypeChild;
                }
                throw new RuntimeException("simpleType " + simpleType.name + " is missing a child <xs:simpleType>");
            }
        });

        // we're done going over all the (two) sub-tags of the xs:simpleType tag
        if (simpleType.primitiveType == null) {
            throw new RuntimeException("erroneous processing of simpleType " + simpleType);
        }

        // we now compose a Java name for enum, if that's the type, based on the enum's comment
        if (simpleType.isEnum()) {
            simpleType.enumName = enumNameOf(simpleType);
            simpleType.enumCodelistIssue = meta.codelistIssue;
        }

        // manual modifications
        patchSimpleType(simpleType); // fixes some errors from the XSD, if such exist
    }

    private String enumNameOf(OnixSimpleType enumType) {
        // first, if this is an alias, we take the enumName from the original
        if (enumType.enumAliasFor != null) {
            return meta.typeByName(enumType.enumAliasFor).enumName;
        }

        // otherwise we set the enumName based on the enum's comment + make sure it's unique
        String enumName = enumJavaName(enumType.description);
        if (!context.enumNames.add(enumName)) {
            String enumNameBefore = enumName;
            enumName += enumType.name; // new code-list with the same name, we have to differentiate
            if (context.enumNames.contains(enumName)) {
                throw new RuntimeException("Can't find unique name for simpleType " + enumType.name);
            }
            LOGGER.info("simpleType " + enumType.name + ": can't use " + enumNameBefore + ", using " + enumName);
        }
        return enumName;
    }

    /**
     * Encodes the (free-text) comment of the code-list (i.e. its annotation from the XSD schema) into a proper Java
     * name for the enum representing that code-list.
     * <p>
     * The process is NOT guaranteed to be forward-compatible as it only deals with cases observed.
     * <p>
     * Examples: <ul> <li>Title type code --> <code>TitleTypes</code> <li>Product composition -->
     * <code>ProductCompositions</code> <li>Language code – based on ISO 639-2/B --> <code>LanguageCodes</code> </ul>
     */
    private String enumJavaName(String enumComment) {
        final String[] splits = enumComment.replaceAll("[^a-zA-Z0-9 /]+", "").replaceAll("[ /]{2,}", " ").toLowerCase()
            .split("[ /]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String split = splits[i];
            if (i == splits.length - 1 && (split.equals("code") || split.equals("codes"))) {
                break;
            }
            if ((i > 0 && i < splits.length - 1) && (split.equals("iso"))) {
                break;
            }
            if ((i > 0 && i < splits.length - 3) && (split.equals("based")) && (splits[i + 1].equals("on"))
                && (splits[i + 2].equals("iso"))) {
                break;
            }
            sb.append(Character.toUpperCase(split.charAt(0))).append(split.substring(1));
        }
        return sb.toString() + "s";
    }

    private void patchSimpleType(final OnixSimpleType simpleType) {
        // hack for "ROW" constant in country-codes (ISO 3166-1)
        if (simpleType.name.equals("List91")) {
            simpleType.enumValues.add(0, OnixEnumValue.create("Rest Of World", "ROW", "All unspecified countries"));
        }
    }

    private void processGroups(final Element schemaElem) {
        DOM.forElementsOf(schemaElem, "xs:group", groupElem -> {
            final String groupName = groupElem.getAttribute("name");
            if (groupName.isEmpty()) {
                throw new RuntimeException("unnamed top-level xs:group is unsupported");
            }
            context.groupNodes.put(groupName, groupElem);
            LOGGER.debug("processed group: {}", groupName);
        });
    }

    private void processAttributeGroups(final Element schemaElem) {
        DOM.forElementsOf(schemaElem, "xs:attributeGroup", attributeGroupElem -> {
            final String attributeGroupName = attributeGroupElem.getAttribute("name");
            if (attributeGroupName.isEmpty()) {
                throw new RuntimeException("unnamed top-level xs:attributeGroup is unsupported");
            }
            context.attributeGroupNodes.put(attributeGroupName, attributeGroupElem);
            LOGGER.debug("processed attributeGroup: " + attributeGroupName);
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // ONIX CLASSES SERVICES
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Process the complex tags of the schema (xs:element), extracting properties of the Onix classes (including
     * elements, composites and flags)
     */
    private void analyzeClasses(Element schemaElem) {
        DOM.forElementsOf(schemaElem, element -> {
            final String xsdTagName = element.getNodeName();
            switch (xsdTagName) {
                case "xs:element":
                    extractOnixClass(element);
                    break;

                case "xs:simpleType":
                case "xs:attributeGroup":
                case "xs:group":
                    // auxiliary tags, pre-handled in analyzeContext(), already exist in OnixMetadata or SchemaContext
                    break;

                case "xs:include":
                    String schemaLocation = element.getAttribute("schemaLocation");
                    if (!"ONIX_BookProduct_CodeLists.xsd".equals(schemaLocation) &&
                        !"ONIX_XHTML_Subset.xsd".equals(schemaLocation)) {
                        // we ignore these XSD includes, for the following reasons:
                        // - ONIX_BookProduct_CodeLists.xsd: is called explicitly before the main XSD
                        // - ONIX_XHTML_Subset             :  pertains to HTML tags, which we don't represent in Jonix
                        throw new RuntimeException("Unexpected top-level xs:include " + schemaLocation);
                    }
                    break;

                default:
                    throw new RuntimeException("Unexpected top-level " + xsdTagName);
            }
        });
    }

    private void extractOnixClass(Element element) {

        // validate the basic structure of the xs:element
        String onixTagName = element.getAttribute("name");
        if (onixTagName.isEmpty()) {
            throw new RuntimeException("unnamed top-level xs:element is unsupported");
        }
        Element complexTypeElem;
        Element contentElem;
        String contentType = "";
        // an "xs:element" could have also "xs:annotation" and "xs:unique" items (ignore those...)
        try {
            complexTypeElem = DOM.firstElemChild(element);
            if (complexTypeElem.getNodeName().equals("xs:annotation")) {    // ignore "xs:annotation"
                complexTypeElem = DOM.nextElemChild(complexTypeElem);
            }
            if (!complexTypeElem.getNodeName().equals("xs:complexType")) {
                throw new RuntimeException("top-level xs:element is expected to be defined as a xs:complexType");
            }

            Element nextElement = DOM.nextElemChild(complexTypeElem);
            while (nextElement != null && nextElement.getNodeName().equals("xs:unique")) {    // ignore "xs:unique"
                nextElement = DOM.nextElemChild(nextElement);
            }
            if (nextElement != null) {
                throw new RuntimeException("top-level xs:element is expected contain exactly one xs:complexType");
            }

            // the basic structure is now validated (xs:element containing single xs:complexType)
            contentElem = DOM.firstElemChild(complexTypeElem);
            contentType = contentElem.getNodeName();
        } finally {
            LOGGER.debug("--- {} ({})", onixTagName, contentType);
        }

        final OnixClassDef onixClass;
        Element attributesParentElem = complexTypeElem;

        // the first child of <xs:complexType> determines how to process it, there are 3 cases
        switch (contentType) {
            case "xs:simpleContent":
            case "xs:complexContent":
                final Element extensionElem = DOM.firstElemChild(contentElem);
                onixClass = extractOnixElement(onixTagName, contentType, extensionElem);
                attributesParentElem = extensionElem;
                break;

            case "xs:choice":
            case "xs:sequence":
            case "xs:group":
                // special treatment for Onix2 Flow (tag containing HTML content)
                OnixClassDef onix2Flow = extractOnixElementForOnix2Flow(onixTagName, contentType, contentElem);
                if (onix2Flow != null) {
                    onixClass = onix2Flow;
                } else {
                    onixClass = extractOnixComposite(onixTagName, contentType, contentElem);
                }
                break;

            case "xs:attribute":
            case "xs:attributeGroup":
                onixClass = extractOnixFlag(onixTagName);
                break;

            default:
                throw new RuntimeException(
                    "first child of top-level xs:element's xs:complexType is expected to define a content. found: "
                        + contentType);
        }

        if (onixClass == null) {
            LOGGER.debug("Ignoring ONIX Class {} ({})", onixTagName, contentType);
            return;
        }

        // other than attributes, we don't expect other information about the class we just created
        DOM.ensureTagNames(DOM.nextElemChild(contentElem), Arrays.asList("xs:attribute", "xs:attributeGroup"));
        extractAttributes(attributesParentElem, onixClass);
    }

    /**
     * extracts an OnixElement which is a mere extension of some xs:simpleType (primitive or codelist)
     */
    private OnixClassDef extractOnixElement(String onixTagName, String contentType, Element extensionElem) {
        // validate that the passed child element is indeed an xs:extension with a base (i.e. inheritance)
        if (!extensionElem.getNodeName().equals("xs:extension")) {
            throw new RuntimeException("expected xs:extension as first child of " + contentType + ", found: "
                + extensionElem.getNodeName());
        }
        final String baseType = extensionElem.getAttribute("base");
        if (baseType.isEmpty()) {
            throw new RuntimeException("found xs:extension without base");
        }
        // under the xs:extension tag, we expect only xs:attribute and xs:attributeGroup tags
        DOM.ensureTagNames(DOM.firstElemChild(extensionElem), Arrays.asList("xs:attribute", "xs:attributeGroup"));

        // find out the base simpleType from which this OnixElement inherits
        final OnixSimpleType baseSimpleType;
        if (contentType.equals("xs:simpleContent")) {
            // xs:simpleContent is an extension of a simpleType with some attributes
            baseSimpleType = meta.typeByName(baseType);
            if (baseSimpleType == null) {
                if ("xs:integer".equals(baseType)) {
                    return null; // extremely rare, not worth the effort, we ignore (e.g. LatestReprintNumber in 3.0.1)
                }
                throw new RuntimeException("Unknown type " + baseType);
            }
        } else {
            // xs:complexContent in used in Onix3 for Flow tags (i.e. HTML content)
            if (!baseType.equals("Flow")) {
                throw new RuntimeException("found xs:extension with base type != Flow: " + baseType);
            }
            baseSimpleType = OnixSimpleType.XHTML;
        }

        final OnixElementDef onixElement = new OnixElementDef();
        onixElement.name = onixTagName;
        onixElement.valueMember = OnixElementMember.create(baseSimpleType);
        onixElement.isSpaceable = onixElement.valueMember.simpleType.isList;

        patchOnixElement(onixElement); // manual fixes for some errors in the XSD, if such exist
        meta.onixElements.put(onixElement.name, onixElement);

        return onixElement;
    }

    private OnixClassDef extractOnixElementForOnix2Flow(String onixTagName, String contentType, Element contentElem) {
        // special treatment for Onix2 Flow (tag containing HTML content)
        if (contentType.equals("xs:choice")) {
            if (DOM.firstElemChild(contentElem, "xs:element", "ref", "p") != null) {
                // we identify this situation by spotting the HTML <p> tag among the allowed elements.
                // if found, we classify this tag as OnixElement (with free HTML text), rather than OnixComposite
                final OnixElementDef onixElement = new OnixElementDef();
                onixElement.name = onixTagName;
                onixElement.valueMember = OnixElementMember.create(OnixSimpleType.XHTML);
                onixElement.isSpaceable = onixElement.valueMember.simpleType.isList;
                meta.onixElements.put(onixElement.name, onixElement);
                return onixElement;
            }
        }
        return null;
    }

    private OnixClassDef extractOnixComposite(String onixTagName, String contentType, Element contentElem) {
        final Map<String, OnixCompositeMember> members = new LinkedHashMap<>();
        if (contentType.equals("xs:group")) {
            extractMembersFromGroup(contentElem, members);
        } else {
            extractMembers(contentElem, members);
        }
        final OnixCompositeDef onixComposite = new OnixCompositeDef();
        onixComposite.name = onixTagName;
        onixComposite.members = new ArrayList<>(members.values());
        meta.onixComposites.put(onixComposite.name, onixComposite);
        return onixComposite;
    }

    private void extractMembers(final Element sequenceOrChoiceElem,
                                final Map<String, OnixCompositeMember> members) {

        final Cardinality parentCardinality = Cardinality.of(sequenceOrChoiceElem.getAttribute("minOccurs"),
            sequenceOrChoiceElem.getAttribute("maxOccurs"));

        DOM.forElementsOf(sequenceOrChoiceElem, childElem -> {
            final String childType = childElem.getNodeName();
            switch (childType) {
                case "xs:sequence":
                case "xs:choice":
                    // recurse, looking for the elements
                    extractMembers(childElem, members);
                    break;
                case "xs:group":
                    // recurse, looking for the elements
                    extractMembersFromGroup(childElem, members);
                    break;
                case "xs:element":
                    final String className = childElem.getAttribute("ref");
                    if (className.isEmpty()) {
                        throw new RuntimeException("under content - xs:element without ref found");
                    }
                    final boolean isUnderChoice = sequenceOrChoiceElem.getNodeName().equals("xs:choice");
                    final String minOccurs = isUnderChoice ? "0" : childElem.getAttribute("minOccurs");
                    final String maxOccurs = childElem.getAttribute("maxOccurs");
                    Cardinality cardinality = Cardinality.of(minOccurs, maxOccurs).mergeWith(parentCardinality);
                    final OnixCompositeMember existing = members.get(className);
                    if (existing == null) {
                        OnixCompositeMember onixCompositeMember = OnixCompositeMember.create(className, cardinality);
                        patchOnixCompositeMember(onixCompositeMember);
                        members.put(className, onixCompositeMember);
                    } else {
                        // this is a case where a certain member is listed more than once in the specs of the parent
                        // element. this happens when the XSD allows several xs:choices, each with its own cardinality.
                        // for example, the Addressee composite requires AddresseeName child element, unless one or more
                        // AddresseeIdentifier children are provided, in which case the AddresseeName is optional.
                        // here we merge these two contradicting specs (required vs optional, single vs multiple) into
                        // the broadest one.
                        Cardinality previousCardinality = existing.cardinality;
                        existing.cardinality = previousCardinality.mergeWith(cardinality);
                        LOGGER.trace("merging cardinalities of member {} ({} + {} = {})",
                            className, previousCardinality, cardinality, existing.cardinality);
                        // TODO: when more than one xs:choice is given, a may require implicit merge.
                        //  For example, in the example above, AddresseeIdentifier should actually be regarded as
                        //  ZeroOrMore, rather than the explicit OneOrMore specified in one of the choices
                    }
                    break;
                default:
                    throw new RuntimeException("under content - node of invalid type found: " + childType);
            }
        });
    }

    private void extractMembersFromGroup(final Element groupElem,
                                         final Map<String, OnixCompositeMember> members) {
        String groupName = groupElem.getAttribute("ref");
        final Element groupDefElem = context.groupNodes.get(groupName);
        if (groupDefElem == null) {
            throw new RuntimeException("under content - couldn't find group " + groupName);
        }
        Element groupDefTopElem = DOM.firstElemChild(groupDefElem);
        if (groupDefTopElem.getNodeName().equals("xs:annotation")) {    // ignore "xs:annotation"
            groupDefTopElem = DOM.nextElemChild(groupDefTopElem);
        }
        if (groupDefTopElem == null) {
            throw new RuntimeException("group " + groupName + " is empty");
        }
        String groupTopElemType = groupDefTopElem.getTagName();
        if (!groupTopElemType.equals("xs:sequence") && !groupTopElemType.equals("xs:choice")) {
            throw new RuntimeException(
                "group " + groupName + " has unexpected top-element: " + groupTopElemType);
        }
        extractMembers(groupDefTopElem, members);
    }

    private OnixClassDef extractOnixFlag(String onixTagName) {
        final OnixFlagDef onixFlagClass = new OnixFlagDef();
        onixFlagClass.name = onixTagName;
        meta.onixFlags.put(onixFlagClass.name, onixFlagClass);
        return onixFlagClass;
    }

    private static final Set<String> SPACEABLE_REF_2 = new HashSet<>(Arrays.asList(
        "RegionCode", "MarketCountry", "MarketTerritory", "MarketCountryExcluded"));

    private static final Set<String> SPACEABLE_SHORT_2 = new HashSet<>(Arrays.asList(
        "b398", "j403", "j404", "j405"));

    private void patchOnixElement(final OnixElementDef onixElement) {
        if (context.onixVersion == OnixSpecs.OnixVersion.Onix2) {
            if (onixElement.name.equals("AgentIDType") || onixElement.name.equals("j400")) {
                // patch for error in Onix2_rev03 XSD with regards to AgentIDType (listed as free text)
                onixElement.valueMember = OnixElementMember.create(meta.onixEnums.get("List92"));
            } else if (onixElement.name.equals("MarketDateRole") || onixElement.name.equals("j408")) {
                // patch for error in Onix2_rev03 XSD with regards to MarketDateRole (listed as free text)
                // NOTE: the correct codelist is 67, but we use 163 (which extends 67) so that a common struct can be
                // created
                onixElement.valueMember = OnixElementMember.create(meta.onixEnums.get("List163"));
            } else if (SPACEABLE_REF_2.contains(onixElement.name) || SPACEABLE_SHORT_2.contains(onixElement.name)) {
                // for elements in Onix2_rev03 that are documented (in HTML) as supporting space-separated list, but
                // defined as singular in the schema (the XSD file)
                onixElement.isSpaceable = true;
            }
        }
    }

    private void patchOnixCompositeMember(OnixCompositeMember onixCompositeMember) {
        // in Onix's <AudienceRange> there are two members <AudienceRangePrecision> and <AudienceRangeValue>
        // with a very unique cardinality - they can appear once, twice or not at all. the XSD doesn't reflect that
        if (onixCompositeMember.className.equals("AudienceRangePrecision")
            || onixCompositeMember.className.equals("AudienceRangeValue")
            || onixCompositeMember.className.equals("b075")
            || onixCompositeMember.className.equals("b076")) {
            onixCompositeMember.cardinality = Cardinality.ZeroOrMore;
        }
    }

    private void extractAttributes(Element attributesParentElem, final OnixClassDef onixClass) {
        final ElementListener attributeWorker = attributeElem -> extractAttribute(attributeElem, onixClass);

        DOM.forElementsOf(attributesParentElem, "xs:attribute", attributeWorker);

        DOM.forElementsOf(attributesParentElem, "xs:attributeGroup", attributeGroupRefElem -> {
            final String ref = attributeGroupRefElem.getAttribute("ref");
            if (ref.isEmpty()) {
                throw new RuntimeException("xs:attributeGroup is specified without ref");
            }
            final Element attributeGroupElem = context.attributeGroupNodes.get(ref);
            if (attributeGroupElem == null) {
                throw new RuntimeException("no definition found for xs:attributeGroup ref=" + ref);
            }

            DOM.forElementsOf(attributeGroupElem, "xs:attribute", attributeWorker);
        });
    }

    private void extractAttribute(Element attributeElem, final OnixClassDef onixClass) {
        final String name = attributeElem.getAttribute("name");
        final String fixed = attributeElem.getAttribute("fixed");

        // case 1 - simplest possible const (using 'fixed')
        if (!fixed.isEmpty()) {
            onixClass.add(OnixConst.create(name, fixed));
            return;
        }

        // case 2 - nested const (using internal 'xs:enumeration')
        final Element simpleTypeElement = DOM.firstElemChild(attributeElem, "xs:simpleType");
        if (simpleTypeElement != null) {
            final Element restrictionElem = DOM.firstElemChild(simpleTypeElement, "xs:restriction");
            if (restrictionElem == null) {
                throw new RuntimeException();
            }

            final String base = restrictionElem.getAttribute("base");
            if (Primitive.fromXsdToken(base) != Primitive.String) {
                throw new RuntimeException();
            }

            final Element enumerationElem = DOM.firstElemChild(restrictionElem, "xs:enumeration");
            if (enumerationElem == null) {
                throw new RuntimeException();
            }

            final String value = enumerationElem.getAttribute("value");

            if (name.isEmpty() || value.isEmpty()) {
                throw new RuntimeException("Empty const attribute");
            }

            onixClass.add(OnixConst.create(name, value));
            return;
        }

        // case 3 - a true attribute
        final String baseType = attributeElem.hasAttribute("type") ? attributeElem.getAttribute("type") : "xs:string";
        final Primitive primitiveType = Primitive.fromXsdToken(baseType);
        if (primitiveType == null) {
            final OnixSimpleType simpleType = meta.typeByName(baseType);
            if (simpleType == null) {
                throw new RuntimeException("Couldn't find type " + baseType);
            }
            onixClass.add(OnixAttribute.create(name, simpleType));
        } else {
            onixClass.add(OnixAttribute.create(name, primitiveType));
        }
    }

    public void postAnalysis(String specHtml) {
        // we're traversing all composites, looking for those that are data-composites, i.e. that contain ONLY elements
        // and/or flags (no nested composites) - these data-composites will become Jonix structs
        for (OnixCompositeDef composite : meta.getComposites()) {
            boolean isDataComposite = true;
            OnixStruct struct = new OnixStruct(composite);
            for (OnixCompositeMember member : composite.members) {
                member.onixClass = meta.classByName(member.className);
                if (member.onixClass == null) {
                    throw new NullPointerException(
                        String.format("class %s referenced by %s wasn't found", member.className, composite.name));
                }

                if (isDataComposite) {
                    if (member.onixClass instanceof OnixElementDef) {
                        OnixSimpleType simpleType = ((OnixElementDef) member.onixClass).valueMember.simpleType;

                        boolean isKey = false;
                        if (simpleType.isEnum() && (member.cardinality == Cardinality.Required)) {
                            if (simpleType.enumName.endsWith("Types") || simpleType.enumName.endsWith("Roles")) {
                                if (struct.keyMember == null) {
                                    // in rare-cases (e.g. OtherText) having several candidates - we take the first
                                    isKey = true;
                                }
                            }
                        }
                        if (isKey) {
                            struct.keyMember = new OnixStructMember(member);
                        } else {
                            struct.members.add(new OnixStructMember(member));
                        }
                    } else if (member.onixClass instanceof OnixFlagDef) {
                        struct.members.add(new OnixStructMember(member));
                    } else {
                        isDataComposite = false;
                    }
                }
            }

            if (isDataComposite) {
                if (struct.members.size() == 0) {
                    throw new RuntimeException("Struct with no members - " + struct.containingComposite.name);
                }
                meta.jonixStructs.put(composite.name, struct);
            }
        }

        // calculate the possible paths for each onixClass, starting with direct parents
        for (OnixCompositeDef composite : meta.getComposites()) {
            for (OnixCompositeMember member : composite.members) {
                member.onixClass.add(composite); // adds a parent to the onixClass indicated by the member
            }
        }
        // and then recursively construct paths of indirect parents
        meta.onixClasses().forEach(elem -> elem.paths = pathsOf(elem));

        meta.onixClasses().filter(oc -> !oc.name.equalsIgnoreCase("ONIXMessage")).forEach(oc -> {
            if (oc.parents == null) {
                throw new RuntimeException("no parent composite(s) were found for " + oc.name);
            }
        });

        // attach documentation
        if (!meta.isShort) { // onixDocs have onixClassName property, which is the ref-name of the class
            //MultiMap<String, OnixDoc> mmap = new MultiMap<>();
            OnixDocList onixDocList = OnixDocsParser.parse(specHtml);
            for (OnixDoc onixDoc : onixDocList) {
                OnixClassDef onixClass = meta.classByName(onixDoc.onixClassName);
                if (onixClass == null) {
                    LOGGER.warn("No class for onixDoc: '{}'", onixDoc.onixClassName);
                } else {
                    if (onixClass.paths.stream().noneMatch(s -> s.equals(onixDoc.path))) {
                        LOGGER.warn("Documentation path not found for class {} ({}): {}", onixDoc.onixClassName,
                            onixDoc.groupMarker, onixDoc.path);
                    }
                    onixClass.add(onixDoc);
                    //mmap.put(onixDoc.onixClassName, onixDoc);
                }
            }

            // attach member-specific documentation (for members of composites)
            meta.onixClasses().forEach(child ->
                // go through each parent (composite) of the child (either a composite, element or flag)
                Optional.ofNullable(child.parents).ifPresent(parents -> parents.forEach(parent -> {
                    // of all the onixDocs in the child, find the one whose path pertains to the current parent
                    Optional.ofNullable(child.onixDocs).map(onixDocs ->
                        onixDocs.stream()
                            .filter(od -> ("/" + od.path).endsWith(String.format("/%s/%s", parent.name, child.name)))
                            .findFirst()
                            .orElse(manuallyMatchedOnixDoc(onixDocList, child, parent)))
                        // if found, attach them to the member of the parent that pertains to the child
                        .map(onixDoc -> {
                            parent.members.stream().filter(m -> m.className.equals(child.name)).findFirst()
                                .ifPresent(m -> m.onixDoc = onixDoc);
                            return onixDoc;
                        })
                        // if not found, issue a warning
                        .orElseGet(() -> {
                            if (child.onixDocs == null) {
                                LOGGER.warn("No documentation for {}.{}", parent.name, child.name);
                            } else {
                                LOGGER.info("Ambiguous documentation for {}.{}: docPaths={}", parent.name, child.name,
                                    child.getDocPaths());
                            }
                            return null;
                        });
                })));
        }
    }

    private List<String> pathsOf(OnixClassDef onixClass) {
        if (onixClass.parents == null) {
            return Collections.singletonList(onixClass.name);
        }
        return onixClass.parents.stream().flatMap(parent -> pathsOf(parent).stream().map(s -> s + "/" + onixClass.name))
            .collect(Collectors.toList());
    }

    /**
     * In ONIX specs, repetitions of elements descriptions are avoided by putting a reference to another occurrence of
     * the same element in some other place in the spec-HTML. For example, in Onix3, readers of the NameAsSubject
     * composite are referred to the composite NameIdentifier, which has the same elements, hence the same per-element
     * documentation.
     * <p>
     * We currently don't parse these textual references in the specs-HTML. Instead, we use two techniques to overcome
     * missing descriptions (due to cross reference in the specs-HTML):
     * <ul>
     * <li>if there's only one description of an element, we assume it holds for all its occurrences</li>
     * <li>if there are multiple descriptions, we use try to pick the right one in this method</li>
     * </ul>
     *
     * @param elem   the element for which documentation is sought for
     * @param parent the composite that contains this element, which may be needed to disambiguate the choice of doc
     * @return the manually matched {@link OnixDoc}, or null if not found
     */
    private OnixDoc manuallyMatchedOnixDoc(OnixDocList onixDocList, OnixClassDef elem, OnixCompositeDef parent) {
        boolean singleton = (elem.onixDocs != null) && (elem.onixDocs.size() == 1);
        if (singleton) {
            return elem.onixDocs.get(0);
        }

        if (meta.onixVersion == OnixSpecs.OnixVersion.Onix3) {
            // From ONIX docs for <AlternativeName> : P.7.22 to P.7.36  -> P.7.6 to P.7.20
            // From ONIX docs for <NameAsSubject>   : P.12.7 to P.12.22 -> P.7.5 to P.7.20
            switch (String.format("%s/%s", parent.name, elem.name)) {
                case "AlternativeName/PersonName":
                case "NameAsSubject/PersonName":
                    return onixDocList.findByGroupMarker("P.7.9");

                case "AlternativeName/CorporateName":
                case "NameAsSubject/CorporateName":
                    return onixDocList.findByGroupMarker("P.7.19");

                case "NameAsSubject/NameType":
                    return onixDocList.findByGroupMarker("P.7.5");

                default:
                    return null;
            }
        }
        return null; // TODO: support manual lookup for Onix2 too
    }
}
