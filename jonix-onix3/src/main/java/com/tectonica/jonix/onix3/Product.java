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
import com.tectonica.jonix.common.OnixProduct;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixBarcode;
import com.tectonica.jonix.common.struct.JonixProductIdentifier;
import com.tectonica.jonix.common.struct.JonixRecordSourceIdentifier;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product}</li>
 * </ul>
 */
public class Product implements OnixProduct, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Product";
    public static final String shortname = "product";

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
    public static final Product EMPTY = new Product();

    public Product() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Product(org.w3c.dom.Element element) {
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
                case RecordReference.refname:
                case RecordReference.shortname:
                    recordReference = new RecordReference(e);
                    break;
                case NotificationType.refname:
                case NotificationType.shortname:
                    notificationType = new NotificationType(e);
                    break;
                case ProductIdentifier.refname:
                case ProductIdentifier.shortname:
                    productIdentifiers = JPU.addToList(productIdentifiers, new ProductIdentifier(e));
                    break;
                case RecordSourceType.refname:
                case RecordSourceType.shortname:
                    recordSourceType = new RecordSourceType(e);
                    break;
                case RecordSourceName.refname:
                case RecordSourceName.shortname:
                    recordSourceName = new RecordSourceName(e);
                    break;
                case DescriptiveDetail.refname:
                case DescriptiveDetail.shortname:
                    descriptiveDetail = new DescriptiveDetail(e);
                    break;
                case CollateralDetail.refname:
                case CollateralDetail.shortname:
                    collateralDetail = new CollateralDetail(e);
                    break;
                case PromotionDetail.refname:
                case PromotionDetail.shortname:
                    promotionDetail = new PromotionDetail(e);
                    break;
                case ContentDetail.refname:
                case ContentDetail.shortname:
                    contentDetail = new ContentDetail(e);
                    break;
                case PublishingDetail.refname:
                case PublishingDetail.shortname:
                    publishingDetail = new PublishingDetail(e);
                    break;
                case RelatedMaterial.refname:
                case RelatedMaterial.shortname:
                    relatedMaterial = new RelatedMaterial(e);
                    break;
                case ProductionDetail.refname:
                case ProductionDetail.shortname:
                    productionDetail = new ProductionDetail(e);
                    break;
                case DeletionText.refname:
                case DeletionText.shortname:
                    deletionTexts = JPU.addToList(deletionTexts, new DeletionText(e));
                    break;
                case RecordSourceIdentifier.refname:
                case RecordSourceIdentifier.shortname:
                    recordSourceIdentifiers = JPU.addToList(recordSourceIdentifiers, new RecordSourceIdentifier(e));
                    break;
                case Barcode.refname:
                case Barcode.shortname:
                    barcodes = JPU.addToList(barcodes, new Barcode(e));
                    break;
                case ProductSupply.refname:
                case ProductSupply.shortname:
                    productSupplys = JPU.addToList(productSupplys, new ProductSupply(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Product&gt; or &lt;product&gt;) is explicitly provided in the ONIX XML
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

    private RecordReference recordReference = RecordReference.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public RecordReference recordReference() {
        _initialize();
        return recordReference;
    }

    private NotificationType notificationType = NotificationType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public NotificationType notificationType() {
        _initialize();
        return notificationType;
    }

    private ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<ProductIdentifier, JonixProductIdentifier, ProductIdentifierTypes>
        productIdentifiers() {
        _initialize();
        return productIdentifiers;
    }

    private RecordSourceType recordSourceType = RecordSourceType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public RecordSourceType recordSourceType() {
        _initialize();
        return recordSourceType;
    }

    private RecordSourceName recordSourceName = RecordSourceName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public RecordSourceName recordSourceName() {
        _initialize();
        return recordSourceName;
    }

    private DescriptiveDetail descriptiveDetail = DescriptiveDetail.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public DescriptiveDetail descriptiveDetail() {
        _initialize();
        return descriptiveDetail;
    }

    private CollateralDetail collateralDetail = CollateralDetail.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CollateralDetail collateralDetail() {
        _initialize();
        return collateralDetail;
    }

    private PromotionDetail promotionDetail = PromotionDetail.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PromotionDetail promotionDetail() {
        _initialize();
        return promotionDetail;
    }

    private ContentDetail contentDetail = ContentDetail.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ContentDetail contentDetail() {
        _initialize();
        return contentDetail;
    }

    private PublishingDetail publishingDetail = PublishingDetail.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PublishingDetail publishingDetail() {
        _initialize();
        return publishingDetail;
    }

    private RelatedMaterial relatedMaterial = RelatedMaterial.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public RelatedMaterial relatedMaterial() {
        _initialize();
        return relatedMaterial;
    }

    private ProductionDetail productionDetail = ProductionDetail.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ProductionDetail productionDetail() {
        _initialize();
        return productionDetail;
    }

    private ListOfOnixElement<DeletionText, String> deletionTexts = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<DeletionText, String> deletionTexts() {
        _initialize();
        return deletionTexts;
    }

    private ListOfOnixDataCompositeWithKey<RecordSourceIdentifier, JonixRecordSourceIdentifier, NameIdentifierTypes>
        recordSourceIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<RecordSourceIdentifier, JonixRecordSourceIdentifier, NameIdentifierTypes>
        recordSourceIdentifiers() {
        _initialize();
        return recordSourceIdentifiers;
    }

    private ListOfOnixDataComposite<Barcode, JonixBarcode> barcodes = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Barcode, JonixBarcode> barcodes() {
        _initialize();
        return barcodes;
    }

    private List<ProductSupply> productSupplys = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<ProductSupply> productSupplys() {
        _initialize();
        return productSupplys;
    }
}
