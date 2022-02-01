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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SpecificationDetails;
import com.tectonica.jonix.common.codelist.SpecificationFeatureTypes;
import com.tectonica.jonix.common.struct.JonixSpecificationBundleName;
import com.tectonica.jonix.common.struct.JonixSpecificationFeature;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplementManifest}&gt;</li>
 * <li>&lt;{@link ProductionManifest}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link BodyManifest}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest}</li>
 * </ul>
 */
public class BodyManifest implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BodyManifest";
    public static final String shortname = "bodymanifest";

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
    public static final BodyManifest EMPTY = new BodyManifest();

    public BodyManifest() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public BodyManifest(org.w3c.dom.Element element) {
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
                case BodyResource.refname:
                case BodyResource.shortname:
                    bodyResources = JPU.addToList(bodyResources, new BodyResource(e));
                    break;
                case SpecificationBundleName.refname:
                case SpecificationBundleName.shortname:
                    specificationBundleNames = JPU.addToList(specificationBundleNames, new SpecificationBundleName(e));
                    break;
                case SpecificationDetail.refname:
                case SpecificationDetail.shortname:
                    specificationDetails = JPU.addToList(specificationDetails, new SpecificationDetail(e));
                    break;
                case SpecificationFeature.refname:
                case SpecificationFeature.shortname:
                    specificationFeatures = JPU.addToList(specificationFeatures, new SpecificationFeature(e));
                    break;
                case SpecificationDescription.refname:
                case SpecificationDescription.shortname:
                    specificationDescriptions =
                        JPU.addToList(specificationDescriptions, new SpecificationDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;BodyManifest&gt; or &lt;bodymanifest&gt;) is explicitly provided in the ONIX XML
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

    private List<BodyResource> bodyResources = Collections.emptyList();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<BodyResource> bodyResources() {
        _initialize();
        return bodyResources;
    }

    private ListOfOnixDataComposite<SpecificationBundleName, JonixSpecificationBundleName> specificationBundleNames =
        ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<SpecificationBundleName, JonixSpecificationBundleName> specificationBundleNames() {
        _initialize();
        return specificationBundleNames;
    }

    private ListOfOnixElement<SpecificationDetail, SpecificationDetails> specificationDetails =
        ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SpecificationDetail, SpecificationDetails> specificationDetails() {
        _initialize();
        return specificationDetails;
    }

    private ListOfOnixDataCompositeWithKey<SpecificationFeature, JonixSpecificationFeature, SpecificationFeatureTypes>
        specificationFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SpecificationFeature, JonixSpecificationFeature, SpecificationFeatureTypes>
        specificationFeatures() {
        _initialize();
        return specificationFeatures;
    }

    private ListOfOnixElement<SpecificationDescription, String> specificationDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SpecificationDescription, String> specificationDescriptions() {
        _initialize();
        return specificationDescriptions;
    }
}
