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
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEventSponsorIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Event}&gt;</li>
 * <li>&lt;{@link EventOccurrence}&gt;</li>
 * <li>&lt;{@link PromotionalEvent}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Event} ⯈ {@link EventSponsor}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈ {@link EventSponsor}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventSponsor}</li>
 * </ul>
 */
public class EventSponsor implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EventSponsor";
    public static final String shortname = "eventsponsor";

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
    public static final EventSponsor EMPTY = new EventSponsor();

    public EventSponsor() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EventSponsor(org.w3c.dom.Element element) {
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
                case EventSponsorIdentifier.refname:
                case EventSponsorIdentifier.shortname:
                    eventSponsorIdentifiers = JPU.addToList(eventSponsorIdentifiers, new EventSponsorIdentifier(e));
                    break;
                case PersonName.refname:
                case PersonName.shortname:
                    personName = new PersonName(e);
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;EventSponsor&gt; or &lt;eventsponsor&gt;) is explicitly provided in the ONIX XML
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

    private ListOfOnixDataCompositeWithKey<EventSponsorIdentifier, JonixEventSponsorIdentifier, NameIdentifierTypes>
        eventSponsorIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<EventSponsorIdentifier, JonixEventSponsorIdentifier, NameIdentifierTypes>
        eventSponsorIdentifiers() {
        _initialize();
        return eventSponsorIdentifiers;
    }

    private PersonName personName = PersonName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PersonName personName() {
        _initialize();
        return personName;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }
}
