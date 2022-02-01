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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixSpecificationBundleName;

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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link CoverManifest} ⯈ {@link SpecificationBundleName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link CoverManifest} ⯈ {@link SpecificationBundleName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link BodyManifest} ⯈ {@link SpecificationBundleName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link BodyManifest} ⯈ {@link SpecificationBundleName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link InsertManifest} ⯈ {@link SpecificationBundleName}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈ {@link SpecificationBundleName}</li>
 * </ul>
 */
public class SpecificationBundleName implements OnixDataComposite<JonixSpecificationBundleName>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SpecificationBundleName";
    public static final String shortname = "specificationbundlename";

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
    public static final SpecificationBundleName EMPTY = new SpecificationBundleName();

    public SpecificationBundleName() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SpecificationBundleName(org.w3c.dom.Element element) {
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
                case SpecificationBundleNameTypeName.refname:
                case SpecificationBundleNameTypeName.shortname:
                    specificationBundleNameTypeName = new SpecificationBundleNameTypeName(e);
                    break;
                case SpecificationBundleNameValue.refname:
                case SpecificationBundleNameValue.shortname:
                    specificationBundleNameValue = new SpecificationBundleNameValue(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SpecificationBundleName&gt; or &lt;specificationbundlename&gt;) is explicitly
     *         provided in the ONIX XML
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

    private SpecificationBundleNameTypeName specificationBundleNameTypeName = SpecificationBundleNameTypeName.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public SpecificationBundleNameTypeName specificationBundleNameTypeName() {
        _initialize();
        return specificationBundleNameTypeName;
    }

    private SpecificationBundleNameValue specificationBundleNameValue = SpecificationBundleNameValue.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public SpecificationBundleNameValue specificationBundleNameValue() {
        _initialize();
        return specificationBundleNameValue;
    }

    @Override
    public JonixSpecificationBundleName asStruct() {
        _initialize();
        JonixSpecificationBundleName struct = new JonixSpecificationBundleName();
        struct.specificationBundleNameTypeName = specificationBundleNameTypeName.value;
        struct.specificationBundleNameValue = specificationBundleNameValue.value;
        return struct;
    }
}
