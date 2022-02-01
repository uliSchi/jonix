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
import com.tectonica.jonix.common.codelist.PriceConditionQuantityTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPriceConditionQuantity;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PriceCondition}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link PriceCondition} ⯈ {@link PriceConditionQuantity}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link PriceCondition} ⯈ {@link PriceConditionQuantity}</li>
 * </ul>
 */
public class PriceConditionQuantity
    implements OnixDataCompositeWithKey<JonixPriceConditionQuantity, PriceConditionQuantityTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PriceConditionQuantity";
    public static final String shortname = "priceconditionquantity";

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
    public static final PriceConditionQuantity EMPTY = new PriceConditionQuantity();

    public PriceConditionQuantity() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PriceConditionQuantity(org.w3c.dom.Element element) {
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
                case PriceConditionQuantityType.refname:
                case PriceConditionQuantityType.shortname:
                    priceConditionQuantityType = new PriceConditionQuantityType(e);
                    break;
                case Quantity.refname:
                case Quantity.shortname:
                    quantity = new Quantity(e);
                    break;
                case QuantityUnit.refname:
                case QuantityUnit.shortname:
                    quantityUnit = new QuantityUnit(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PriceConditionQuantity&gt; or &lt;priceconditionquantity&gt;) is explicitly
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

    private PriceConditionQuantityType priceConditionQuantityType = PriceConditionQuantityType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public PriceConditionQuantityType priceConditionQuantityType() {
        _initialize();
        return priceConditionQuantityType;
    }

    private Quantity quantity = Quantity.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public Quantity quantity() {
        _initialize();
        return quantity;
    }

    private QuantityUnit quantityUnit = QuantityUnit.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public QuantityUnit quantityUnit() {
        _initialize();
        return quantityUnit;
    }

    @Override
    public JonixPriceConditionQuantity asStruct() {
        _initialize();
        JonixPriceConditionQuantity struct = new JonixPriceConditionQuantity();
        struct.priceConditionQuantityType = priceConditionQuantityType.value;
        struct.quantity = quantity.value;
        struct.quantityUnit = quantityUnit.value;
        return struct;
    }

    @Override
    public PriceConditionQuantityTypes structKey() {
        return priceConditionQuantityType().value;
    }
}
