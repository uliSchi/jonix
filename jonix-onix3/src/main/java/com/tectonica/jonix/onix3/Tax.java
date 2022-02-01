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
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;

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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link Tax}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Tax}</li>
 * </ul>
 */
public class Tax implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Tax";
    public static final String shortname = "tax";

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
    public static final Tax EMPTY = new Tax();

    public Tax() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Tax(org.w3c.dom.Element element) {
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
                case TaxRatePercent.refname:
                case TaxRatePercent.shortname:
                    taxRatePercent = new TaxRatePercent(e);
                    break;
                case TaxType.refname:
                case TaxType.shortname:
                    taxType = new TaxType(e);
                    break;
                case TaxRateCode.refname:
                case TaxRateCode.shortname:
                    taxRateCode = new TaxRateCode(e);
                    break;
                case TaxableAmount.refname:
                case TaxableAmount.shortname:
                    taxableAmount = new TaxableAmount(e);
                    break;
                case TaxAmount.refname:
                case TaxAmount.shortname:
                    taxAmount = new TaxAmount(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case PricePartDescription.refname:
                case PricePartDescription.shortname:
                    pricePartDescriptions = JPU.addToList(pricePartDescriptions, new PricePartDescription(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Tax&gt; or &lt;tax&gt;) is explicitly provided in the ONIX XML
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

    private TaxRatePercent taxRatePercent = TaxRatePercent.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public TaxRatePercent taxRatePercent() {
        _initialize();
        return taxRatePercent;
    }

    private TaxType taxType = TaxType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TaxType taxType() {
        _initialize();
        return taxType;
    }

    private TaxRateCode taxRateCode = TaxRateCode.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TaxRateCode taxRateCode() {
        _initialize();
        return taxRateCode;
    }

    private TaxableAmount taxableAmount = TaxableAmount.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TaxableAmount taxableAmount() {
        _initialize();
        return taxableAmount;
    }

    private TaxAmount taxAmount = TaxAmount.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TaxAmount taxAmount() {
        _initialize();
        return taxAmount;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private ListOfOnixElement<PricePartDescription, String> pricePartDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PricePartDescription, String> pricePartDescriptions() {
        _initialize();
        return pricePartDescriptions;
    }
}
