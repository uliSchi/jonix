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
import com.tectonica.jonix.common.codelist.ContributorRoles;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.PersonOrganizationDateRoles;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixContributorDate;
import com.tectonica.jonix.common.struct.JonixContributorPlace;
import com.tectonica.jonix.common.struct.JonixNameIdentifier;
import com.tectonica.jonix.common.struct.JonixPrize;
import com.tectonica.jonix.common.struct.JonixProfessionalAffiliation;
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
 * <li>&lt;{@link ContentItem}&gt;</li>
 * <li>&lt;{@link PromotionalEvent}&gt;</li>
 * <li>&lt;{@link Collection}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor}</li>
 * </ul>
 */
public class Contributor implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Contributor";
    public static final String shortname = "contributor";

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
    public static final Contributor EMPTY = new Contributor();

    public Contributor() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Contributor(org.w3c.dom.Element element) {
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
                case PersonName.refname:
                case PersonName.shortname:
                    personName = new PersonName(e);
                    break;
                case KeyNames.refname:
                case KeyNames.shortname:
                    keyNames = new KeyNames(e);
                    break;
                case CorporateName.refname:
                case CorporateName.shortname:
                    corporateName = new CorporateName(e);
                    break;
                case ContributorRole.refname:
                case ContributorRole.shortname:
                    contributorRoles = JPU.addToList(contributorRoles, new ContributorRole(e));
                    break;
                case NameIdentifier.refname:
                case NameIdentifier.shortname:
                    nameIdentifiers = JPU.addToList(nameIdentifiers, new NameIdentifier(e));
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case NameType.refname:
                case NameType.shortname:
                    nameType = new NameType(e);
                    break;
                case PersonNameInverted.refname:
                case PersonNameInverted.shortname:
                    personNameInverted = new PersonNameInverted(e);
                    break;
                case TitlesBeforeNames.refname:
                case TitlesBeforeNames.shortname:
                    titlesBeforeNames = new TitlesBeforeNames(e);
                    break;
                case NamesBeforeKey.refname:
                case NamesBeforeKey.shortname:
                    namesBeforeKey = new NamesBeforeKey(e);
                    break;
                case PrefixToKey.refname:
                case PrefixToKey.shortname:
                    prefixToKey = new PrefixToKey(e);
                    break;
                case NamesAfterKey.refname:
                case NamesAfterKey.shortname:
                    namesAfterKey = new NamesAfterKey(e);
                    break;
                case SuffixToKey.refname:
                case SuffixToKey.shortname:
                    suffixToKey = new SuffixToKey(e);
                    break;
                case LettersAfterNames.refname:
                case LettersAfterNames.shortname:
                    lettersAfterNames = new LettersAfterNames(e);
                    break;
                case TitlesAfterNames.refname:
                case TitlesAfterNames.shortname:
                    titlesAfterNames = new TitlesAfterNames(e);
                    break;
                case Gender.refname:
                case Gender.shortname:
                    gender = new Gender(e);
                    break;
                case CorporateNameInverted.refname:
                case CorporateNameInverted.shortname:
                    corporateNameInverted = new CorporateNameInverted(e);
                    break;
                case UnnamedPersons.refname:
                case UnnamedPersons.shortname:
                    unnamedPersons = new UnnamedPersons(e);
                    break;
                case FromLanguage.refname:
                case FromLanguage.shortname:
                    fromLanguages = JPU.addToList(fromLanguages, new FromLanguage(e));
                    break;
                case ToLanguage.refname:
                case ToLanguage.shortname:
                    toLanguages = JPU.addToList(toLanguages, new ToLanguage(e));
                    break;
                case AlternativeName.refname:
                case AlternativeName.shortname:
                    alternativeNames = JPU.addToList(alternativeNames, new AlternativeName(e));
                    break;
                case ContributorDate.refname:
                case ContributorDate.shortname:
                    contributorDates = JPU.addToList(contributorDates, new ContributorDate(e));
                    break;
                case ProfessionalAffiliation.refname:
                case ProfessionalAffiliation.shortname:
                    professionalAffiliations = JPU.addToList(professionalAffiliations, new ProfessionalAffiliation(e));
                    break;
                case Prize.refname:
                case Prize.shortname:
                    prizes = JPU.addToList(prizes, new Prize(e));
                    break;
                case BiographicalNote.refname:
                case BiographicalNote.shortname:
                    biographicalNotes = JPU.addToList(biographicalNotes, new BiographicalNote(e));
                    break;
                case Website.refname:
                case Website.shortname:
                    websites = JPU.addToList(websites, new Website(e));
                    break;
                case ContributorDescription.refname:
                case ContributorDescription.shortname:
                    contributorDescriptions = JPU.addToList(contributorDescriptions, new ContributorDescription(e));
                    break;
                case ContributorPlace.refname:
                case ContributorPlace.shortname:
                    contributorPlaces = JPU.addToList(contributorPlaces, new ContributorPlace(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Contributor&gt; or &lt;contributor&gt;) is explicitly provided in the ONIX XML
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

    private PersonName personName = PersonName.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public PersonName personName() {
        _initialize();
        return personName;
    }

    private KeyNames keyNames = KeyNames.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public KeyNames keyNames() {
        _initialize();
        return keyNames;
    }

    private CorporateName corporateName = CorporateName.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public CorporateName corporateName() {
        _initialize();
        return corporateName;
    }

    private ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<ContributorRole, ContributorRoles> contributorRoles() {
        _initialize();
        return contributorRoles;
    }

    private ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<NameIdentifier, JonixNameIdentifier, NameIdentifierTypes> nameIdentifiers() {
        _initialize();
        return nameIdentifiers;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private NameType nameType = NameType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NameType nameType() {
        _initialize();
        return nameType;
    }

    private PersonNameInverted personNameInverted = PersonNameInverted.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PersonNameInverted personNameInverted() {
        _initialize();
        return personNameInverted;
    }

    private TitlesBeforeNames titlesBeforeNames = TitlesBeforeNames.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TitlesBeforeNames titlesBeforeNames() {
        _initialize();
        return titlesBeforeNames;
    }

    private NamesBeforeKey namesBeforeKey = NamesBeforeKey.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NamesBeforeKey namesBeforeKey() {
        _initialize();
        return namesBeforeKey;
    }

    private PrefixToKey prefixToKey = PrefixToKey.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PrefixToKey prefixToKey() {
        _initialize();
        return prefixToKey;
    }

    private NamesAfterKey namesAfterKey = NamesAfterKey.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NamesAfterKey namesAfterKey() {
        _initialize();
        return namesAfterKey;
    }

    private SuffixToKey suffixToKey = SuffixToKey.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SuffixToKey suffixToKey() {
        _initialize();
        return suffixToKey;
    }

    private LettersAfterNames lettersAfterNames = LettersAfterNames.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public LettersAfterNames lettersAfterNames() {
        _initialize();
        return lettersAfterNames;
    }

    private TitlesAfterNames titlesAfterNames = TitlesAfterNames.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TitlesAfterNames titlesAfterNames() {
        _initialize();
        return titlesAfterNames;
    }

    private Gender gender = Gender.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public Gender gender() {
        _initialize();
        return gender;
    }

    private CorporateNameInverted corporateNameInverted = CorporateNameInverted.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CorporateNameInverted corporateNameInverted() {
        _initialize();
        return corporateNameInverted;
    }

    private UnnamedPersons unnamedPersons = UnnamedPersons.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public UnnamedPersons unnamedPersons() {
        _initialize();
        return unnamedPersons;
    }

    private ListOfOnixElement<FromLanguage, Languages> fromLanguages = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<FromLanguage, Languages> fromLanguages() {
        _initialize();
        return fromLanguages;
    }

    private ListOfOnixElement<ToLanguage, Languages> toLanguages = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ToLanguage, Languages> toLanguages() {
        _initialize();
        return toLanguages;
    }

    private List<AlternativeName> alternativeNames = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<AlternativeName> alternativeNames() {
        _initialize();
        return alternativeNames;
    }

    private ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate, PersonOrganizationDateRoles>
        contributorDates = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ContributorDate, JonixContributorDate, PersonOrganizationDateRoles>
        contributorDates() {
        _initialize();
        return contributorDates;
    }

    private ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations =
        ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<ProfessionalAffiliation, JonixProfessionalAffiliation> professionalAffiliations() {
        _initialize();
        return professionalAffiliations;
    }

    private ListOfOnixDataComposite<Prize, JonixPrize> prizes = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Prize, JonixPrize> prizes() {
        _initialize();
        return prizes;
    }

    private ListOfOnixElement<BiographicalNote, String> biographicalNotes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<BiographicalNote, String> biographicalNotes() {
        _initialize();
        return biographicalNotes;
    }

    private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Website, JonixWebsite> websites() {
        _initialize();
        return websites;
    }

    private ListOfOnixElement<ContributorDescription, String> contributorDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ContributorDescription, String> contributorDescriptions() {
        _initialize();
        return contributorDescriptions;
    }

    private ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces =
        ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<ContributorPlace, JonixContributorPlace> contributorPlaces() {
        _initialize();
        return contributorPlaces;
    }
}
