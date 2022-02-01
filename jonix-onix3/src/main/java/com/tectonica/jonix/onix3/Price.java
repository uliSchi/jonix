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
import com.tectonica.jonix.common.codelist.DiscountCodeTypes;
import com.tectonica.jonix.common.codelist.EpublicationTechnicalProtections;
import com.tectonica.jonix.common.codelist.PriceDateRoles;
import com.tectonica.jonix.common.codelist.PriceIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixBatchBonus;
import com.tectonica.jonix.common.struct.JonixDiscount;
import com.tectonica.jonix.common.struct.JonixDiscountCoded;
import com.tectonica.jonix.common.struct.JonixPriceDate;
import com.tectonica.jonix.common.struct.JonixPriceIdentifier;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Reissue}&gt;</li>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price}</li>
 * </ul>
 */
public class Price implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Price";
    public static final String shortname = "price";

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
    public static final Price EMPTY = new Price();

    public Price() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Price(org.w3c.dom.Element element) {
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
                case PriceType.refname:
                case PriceType.shortname:
                    priceType = new PriceType(e);
                    break;
                case PriceQualifier.refname:
                case PriceQualifier.shortname:
                    priceQualifier = new PriceQualifier(e);
                    break;
                case EpubLicense.refname:
                case EpubLicense.shortname:
                    epubLicense = new EpubLicense(e);
                    break;
                case PricePer.refname:
                case PricePer.shortname:
                    pricePer = new PricePer(e);
                    break;
                case MinimumOrderQuantity.refname:
                case MinimumOrderQuantity.shortname:
                    minimumOrderQuantity = new MinimumOrderQuantity(e);
                    break;
                case PriceStatus.refname:
                case PriceStatus.shortname:
                    priceStatus = new PriceStatus(e);
                    break;
                case PriceAmount.refname:
                case PriceAmount.shortname:
                    priceAmount = new PriceAmount(e);
                    break;
                case PriceCoded.refname:
                case PriceCoded.shortname:
                    priceCoded = new PriceCoded(e);
                    break;
                case TaxExempt.refname:
                case TaxExempt.shortname:
                    taxExempt = new TaxExempt(e);
                    break;
                case UnpricedItemType.refname:
                case UnpricedItemType.shortname:
                    unpricedItemType = new UnpricedItemType(e);
                    break;
                case CurrencyCode.refname:
                case CurrencyCode.shortname:
                    currencyCode = new CurrencyCode(e);
                    break;
                case Territory.refname:
                case Territory.shortname:
                    territory = new Territory(e);
                    break;
                case CurrencyZone.refname:
                case CurrencyZone.shortname:
                    currencyZone = new CurrencyZone(e);
                    break;
                case PrintedOnProduct.refname:
                case PrintedOnProduct.shortname:
                    printedOnProduct = new PrintedOnProduct(e);
                    break;
                case PositionOnProduct.refname:
                case PositionOnProduct.shortname:
                    positionOnProduct = new PositionOnProduct(e);
                    break;
                case PriceIdentifier.refname:
                case PriceIdentifier.shortname:
                    priceIdentifiers = JPU.addToList(priceIdentifiers, new PriceIdentifier(e));
                    break;
                case EpubTechnicalProtection.refname:
                case EpubTechnicalProtection.shortname:
                    epubTechnicalProtections = JPU.addToList(epubTechnicalProtections, new EpubTechnicalProtection(e));
                    break;
                case PriceConstraint.refname:
                case PriceConstraint.shortname:
                    priceConstraints = JPU.addToList(priceConstraints, new PriceConstraint(e));
                    break;
                case PriceTypeDescription.refname:
                case PriceTypeDescription.shortname:
                    priceTypeDescriptions = JPU.addToList(priceTypeDescriptions, new PriceTypeDescription(e));
                    break;
                case PriceCondition.refname:
                case PriceCondition.shortname:
                    priceConditions = JPU.addToList(priceConditions, new PriceCondition(e));
                    break;
                case BatchBonus.refname:
                case BatchBonus.shortname:
                    batchBonuss = JPU.addToList(batchBonuss, new BatchBonus(e));
                    break;
                case DiscountCoded.refname:
                case DiscountCoded.shortname:
                    discountCodeds = JPU.addToList(discountCodeds, new DiscountCoded(e));
                    break;
                case Discount.refname:
                case Discount.shortname:
                    discounts = JPU.addToList(discounts, new Discount(e));
                    break;
                case Tax.refname:
                case Tax.shortname:
                    taxs = JPU.addToList(taxs, new Tax(e));
                    break;
                case ComparisonProductPrice.refname:
                case ComparisonProductPrice.shortname:
                    comparisonProductPrices = JPU.addToList(comparisonProductPrices, new ComparisonProductPrice(e));
                    break;
                case PriceDate.refname:
                case PriceDate.shortname:
                    priceDates = JPU.addToList(priceDates, new PriceDate(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Price&gt; or &lt;price&gt;) is explicitly provided in the ONIX XML
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

    private PriceType priceType = PriceType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PriceType priceType() {
        _initialize();
        return priceType;
    }

    private PriceQualifier priceQualifier = PriceQualifier.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PriceQualifier priceQualifier() {
        _initialize();
        return priceQualifier;
    }

    private EpubLicense epubLicense = EpubLicense.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EpubLicense epubLicense() {
        _initialize();
        return epubLicense;
    }

    private PricePer pricePer = PricePer.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PricePer pricePer() {
        _initialize();
        return pricePer;
    }

    private MinimumOrderQuantity minimumOrderQuantity = MinimumOrderQuantity.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public MinimumOrderQuantity minimumOrderQuantity() {
        _initialize();
        return minimumOrderQuantity;
    }

    private PriceStatus priceStatus = PriceStatus.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PriceStatus priceStatus() {
        _initialize();
        return priceStatus;
    }

    private PriceAmount priceAmount = PriceAmount.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PriceAmount priceAmount() {
        _initialize();
        return priceAmount;
    }

    private PriceCoded priceCoded = PriceCoded.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PriceCoded priceCoded() {
        _initialize();
        return priceCoded;
    }

    private TaxExempt taxExempt = TaxExempt.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TaxExempt taxExempt() {
        _initialize();
        return taxExempt;
    }

    public boolean isTaxExempt() {
        return (taxExempt().exists());
    }

    private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public UnpricedItemType unpricedItemType() {
        _initialize();
        return unpricedItemType;
    }

    private CurrencyCode currencyCode = CurrencyCode.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CurrencyCode currencyCode() {
        _initialize();
        return currencyCode;
    }

    private Territory territory = Territory.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public Territory territory() {
        _initialize();
        return territory;
    }

    private CurrencyZone currencyZone = CurrencyZone.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CurrencyZone currencyZone() {
        _initialize();
        return currencyZone;
    }

    private PrintedOnProduct printedOnProduct = PrintedOnProduct.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PrintedOnProduct printedOnProduct() {
        _initialize();
        return printedOnProduct;
    }

    private PositionOnProduct positionOnProduct = PositionOnProduct.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PositionOnProduct positionOnProduct() {
        _initialize();
        return positionOnProduct;
    }

    private ListOfOnixDataCompositeWithKey<PriceIdentifier, JonixPriceIdentifier, PriceIdentifierTypes>
        priceIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PriceIdentifier, JonixPriceIdentifier, PriceIdentifierTypes>
        priceIdentifiers() {
        _initialize();
        return priceIdentifiers;
    }

    private ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections =
        ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections() {
        _initialize();
        return epubTechnicalProtections;
    }

    private List<PriceConstraint> priceConstraints = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<PriceConstraint> priceConstraints() {
        _initialize();
        return priceConstraints;
    }

    private ListOfOnixElement<PriceTypeDescription, String> priceTypeDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PriceTypeDescription, String> priceTypeDescriptions() {
        _initialize();
        return priceTypeDescriptions;
    }

    private List<PriceCondition> priceConditions = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<PriceCondition> priceConditions() {
        _initialize();
        return priceConditions;
    }

    private ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<BatchBonus, JonixBatchBonus> batchBonuss() {
        _initialize();
        return batchBonuss;
    }

    private ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<DiscountCoded, JonixDiscountCoded, DiscountCodeTypes> discountCodeds() {
        _initialize();
        return discountCodeds;
    }

    private ListOfOnixDataComposite<Discount, JonixDiscount> discounts = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Discount, JonixDiscount> discounts() {
        _initialize();
        return discounts;
    }

    private List<Tax> taxs = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Tax> taxs() {
        _initialize();
        return taxs;
    }

    private List<ComparisonProductPrice> comparisonProductPrices = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<ComparisonProductPrice> comparisonProductPrices() {
        _initialize();
        return comparisonProductPrices;
    }

    private ListOfOnixDataCompositeWithKey<PriceDate, JonixPriceDate, PriceDateRoles> priceDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PriceDate, JonixPriceDate, PriceDateRoles> priceDates() {
        _initialize();
        return priceDates;
    }
}
