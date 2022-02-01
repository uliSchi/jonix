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
import com.tectonica.jonix.common.codelist.PriceCodeTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPriceCoded;

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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link PriceCoded}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceCoded}</li>
 * </ul>
 */
public class PriceCoded implements OnixDataCompositeWithKey<JonixPriceCoded, PriceCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceCoded";
    public static final String shortname = "pricecoded";

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
    public static final PriceCoded EMPTY = new PriceCoded();

    public PriceCoded() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceCoded(org.w3c.dom.Element element) {
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
                case PriceCodeType.refname:
                case PriceCodeType.shortname:
                    priceCodeType = new PriceCodeType(e);
                    break;
                case PriceCode.refname:
                case PriceCode.shortname:
                    priceCode = new PriceCode(e);
                    break;
                case PriceCodeTypeName.refname:
                case PriceCodeTypeName.shortname:
                    priceCodeTypeName = new PriceCodeTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PriceCoded&gt; or &lt;pricecoded&gt;) is explicitly provided in the ONIX XML
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

    private PriceCodeType priceCodeType = PriceCodeType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public PriceCodeType priceCodeType() {
        _initialize();
        return priceCodeType;
    }

    private PriceCode priceCode = PriceCode.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public PriceCode priceCode() {
        _initialize();
        return priceCode;
    }

    private PriceCodeTypeName priceCodeTypeName = PriceCodeTypeName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PriceCodeTypeName priceCodeTypeName() {
        _initialize();
        return priceCodeTypeName;
    }

    @Override
    public JonixPriceCoded asStruct() {
        _initialize();
        JonixPriceCoded struct = new JonixPriceCoded();
        struct.priceCodeType = priceCodeType.value;
        struct.priceCodeTypeName = priceCodeTypeName.value;
        struct.priceCode = priceCode.value;
        return struct;
    }

    @Override
    public PriceCodeTypes structKey() {
        return priceCodeType().value;
    }
}
