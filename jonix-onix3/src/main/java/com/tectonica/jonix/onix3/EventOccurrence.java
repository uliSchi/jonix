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
import com.tectonica.jonix.common.codelist.EventIdentifierTypes;
import com.tectonica.jonix.common.codelist.EventOccurrenceDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEventIdentifier;
import com.tectonica.jonix.common.struct.JonixOccurrenceDate;
import com.tectonica.jonix.common.struct.JonixWebsite;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link PromotionalEvent}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence}</li>
 * </ul>
 */
public class EventOccurrence implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EventOccurrence";
    public static final String shortname = "eventoccurrence";

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
    public static final EventOccurrence EMPTY = new EventOccurrence();

    public EventOccurrence() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EventOccurrence(org.w3c.dom.Element element) {
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
                case EventStatus.refname:
                case EventStatus.shortname:
                    eventStatus = new EventStatus(e);
                    break;
                case CountryCode.refname:
                case CountryCode.shortname:
                    countryCode = new CountryCode(e);
                    break;
                case OccurrenceDate.refname:
                case OccurrenceDate.shortname:
                    occurrenceDates = JPU.addToList(occurrenceDates, new OccurrenceDate(e));
                    break;
                case RegionCode.refname:
                case RegionCode.shortname:
                    regionCode = new RegionCode(e);
                    break;
                case VenueName.refname:
                case VenueName.shortname:
                    venueName = new VenueName(e);
                    break;
                case StreetAddress.refname:
                case StreetAddress.shortname:
                    streetAddress = new StreetAddress(e);
                    break;
                case EventIdentifier.refname:
                case EventIdentifier.shortname:
                    eventIdentifiers = JPU.addToList(eventIdentifiers, new EventIdentifier(e));
                    break;
                case LocationName.refname:
                case LocationName.shortname:
                    locationNames = JPU.addToList(locationNames, new LocationName(e));
                    break;
                case VenueNote.refname:
                case VenueNote.shortname:
                    venueNotes = JPU.addToList(venueNotes, new VenueNote(e));
                    break;
                case EventDescription.refname:
                case EventDescription.shortname:
                    eventDescriptions = JPU.addToList(eventDescriptions, new EventDescription(e));
                    break;
                case SupportingResource.refname:
                case SupportingResource.shortname:
                    supportingResources = JPU.addToList(supportingResources, new SupportingResource(e));
                    break;
                case EventSponsor.refname:
                case EventSponsor.shortname:
                    eventSponsors = JPU.addToList(eventSponsors, new EventSponsor(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;EventOccurrence&gt; or &lt;eventoccurrence&gt;) is explicitly provided in the ONIX
     *         XML
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

    private EventStatus eventStatus = EventStatus.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public EventStatus eventStatus() {
        _initialize();
        return eventStatus;
    }

    private CountryCode countryCode = CountryCode.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public CountryCode countryCode() {
        _initialize();
        return countryCode;
    }

    private ListOfOnixDataCompositeWithKey<OccurrenceDate, JonixOccurrenceDate, EventOccurrenceDateRoles>
        occurrenceDates = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<OccurrenceDate, JonixOccurrenceDate, EventOccurrenceDateRoles>
        occurrenceDates() {
        _initialize();
        return occurrenceDates;
    }

    private RegionCode regionCode = RegionCode.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public RegionCode regionCode() {
        _initialize();
        return regionCode;
    }

    private VenueName venueName = VenueName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public VenueName venueName() {
        _initialize();
        return venueName;
    }

    private StreetAddress streetAddress = StreetAddress.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public StreetAddress streetAddress() {
        _initialize();
        return streetAddress;
    }

    private ListOfOnixDataCompositeWithKey<EventIdentifier, JonixEventIdentifier, EventIdentifierTypes>
        eventIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<EventIdentifier, JonixEventIdentifier, EventIdentifierTypes>
        eventIdentifiers() {
        _initialize();
        return eventIdentifiers;
    }

    private ListOfOnixElement<LocationName, String> locationNames = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<LocationName, String> locationNames() {
        _initialize();
        return locationNames;
    }

    private ListOfOnixElement<VenueNote, String> venueNotes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<VenueNote, String> venueNotes() {
        _initialize();
        return venueNotes;
    }

    private ListOfOnixElement<EventDescription, String> eventDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EventDescription, String> eventDescriptions() {
        _initialize();
        return eventDescriptions;
    }

    private List<SupportingResource> supportingResources = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<SupportingResource> supportingResources() {
        _initialize();
        return supportingResources;
    }

    private List<EventSponsor> eventSponsors = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<EventSponsor> eventSponsors() {
        _initialize();
        return eventSponsors;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }
}
