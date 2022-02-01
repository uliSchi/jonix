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
import com.tectonica.jonix.common.codelist.CollectionSequenceTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.SeriesIdentifierTypes;
import com.tectonica.jonix.common.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.common.struct.JonixCollectionSequence;

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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection}</li>
 * </ul>
 */
public class Collection implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Collection";
    public static final String shortname = "collection";

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
    public static final Collection EMPTY = new Collection();

    public Collection() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Collection(org.w3c.dom.Element element) {
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
                case CollectionType.refname:
                case CollectionType.shortname:
                    collectionType = new CollectionType(e);
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case SourceName.refname:
                case SourceName.shortname:
                    sourceName = new SourceName(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case CollectionIdentifier.refname:
                case CollectionIdentifier.shortname:
                    collectionIdentifiers = JPU.addToList(collectionIdentifiers, new CollectionIdentifier(e));
                    break;
                case CollectionSequence.refname:
                case CollectionSequence.shortname:
                    collectionSequences = JPU.addToList(collectionSequences, new CollectionSequence(e));
                    break;
                case TitleDetail.refname:
                case TitleDetail.shortname:
                    titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Collection&gt; or &lt;collection&gt;) is explicitly provided in the ONIX XML
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

    private CollectionType collectionType = CollectionType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public CollectionType collectionType() {
        _initialize();
        return collectionType;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private SourceName sourceName = SourceName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SourceName sourceName() {
        _initialize();
        return sourceName;
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

    private ListOfOnixDataCompositeWithKey<CollectionIdentifier, JonixCollectionIdentifier, SeriesIdentifierTypes>
        collectionIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<CollectionIdentifier, JonixCollectionIdentifier, SeriesIdentifierTypes>
        collectionIdentifiers() {
        _initialize();
        return collectionIdentifiers;
    }

    private ListOfOnixDataCompositeWithKey<CollectionSequence, JonixCollectionSequence, CollectionSequenceTypes>
        collectionSequences = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<CollectionSequence, JonixCollectionSequence, CollectionSequenceTypes>
        collectionSequences() {
        _initialize();
        return collectionSequences;
    }

    private List<TitleDetail> titleDetails = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<TitleDetail> titleDetails() {
        _initialize();
        return titleDetails;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
    }
}
