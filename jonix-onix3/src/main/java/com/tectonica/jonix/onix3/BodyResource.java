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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ResourceFileDateRoles;
import com.tectonica.jonix.common.codelist.ResourceFileDetails;
import com.tectonica.jonix.common.codelist.ResourceFileFeatureTypes;
import com.tectonica.jonix.common.codelist.ResourceIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixResourceFileDate;
import com.tectonica.jonix.common.struct.JonixResourceFileFeature;
import com.tectonica.jonix.common.struct.JonixResourceIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link BodyManifest}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link BodyManifest} ⯈ {@link BodyResource}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈ {@link BodyResource}</li>
 * </ul>
 */
public class BodyResource implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BodyResource";
    public static final String shortname = "bodyresource";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final BodyResource EMPTY = new BodyResource();

    public BodyResource() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public BodyResource(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case ResourceFileLink.refname:
                case ResourceFileLink.shortname:
                    resourceFileLinks = JPU.addToList(resourceFileLinks, new ResourceFileLink(e));
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case ResourceRole.refname:
                case ResourceRole.shortname:
                    resourceRole = new ResourceRole(e);
                    break;
                case ResourceIdentifier.refname:
                case ResourceIdentifier.shortname:
                    resourceIdentifiers = JPU.addToList(resourceIdentifiers, new ResourceIdentifier(e));
                    break;
                case ResourceFileDetail.refname:
                case ResourceFileDetail.shortname:
                    resourceFileDetails = JPU.addToList(resourceFileDetails, new ResourceFileDetail(e));
                    break;
                case ResourceFileFeature.refname:
                case ResourceFileFeature.shortname:
                    resourceFileFeatures = JPU.addToList(resourceFileFeatures, new ResourceFileFeature(e));
                    break;
                case ResourceFileDescription.refname:
                case ResourceFileDescription.shortname:
                    resourceFileDescriptions = JPU.addToList(resourceFileDescriptions, new ResourceFileDescription(e));
                    break;
                case ResourceFileContentDescription.refname:
                case ResourceFileContentDescription.shortname:
                    resourceFileContentDescriptions =
                        JPU.addToList(resourceFileContentDescriptions, new ResourceFileContentDescription(e));
                    break;
                case ResourceFileDate.refname:
                case ResourceFileDate.shortname:
                    resourceFileDates = JPU.addToList(resourceFileDates, new ResourceFileDate(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;BodyResource&gt; or &lt;bodyresource&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ListOfOnixElement<ResourceFileLink, String> resourceFileLinks = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<ResourceFileLink, String> resourceFileLinks() {
        _initialize();
        return resourceFileLinks;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private ResourceRole resourceRole = ResourceRole.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ResourceRole resourceRole() {
        _initialize();
        return resourceRole;
    }

    private ListOfOnixDataCompositeWithKey<ResourceIdentifier, JonixResourceIdentifier, ResourceIdentifierTypes>
        resourceIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceIdentifier, JonixResourceIdentifier, ResourceIdentifierTypes>
        resourceIdentifiers() {
        _initialize();
        return resourceIdentifiers;
    }

    private ListOfOnixElement<ResourceFileDetail, ResourceFileDetails> resourceFileDetails = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ResourceFileDetail, ResourceFileDetails> resourceFileDetails() {
        _initialize();
        return resourceFileDetails;
    }

    private ListOfOnixDataCompositeWithKey<ResourceFileFeature, JonixResourceFileFeature, ResourceFileFeatureTypes>
        resourceFileFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFileFeature, JonixResourceFileFeature, ResourceFileFeatureTypes>
        resourceFileFeatures() {
        _initialize();
        return resourceFileFeatures;
    }

    private ListOfOnixElement<ResourceFileDescription, String> resourceFileDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ResourceFileDescription, String> resourceFileDescriptions() {
        _initialize();
        return resourceFileDescriptions;
    }

    private ListOfOnixElement<ResourceFileContentDescription, String> resourceFileContentDescriptions =
        ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ResourceFileContentDescription, String> resourceFileContentDescriptions() {
        _initialize();
        return resourceFileContentDescriptions;
    }

    private ListOfOnixDataCompositeWithKey<ResourceFileDate, JonixResourceFileDate, ResourceFileDateRoles>
        resourceFileDates = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ResourceFileDate, JonixResourceFileDate, ResourceFileDateRoles>
        resourceFileDates() {
        _initialize();
        return resourceFileDates;
    }
}
