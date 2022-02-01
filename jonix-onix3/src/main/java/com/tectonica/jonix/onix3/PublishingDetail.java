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
import com.tectonica.jonix.common.codelist.PublishingDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPublishingDate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PublishingDetail}</li>
 * </ul>
 */
public class PublishingDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PublishingDetail";
    public static final String shortname = "publishingdetail";

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
    public static final PublishingDetail EMPTY = new PublishingDetail();

    public PublishingDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PublishingDetail(org.w3c.dom.Element element) {
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
                case Imprint.refname:
                case Imprint.shortname:
                    imprints = JPU.addToList(imprints, new Imprint(e));
                    break;
                case CountryOfPublication.refname:
                case CountryOfPublication.shortname:
                    countryOfPublication = new CountryOfPublication(e);
                    break;
                case PublishingStatus.refname:
                case PublishingStatus.shortname:
                    publishingStatus = new PublishingStatus(e);
                    break;
                case LatestReprintNumber.refname:
                case LatestReprintNumber.shortname:
                    latestReprintNumber = new LatestReprintNumber(e);
                    break;
                case ROWSalesRightsType.refname:
                case ROWSalesRightsType.shortname:
                    rowSalesRightsType = new ROWSalesRightsType(e);
                    break;
                case Publisher.refname:
                case Publisher.shortname:
                    publishers = JPU.addToList(publishers, new Publisher(e));
                    break;
                case CityOfPublication.refname:
                case CityOfPublication.shortname:
                    cityOfPublications = JPU.addToList(cityOfPublications, new CityOfPublication(e));
                    break;
                case ProductContact.refname:
                case ProductContact.shortname:
                    productContacts = JPU.addToList(productContacts, new ProductContact(e));
                    break;
                case PublishingStatusNote.refname:
                case PublishingStatusNote.shortname:
                    publishingStatusNotes = JPU.addToList(publishingStatusNotes, new PublishingStatusNote(e));
                    break;
                case PublishingDate.refname:
                case PublishingDate.shortname:
                    publishingDates = JPU.addToList(publishingDates, new PublishingDate(e));
                    break;
                case CopyrightStatement.refname:
                case CopyrightStatement.shortname:
                    copyrightStatements = JPU.addToList(copyrightStatements, new CopyrightStatement(e));
                    break;
                case SalesRights.refname:
                case SalesRights.shortname:
                    salesRightss = JPU.addToList(salesRightss, new SalesRights(e));
                    break;
                case SalesRestriction.refname:
                case SalesRestriction.shortname:
                    salesRestrictions = JPU.addToList(salesRestrictions, new SalesRestriction(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PublishingDetail&gt; or &lt;publishingdetail&gt;) is explicitly provided in the
     *         ONIX XML
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

    private List<Imprint> imprints = Collections.emptyList();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<Imprint> imprints() {
        _initialize();
        return imprints;
    }

    private CountryOfPublication countryOfPublication = CountryOfPublication.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CountryOfPublication countryOfPublication() {
        _initialize();
        return countryOfPublication;
    }

    private PublishingStatus publishingStatus = PublishingStatus.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PublishingStatus publishingStatus() {
        _initialize();
        return publishingStatus;
    }

    private LatestReprintNumber latestReprintNumber = LatestReprintNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public LatestReprintNumber latestReprintNumber() {
        _initialize();
        return latestReprintNumber;
    }

    private ROWSalesRightsType rowSalesRightsType = ROWSalesRightsType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ROWSalesRightsType rowSalesRightsType() {
        _initialize();
        return rowSalesRightsType;
    }

    private List<Publisher> publishers = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Publisher> publishers() {
        _initialize();
        return publishers;
    }

    private ListOfOnixElement<CityOfPublication, String> cityOfPublications = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<CityOfPublication, String> cityOfPublications() {
        _initialize();
        return cityOfPublications;
    }

    private List<ProductContact> productContacts = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<ProductContact> productContacts() {
        _initialize();
        return productContacts;
    }

    private ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PublishingStatusNote, String> publishingStatusNotes() {
        _initialize();
        return publishingStatusNotes;
    }

    private ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<PublishingDate, JonixPublishingDate, PublishingDateRoles> publishingDates() {
        _initialize();
        return publishingDates;
    }

    private List<CopyrightStatement> copyrightStatements = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<CopyrightStatement> copyrightStatements() {
        _initialize();
        return copyrightStatements;
    }

    private List<SalesRights> salesRightss = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<SalesRights> salesRightss() {
        _initialize();
        return salesRightss;
    }

    private List<SalesRestriction> salesRestrictions = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<SalesRestriction> salesRestrictions() {
        _initialize();
        return salesRestrictions;
    }
}
