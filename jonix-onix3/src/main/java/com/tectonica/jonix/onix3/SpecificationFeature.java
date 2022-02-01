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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SpecificationFeatureTypes;
import com.tectonica.jonix.common.struct.JonixSpecificationFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CoverManifest}&gt;</li>
 * <li>&lt;{@link BodyManifest}&gt;</li>
 * <li>&lt;{@link InsertManifest}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link CoverManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link BodyManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link InsertManifest} ⯈ {@link SpecificationFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈ {@link SpecificationFeature}</li>
 * </ul>
 */
public class SpecificationFeature
    implements OnixDataCompositeWithKey<JonixSpecificationFeature, SpecificationFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SpecificationFeature";
    public static final String shortname = "specificationfeature";

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
    public static final SpecificationFeature EMPTY = new SpecificationFeature();

    public SpecificationFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SpecificationFeature(org.w3c.dom.Element element) {
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
                case SpecificationFeatureType.refname:
                case SpecificationFeatureType.shortname:
                    specificationFeatureType = new SpecificationFeatureType(e);
                    break;
                case SpecificationFeatureValue.refname:
                case SpecificationFeatureValue.shortname:
                    specificationFeatureValue = new SpecificationFeatureValue(e);
                    break;
                case SpecificationFeatureDescription.refname:
                case SpecificationFeatureDescription.shortname:
                    specificationFeatureDescriptions =
                        JPU.addToList(specificationFeatureDescriptions, new SpecificationFeatureDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SpecificationFeature&gt; or &lt;specificationfeature&gt;) is explicitly provided in
     *         the ONIX XML
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

    private SpecificationFeatureType specificationFeatureType = SpecificationFeatureType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public SpecificationFeatureType specificationFeatureType() {
        _initialize();
        return specificationFeatureType;
    }

    private SpecificationFeatureValue specificationFeatureValue = SpecificationFeatureValue.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SpecificationFeatureValue specificationFeatureValue() {
        _initialize();
        return specificationFeatureValue;
    }

    private ListOfOnixElement<SpecificationFeatureDescription, String> specificationFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SpecificationFeatureDescription, String> specificationFeatureDescriptions() {
        _initialize();
        return specificationFeatureDescriptions;
    }

    @Override
    public JonixSpecificationFeature asStruct() {
        _initialize();
        JonixSpecificationFeature struct = new JonixSpecificationFeature();
        struct.specificationFeatureType = specificationFeatureType.value;
        struct.specificationFeatureValue = specificationFeatureValue.value;
        struct.specificationFeatureDescriptions = specificationFeatureDescriptions.values();
        return struct;
    }

    @Override
    public SpecificationFeatureTypes structKey() {
        return specificationFeatureType().value;
    }
}
