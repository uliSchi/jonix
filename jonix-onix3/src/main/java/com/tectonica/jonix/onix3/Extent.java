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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.ExtentTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixExtent;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Extent}</li>
 * </ul>
 */
public class Extent implements OnixDataCompositeWithKey<JonixExtent, ExtentTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Extent";
    public static final String shortname = "extent";

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
    public static final Extent EMPTY = new Extent();

    public Extent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Extent(org.w3c.dom.Element element) {
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
                case ExtentType.refname:
                case ExtentType.shortname:
                    extentType = new ExtentType(e);
                    break;
                case ExtentValue.refname:
                case ExtentValue.shortname:
                    extentValue = new ExtentValue(e);
                    break;
                case ExtentUnit.refname:
                case ExtentUnit.shortname:
                    extentUnit = new ExtentUnit(e);
                    break;
                case ExtentValueRoman.refname:
                case ExtentValueRoman.shortname:
                    extentValueRoman = new ExtentValueRoman(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Extent&gt; or &lt;extent&gt;) is explicitly provided in the ONIX XML
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

    private ExtentType extentType = ExtentType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ExtentType extentType() {
        _initialize();
        return extentType;
    }

    private ExtentValue extentValue = ExtentValue.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ExtentValue extentValue() {
        _initialize();
        return extentValue;
    }

    private ExtentUnit extentUnit = ExtentUnit.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ExtentUnit extentUnit() {
        _initialize();
        return extentUnit;
    }

    private ExtentValueRoman extentValueRoman = ExtentValueRoman.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ExtentValueRoman extentValueRoman() {
        _initialize();
        return extentValueRoman;
    }

    @Override
    public JonixExtent asStruct() {
        _initialize();
        JonixExtent struct = new JonixExtent();
        struct.extentType = extentType.value;
        struct.extentUnit = extentUnit.value;
        struct.extentValue = extentValue.value;
        return struct;
    }

    @Override
    public ExtentTypes structKey() {
        return extentType().value;
    }
}
