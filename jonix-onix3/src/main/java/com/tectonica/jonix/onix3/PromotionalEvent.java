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
import com.tectonica.jonix.common.codelist.ContentAudiences;
import com.tectonica.jonix.common.codelist.EventIdentifierTypes;
import com.tectonica.jonix.common.codelist.EventTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEventIdentifier;
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
 * <li>&lt;{@link PromotionDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent}</li>
 * </ul>
 */
public class PromotionalEvent implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PromotionalEvent";
    public static final String shortname = "promotionalevent";

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
    public static final PromotionalEvent EMPTY = new PromotionalEvent();

    public PromotionalEvent() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PromotionalEvent(org.w3c.dom.Element element) {
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
                case EventType.refname:
                case EventType.shortname:
                    eventTypes = JPU.addToList(eventTypes, new EventType(e));
                    break;
                case ContentAudience.refname:
                case ContentAudience.shortname:
                    contentAudiences = JPU.addToList(contentAudiences, new ContentAudience(e));
                    break;
                case EventName.refname:
                case EventName.shortname:
                    eventNames = JPU.addToList(eventNames, new EventName(e));
                    break;
                case ContributorReference.refname:
                case ContributorReference.shortname:
                    contributorReferences = JPU.addToList(contributorReferences, new ContributorReference(e));
                    break;
                case EventOccurrence.refname:
                case EventOccurrence.shortname:
                    eventOccurrences = JPU.addToList(eventOccurrences, new EventOccurrence(e));
                    break;
                case EventStatus.refname:
                case EventStatus.shortname:
                    eventStatus = new EventStatus(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case EventIdentifier.refname:
                case EventIdentifier.shortname:
                    eventIdentifiers = JPU.addToList(eventIdentifiers, new EventIdentifier(e));
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
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
     * @return whether this tag (&lt;PromotionalEvent&gt; or &lt;promotionalevent&gt;) is explicitly provided in the
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

    private ListOfOnixElement<EventType, EventTypes> eventTypes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<EventType, EventTypes> eventTypes() {
        _initialize();
        return eventTypes;
    }

    private ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<ContentAudience, ContentAudiences> contentAudiences() {
        _initialize();
        return contentAudiences;
    }

    private ListOfOnixElement<EventName, String> eventNames = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<EventName, String> eventNames() {
        _initialize();
        return eventNames;
    }

    private List<ContributorReference> contributorReferences = Collections.emptyList();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<ContributorReference> contributorReferences() {
        _initialize();
        return contributorReferences;
    }

    private List<EventOccurrence> eventOccurrences = Collections.emptyList();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<EventOccurrence> eventOccurrences() {
        _initialize();
        return eventOccurrences;
    }

    private EventStatus eventStatus = EventStatus.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EventStatus eventStatus() {
        _initialize();
        return eventStatus;
    }

    private NoContributor noContributor = NoContributor.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NoContributor noContributor() {
        _initialize();
        return noContributor;
    }

    public boolean isNoContributor() {
        return (noContributor().exists());
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

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
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
