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
import com.tectonica.jonix.common.codelist.ResourceFileFeatureTypes;
import com.tectonica.jonix.common.struct.JonixResourceFileFeature;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CoverResource}&gt;</li>
 * <li>&lt;{@link BodyResource}&gt;</li>
 * <li>&lt;{@link InsertResource}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈ {@link CoverResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link BodyManifest} ⯈ {@link BodyResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈ {@link BodyResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link ResourceFileFeature}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈ {@link InsertResource} ⯈ {@link ResourceFileFeature}</li>
 * </ul>
 */
public class ResourceFileFeature
    implements OnixDataCompositeWithKey<JonixResourceFileFeature, ResourceFileFeatureTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ResourceFileFeature";
    public static final String shortname = "resourcefilefeature";

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
    public static final ResourceFileFeature EMPTY = new ResourceFileFeature();

    public ResourceFileFeature() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ResourceFileFeature(org.w3c.dom.Element element) {
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
                case ResourceFileFeatureType.refname:
                case ResourceFileFeatureType.shortname:
                    resourceFileFeatureType = new ResourceFileFeatureType(e);
                    break;
                case ResourceFileFeatureValue.refname:
                case ResourceFileFeatureValue.shortname:
                    resourceFileFeatureValue = new ResourceFileFeatureValue(e);
                    break;
                case ResourceFileFeatureDescription.refname:
                case ResourceFileFeatureDescription.shortname:
                    resourceFileFeatureDescriptions =
                        JPU.addToList(resourceFileFeatureDescriptions, new ResourceFileFeatureDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ResourceFileFeature&gt; or &lt;resourcefilefeature&gt;) is explicitly provided in
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

    private ResourceFileFeatureType resourceFileFeatureType = ResourceFileFeatureType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ResourceFileFeatureType resourceFileFeatureType() {
        _initialize();
        return resourceFileFeatureType;
    }

    private ResourceFileFeatureValue resourceFileFeatureValue = ResourceFileFeatureValue.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ResourceFileFeatureValue resourceFileFeatureValue() {
        _initialize();
        return resourceFileFeatureValue;
    }

    private ListOfOnixElement<ResourceFileFeatureDescription, String> resourceFileFeatureDescriptions =
        ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ResourceFileFeatureDescription, String> resourceFileFeatureDescriptions() {
        _initialize();
        return resourceFileFeatureDescriptions;
    }

    @Override
    public JonixResourceFileFeature asStruct() {
        _initialize();
        JonixResourceFileFeature struct = new JonixResourceFileFeature();
        struct.resourceFileFeatureType = resourceFileFeatureType.value;
        struct.resourceFileFeatureValue = resourceFileFeatureValue.value;
        struct.resourceFileFeatureDescriptions = resourceFileFeatureDescriptions.values();
        return struct;
    }

    @Override
    public ResourceFileFeatureTypes structKey() {
        return resourceFileFeatureType().value;
    }
}
