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
import com.tectonica.jonix.common.codelist.ResourceFeatureTypes;
import com.tectonica.jonix.common.struct.JonixResourceFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupportingResource}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈ {@link ResourceFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link ResourceFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link SupportingResource} ⯈ {@link ResourceFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈ {@link SupportingResource} ⯈ {@link ResourceFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈ {@link ResourceFeature}</li>
 * </ul>
 */
public class ResourceFeature
    implements OnixDataCompositeWithKey<JonixResourceFeature, ResourceFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceFeature";
    public static final String shortname = "resourcefeature";

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
    public static final ResourceFeature EMPTY = new ResourceFeature();

    public ResourceFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ResourceFeature(org.w3c.dom.Element element) {
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
                case ResourceFeatureType.refname:
                case ResourceFeatureType.shortname:
                    resourceFeatureType = new ResourceFeatureType(e);
                    break;
                case FeatureValue.refname:
                case FeatureValue.shortname:
                    featureValue = new FeatureValue(e);
                    break;
                case FeatureNote.refname:
                case FeatureNote.shortname:
                    featureNotes = JPU.addToList(featureNotes, new FeatureNote(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ResourceFeature&gt; or &lt;resourcefeature&gt;) is explicitly provided in the ONIX
     *         XML
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

    private ResourceFeatureType resourceFeatureType = ResourceFeatureType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ResourceFeatureType resourceFeatureType() {
        _initialize();
        return resourceFeatureType;
    }

    private FeatureValue featureValue = FeatureValue.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public FeatureValue featureValue() {
        _initialize();
        return featureValue;
    }

    private ListOfOnixElement<FeatureNote, String> featureNotes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<FeatureNote, String> featureNotes() {
        _initialize();
        return featureNotes;
    }

    @Override
    public JonixResourceFeature asStruct() {
        _initialize();
        JonixResourceFeature struct = new JonixResourceFeature();
        struct.resourceFeatureType = resourceFeatureType.value;
        struct.featureValue = featureValue.value;
        struct.featureNotes = featureNotes.values();
        return struct;
    }

    @Override
    public ResourceFeatureTypes structKey() {
        return resourceFeatureType().value;
    }
}
