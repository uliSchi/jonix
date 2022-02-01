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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Conference}</li>
 * </ul>
 */
public class Conference implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Conference";
    public static final String shortname = "conference";

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
    public static final Conference EMPTY = new Conference();

    public Conference() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Conference(org.w3c.dom.Element element) {
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
                case ConferenceName.refname:
                case ConferenceName.shortname:
                    conferenceName = new ConferenceName(e);
                    break;
                case ConferenceRole.refname:
                case ConferenceRole.shortname:
                    conferenceRole = new ConferenceRole(e);
                    break;
                case ConferenceAcronym.refname:
                case ConferenceAcronym.shortname:
                    conferenceAcronym = new ConferenceAcronym(e);
                    break;
                case ConferenceNumber.refname:
                case ConferenceNumber.shortname:
                    conferenceNumber = new ConferenceNumber(e);
                    break;
                case ConferenceTheme.refname:
                case ConferenceTheme.shortname:
                    conferenceTheme = new ConferenceTheme(e);
                    break;
                case ConferenceDate.refname:
                case ConferenceDate.shortname:
                    conferenceDate = new ConferenceDate(e);
                    break;
                case ConferencePlace.refname:
                case ConferencePlace.shortname:
                    conferencePlace = new ConferencePlace(e);
                    break;
                case ConferenceSponsor.refname:
                case ConferenceSponsor.shortname:
                    conferenceSponsors = JPU.addToList(conferenceSponsors, new ConferenceSponsor(e));
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
     * @return whether this tag (&lt;Conference&gt; or &lt;conference&gt;) is explicitly provided in the ONIX XML
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

    private ConferenceName conferenceName = ConferenceName.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ConferenceName conferenceName() {
        _initialize();
        return conferenceName;
    }

    private ConferenceRole conferenceRole = ConferenceRole.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ConferenceRole conferenceRole() {
        _initialize();
        return conferenceRole;
    }

    private ConferenceAcronym conferenceAcronym = ConferenceAcronym.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ConferenceAcronym conferenceAcronym() {
        _initialize();
        return conferenceAcronym;
    }

    private ConferenceNumber conferenceNumber = ConferenceNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ConferenceNumber conferenceNumber() {
        _initialize();
        return conferenceNumber;
    }

    private ConferenceTheme conferenceTheme = ConferenceTheme.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ConferenceTheme conferenceTheme() {
        _initialize();
        return conferenceTheme;
    }

    private ConferenceDate conferenceDate = ConferenceDate.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ConferenceDate conferenceDate() {
        _initialize();
        return conferenceDate;
    }

    private ConferencePlace conferencePlace = ConferencePlace.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ConferencePlace conferencePlace() {
        _initialize();
        return conferencePlace;
    }

    private List<ConferenceSponsor> conferenceSponsors = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<ConferenceSponsor> conferenceSponsors() {
        _initialize();
        return conferenceSponsors;
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
