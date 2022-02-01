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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.common.codelist.SupplierOwnCodeTypes;
import com.tectonica.jonix.common.codelist.SupplyDateRoles;
import com.tectonica.jonix.common.struct.JonixReturnsConditions;
import com.tectonica.jonix.common.struct.JonixSupplierOwnCoding;
import com.tectonica.jonix.common.struct.JonixSupplyDate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ProductSupply}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail}</li>
 * </ul>
 */
public class SupplyDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplyDetail";
    public static final String shortname = "supplydetail";

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
    public static final SupplyDetail EMPTY = new SupplyDetail();

    public SupplyDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupplyDetail(org.w3c.dom.Element element) {
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
                case Supplier.refname:
                case Supplier.shortname:
                    supplier = new Supplier(e);
                    break;
                case ProductAvailability.refname:
                case ProductAvailability.shortname:
                    productAvailability = new ProductAvailability(e);
                    break;
                case OrderTime.refname:
                case OrderTime.shortname:
                    orderTime = new OrderTime(e);
                    break;
                case NewSupplier.refname:
                case NewSupplier.shortname:
                    newSupplier = new NewSupplier(e);
                    break;
                case PackQuantity.refname:
                case PackQuantity.shortname:
                    packQuantity = new PackQuantity(e);
                    break;
                case PalletQuantity.refname:
                case PalletQuantity.shortname:
                    palletQuantity = new PalletQuantity(e);
                    break;
                case OrderQuantityMultiple.refname:
                case OrderQuantityMultiple.shortname:
                    orderQuantityMultiple = new OrderQuantityMultiple(e);
                    break;
                case UnpricedItemType.refname:
                case UnpricedItemType.shortname:
                    unpricedItemType = new UnpricedItemType(e);
                    break;
                case Reissue.refname:
                case Reissue.shortname:
                    reissue = new Reissue(e);
                    break;
                case SupplyContact.refname:
                case SupplyContact.shortname:
                    supplyContacts = JPU.addToList(supplyContacts, new SupplyContact(e));
                    break;
                case SupplierOwnCoding.refname:
                case SupplierOwnCoding.shortname:
                    supplierOwnCodings = JPU.addToList(supplierOwnCodings, new SupplierOwnCoding(e));
                    break;
                case ReturnsConditions.refname:
                case ReturnsConditions.shortname:
                    returnsConditionss = JPU.addToList(returnsConditionss, new ReturnsConditions(e));
                    break;
                case SupplyDate.refname:
                case SupplyDate.shortname:
                    supplyDates = JPU.addToList(supplyDates, new SupplyDate(e));
                    break;
                case Stock.refname:
                case Stock.shortname:
                    stocks = JPU.addToList(stocks, new Stock(e));
                    break;
                case OrderQuantityMinimum.refname:
                case OrderQuantityMinimum.shortname:
                    orderQuantityMinimums = JPU.addToList(orderQuantityMinimums, new OrderQuantityMinimum(e));
                    break;
                case Price.refname:
                case Price.shortname:
                    prices = JPU.addToList(prices, new Price(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupplyDetail&gt; or &lt;supplydetail&gt;) is explicitly provided in the ONIX XML
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

    private Supplier supplier = Supplier.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public Supplier supplier() {
        _initialize();
        return supplier;
    }

    private ProductAvailability productAvailability = ProductAvailability.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ProductAvailability productAvailability() {
        _initialize();
        return productAvailability;
    }

    private OrderTime orderTime = OrderTime.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public OrderTime orderTime() {
        _initialize();
        return orderTime;
    }

    private NewSupplier newSupplier = NewSupplier.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NewSupplier newSupplier() {
        _initialize();
        return newSupplier;
    }

    private PackQuantity packQuantity = PackQuantity.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PackQuantity packQuantity() {
        _initialize();
        return packQuantity;
    }

    private PalletQuantity palletQuantity = PalletQuantity.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PalletQuantity palletQuantity() {
        _initialize();
        return palletQuantity;
    }

    private OrderQuantityMultiple orderQuantityMultiple = OrderQuantityMultiple.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public OrderQuantityMultiple orderQuantityMultiple() {
        _initialize();
        return orderQuantityMultiple;
    }

    private UnpricedItemType unpricedItemType = UnpricedItemType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public UnpricedItemType unpricedItemType() {
        _initialize();
        return unpricedItemType;
    }

    private Reissue reissue = Reissue.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public Reissue reissue() {
        _initialize();
        return reissue;
    }

    private List<SupplyContact> supplyContacts = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<SupplyContact> supplyContacts() {
        _initialize();
        return supplyContacts;
    }

    private ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding, SupplierOwnCodeTypes>
        supplierOwnCodings = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SupplierOwnCoding, JonixSupplierOwnCoding, SupplierOwnCodeTypes>
        supplierOwnCodings() {
        _initialize();
        return supplierOwnCodings;
    }

    private ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions, ReturnsConditionsCodeTypes>
        returnsConditionss = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ReturnsConditions, JonixReturnsConditions, ReturnsConditionsCodeTypes>
        returnsConditionss() {
        _initialize();
        return returnsConditionss;
    }

    private ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<SupplyDate, JonixSupplyDate, SupplyDateRoles> supplyDates() {
        _initialize();
        return supplyDates;
    }

    private List<Stock> stocks = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Stock> stocks() {
        _initialize();
        return stocks;
    }

    private ListOfOnixElement<OrderQuantityMinimum, Integer> orderQuantityMinimums = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<OrderQuantityMinimum, Integer> orderQuantityMinimums() {
        _initialize();
        return orderQuantityMinimums;
    }

    private List<Price> prices = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Price> prices() {
        _initialize();
        return prices;
    }
}
