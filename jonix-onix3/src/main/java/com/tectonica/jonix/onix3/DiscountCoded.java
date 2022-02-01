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
import com.tectonica.jonix.common.codelist.DiscountCodeTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixDiscountCoded;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Price}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link DiscountCoded}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link DiscountCoded}</li>
 * </ul>
 */
public class DiscountCoded implements OnixDataCompositeWithKey<JonixDiscountCoded, DiscountCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DiscountCoded";
    public static final String shortname = "discountcoded";

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
    public static final DiscountCoded EMPTY = new DiscountCoded();

    public DiscountCoded() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public DiscountCoded(org.w3c.dom.Element element) {
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
                case DiscountCodeType.refname:
                case DiscountCodeType.shortname:
                    discountCodeType = new DiscountCodeType(e);
                    break;
                case DiscountCode.refname:
                case DiscountCode.shortname:
                    discountCode = new DiscountCode(e);
                    break;
                case DiscountCodeTypeName.refname:
                case DiscountCodeTypeName.shortname:
                    discountCodeTypeName = new DiscountCodeTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;DiscountCoded&gt; or &lt;discountcoded&gt;) is explicitly provided in the ONIX XML
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

    private DiscountCodeType discountCodeType = DiscountCodeType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public DiscountCodeType discountCodeType() {
        _initialize();
        return discountCodeType;
    }

    private DiscountCode discountCode = DiscountCode.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public DiscountCode discountCode() {
        _initialize();
        return discountCode;
    }

    private DiscountCodeTypeName discountCodeTypeName = DiscountCodeTypeName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public DiscountCodeTypeName discountCodeTypeName() {
        _initialize();
        return discountCodeTypeName;
    }

    @Override
    public JonixDiscountCoded asStruct() {
        _initialize();
        JonixDiscountCoded struct = new JonixDiscountCoded();
        struct.discountCodeType = discountCodeType.value;
        struct.discountCode = discountCode.value;
        struct.discountCodeTypeName = discountCodeTypeName.value;
        return struct;
    }

    @Override
    public DiscountCodeTypes structKey() {
        return discountCodeType().value;
    }
}
