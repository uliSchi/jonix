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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
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
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Event}</li>
 * </ul>
 */
public class Event implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Event";
    public static final String shortname = "event";

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
    public static final Event EMPTY = new Event();

    public Event() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Event(org.w3c.dom.Element element) {
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
                case EventRole.refname:
                case EventRole.shortname:
                    eventRole = new EventRole(e);
                    break;
                case EventName.refname:
                case EventName.shortname:
                    eventNames = JPU.addToList(eventNames, new EventName(e));
                    break;
                case EventNumber.refname:
                case EventNumber.shortname:
                    eventNumber = new EventNumber(e);
                    break;
                case EventDate.refname:
                case EventDate.shortname:
                    eventDate = new EventDate(e);
                    break;
                case EventAcronym.refname:
                case EventAcronym.shortname:
                    eventAcronyms = JPU.addToList(eventAcronyms, new EventAcronym(e));
                    break;
                case EventTheme.refname:
                case EventTheme.shortname:
                    eventThemes = JPU.addToList(eventThemes, new EventTheme(e));
                    break;
                case EventPlace.refname:
                case EventPlace.shortname:
                    eventPlaces = JPU.addToList(eventPlaces, new EventPlace(e));
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
     * @return whether this tag (&lt;Event&gt; or &lt;event&gt;) is explicitly provided in the ONIX XML
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

    private EventRole eventRole = EventRole.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public EventRole eventRole() {
        _initialize();
        return eventRole;
    }

    private ListOfOnixElement<EventName, String> eventNames = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<EventName, String> eventNames() {
        _initialize();
        return eventNames;
    }

    private EventNumber eventNumber = EventNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EventNumber eventNumber() {
        _initialize();
        return eventNumber;
    }

    private EventDate eventDate = EventDate.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EventDate eventDate() {
        _initialize();
        return eventDate;
    }

    private ListOfOnixElement<EventAcronym, String> eventAcronyms = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EventAcronym, String> eventAcronyms() {
        _initialize();
        return eventAcronyms;
    }

    private ListOfOnixElement<EventTheme, String> eventThemes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EventTheme, String> eventThemes() {
        _initialize();
        return eventThemes;
    }

    private ListOfOnixElement<EventPlace, String> eventPlaces = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EventPlace, String> eventPlaces() {
        _initialize();
        return eventPlaces;
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
