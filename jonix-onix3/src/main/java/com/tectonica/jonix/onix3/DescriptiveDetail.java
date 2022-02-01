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
import com.tectonica.jonix.common.codelist.AudienceCodeTypes;
import com.tectonica.jonix.common.codelist.AudienceTypes;
import com.tectonica.jonix.common.codelist.EditionTypes;
import com.tectonica.jonix.common.codelist.EpublicationTechnicalProtections;
import com.tectonica.jonix.common.codelist.ExtentTypes;
import com.tectonica.jonix.common.codelist.IllustrationAndOtherContentTypes;
import com.tectonica.jonix.common.codelist.LanguageRoles;
import com.tectonica.jonix.common.codelist.MeasureTypes;
import com.tectonica.jonix.common.codelist.ProductClassificationTypes;
import com.tectonica.jonix.common.codelist.ProductContentTypes;
import com.tectonica.jonix.common.codelist.ProductFormDetails;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAncillaryContent;
import com.tectonica.jonix.common.struct.JonixAudience;
import com.tectonica.jonix.common.struct.JonixAudienceRange;
import com.tectonica.jonix.common.struct.JonixComplexity;
import com.tectonica.jonix.common.struct.JonixExtent;
import com.tectonica.jonix.common.struct.JonixLanguage;
import com.tectonica.jonix.common.struct.JonixMeasure;
import com.tectonica.jonix.common.struct.JonixProductClassification;
import com.tectonica.jonix.common.struct.JonixProductFormFeature;
import com.tectonica.jonix.common.struct.JonixSubject;

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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail}</li>
 * </ul>
 */
public class DescriptiveDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DescriptiveDetail";
    public static final String shortname = "descriptivedetail";

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
    public static final DescriptiveDetail EMPTY = new DescriptiveDetail();

    public DescriptiveDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public DescriptiveDetail(org.w3c.dom.Element element) {
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
                case ProductComposition.refname:
                case ProductComposition.shortname:
                    productComposition = new ProductComposition(e);
                    break;
                case ProductForm.refname:
                case ProductForm.shortname:
                    productForm = new ProductForm(e);
                    break;
                case TitleDetail.refname:
                case TitleDetail.shortname:
                    titleDetails = JPU.addToList(titleDetails, new TitleDetail(e));
                    break;
                case Contributor.refname:
                case Contributor.shortname:
                    contributors = JPU.addToList(contributors, new Contributor(e));
                    break;
                case ProductPackaging.refname:
                case ProductPackaging.shortname:
                    productPackaging = new ProductPackaging(e);
                    break;
                case TradeCategory.refname:
                case TradeCategory.shortname:
                    tradeCategory = new TradeCategory(e);
                    break;
                case PrimaryContentType.refname:
                case PrimaryContentType.shortname:
                    primaryContentType = new PrimaryContentType(e);
                    break;
                case CountryOfManufacture.refname:
                case CountryOfManufacture.shortname:
                    countryOfManufacture = new CountryOfManufacture(e);
                    break;
                case EpubLicense.refname:
                case EpubLicense.shortname:
                    epubLicense = new EpubLicense(e);
                    break;
                case NoCollection.refname:
                case NoCollection.shortname:
                    noCollection = new NoCollection(e);
                    break;
                case ThesisType.refname:
                case ThesisType.shortname:
                    thesisType = new ThesisType(e);
                    break;
                case ThesisPresentedTo.refname:
                case ThesisPresentedTo.shortname:
                    thesisPresentedTo = new ThesisPresentedTo(e);
                    break;
                case ThesisYear.refname:
                case ThesisYear.shortname:
                    thesisYear = new ThesisYear(e);
                    break;
                case NoContributor.refname:
                case NoContributor.shortname:
                    noContributor = new NoContributor(e);
                    break;
                case EditionNumber.refname:
                case EditionNumber.shortname:
                    editionNumber = new EditionNumber(e);
                    break;
                case EditionVersionNumber.refname:
                case EditionVersionNumber.shortname:
                    editionVersionNumber = new EditionVersionNumber(e);
                    break;
                case NoEdition.refname:
                case NoEdition.shortname:
                    noEdition = new NoEdition(e);
                    break;
                case ReligiousText.refname:
                case ReligiousText.shortname:
                    religiousText = new ReligiousText(e);
                    break;
                case Illustrated.refname:
                case Illustrated.shortname:
                    illustrated = new Illustrated(e);
                    break;
                case NumberOfIllustrations.refname:
                case NumberOfIllustrations.shortname:
                    numberOfIllustrations = new NumberOfIllustrations(e);
                    break;
                case ProductFormDetail.refname:
                case ProductFormDetail.shortname:
                    productFormDetails = JPU.addToList(productFormDetails, new ProductFormDetail(e));
                    break;
                case ProductFormFeature.refname:
                case ProductFormFeature.shortname:
                    productFormFeatures = JPU.addToList(productFormFeatures, new ProductFormFeature(e));
                    break;
                case ProductFormDescription.refname:
                case ProductFormDescription.shortname:
                    productFormDescriptions = JPU.addToList(productFormDescriptions, new ProductFormDescription(e));
                    break;
                case ProductContentType.refname:
                case ProductContentType.shortname:
                    productContentTypes = JPU.addToList(productContentTypes, new ProductContentType(e));
                    break;
                case Measure.refname:
                case Measure.shortname:
                    measures = JPU.addToList(measures, new Measure(e));
                    break;
                case EpubTechnicalProtection.refname:
                case EpubTechnicalProtection.shortname:
                    epubTechnicalProtections = JPU.addToList(epubTechnicalProtections, new EpubTechnicalProtection(e));
                    break;
                case EpubUsageConstraint.refname:
                case EpubUsageConstraint.shortname:
                    epubUsageConstraints = JPU.addToList(epubUsageConstraints, new EpubUsageConstraint(e));
                    break;
                case MapScale.refname:
                case MapScale.shortname:
                    mapScales = JPU.addToList(mapScales, new MapScale(e));
                    break;
                case ProductClassification.refname:
                case ProductClassification.shortname:
                    productClassifications = JPU.addToList(productClassifications, new ProductClassification(e));
                    break;
                case ProductPart.refname:
                case ProductPart.shortname:
                    productParts = JPU.addToList(productParts, new ProductPart(e));
                    break;
                case Collection.refname:
                case Collection.shortname:
                    collections = JPU.addToList(collections, new Collection(e));
                    break;
                case ContributorStatement.refname:
                case ContributorStatement.shortname:
                    contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(e));
                    break;
                case Event.refname:
                case Event.shortname:
                    events = JPU.addToList(events, new Event(e));
                    break;
                case Conference.refname:
                case Conference.shortname:
                    conferences = JPU.addToList(conferences, new Conference(e));
                    break;
                case EditionType.refname:
                case EditionType.shortname:
                    editionTypes = JPU.addToList(editionTypes, new EditionType(e));
                    break;
                case EditionStatement.refname:
                case EditionStatement.shortname:
                    editionStatements = JPU.addToList(editionStatements, new EditionStatement(e));
                    break;
                case Language.refname:
                case Language.shortname:
                    languages = JPU.addToList(languages, new Language(e));
                    break;
                case Extent.refname:
                case Extent.shortname:
                    extents = JPU.addToList(extents, new Extent(e));
                    break;
                case IllustrationsNote.refname:
                case IllustrationsNote.shortname:
                    illustrationsNotes = JPU.addToList(illustrationsNotes, new IllustrationsNote(e));
                    break;
                case AncillaryContent.refname:
                case AncillaryContent.shortname:
                    ancillaryContents = JPU.addToList(ancillaryContents, new AncillaryContent(e));
                    break;
                case Subject.refname:
                case Subject.shortname:
                    subjects = JPU.addToList(subjects, new Subject(e));
                    break;
                case NameAsSubject.refname:
                case NameAsSubject.shortname:
                    nameAsSubjects = JPU.addToList(nameAsSubjects, new NameAsSubject(e));
                    break;
                case AudienceCode.refname:
                case AudienceCode.shortname:
                    audienceCodes = JPU.addToList(audienceCodes, new AudienceCode(e));
                    break;
                case Audience.refname:
                case Audience.shortname:
                    audiences = JPU.addToList(audiences, new Audience(e));
                    break;
                case AudienceRange.refname:
                case AudienceRange.shortname:
                    audienceRanges = JPU.addToList(audienceRanges, new AudienceRange(e));
                    break;
                case AudienceDescription.refname:
                case AudienceDescription.shortname:
                    audienceDescriptions = JPU.addToList(audienceDescriptions, new AudienceDescription(e));
                    break;
                case Complexity.refname:
                case Complexity.shortname:
                    complexitys = JPU.addToList(complexitys, new Complexity(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;DescriptiveDetail&gt; or &lt;descriptivedetail&gt;) is explicitly provided in the
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

    private ProductComposition productComposition = ProductComposition.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ProductComposition productComposition() {
        _initialize();
        return productComposition;
    }

    private ProductForm productForm = ProductForm.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ProductForm productForm() {
        _initialize();
        return productForm;
    }

    private List<TitleDetail> titleDetails = Collections.emptyList();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<TitleDetail> titleDetails() {
        _initialize();
        return titleDetails;
    }

    private List<Contributor> contributors = Collections.emptyList();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public List<Contributor> contributors() {
        _initialize();
        return contributors;
    }

    private ProductPackaging productPackaging = ProductPackaging.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ProductPackaging productPackaging() {
        _initialize();
        return productPackaging;
    }

    private TradeCategory tradeCategory = TradeCategory.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TradeCategory tradeCategory() {
        _initialize();
        return tradeCategory;
    }

    private PrimaryContentType primaryContentType = PrimaryContentType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PrimaryContentType primaryContentType() {
        _initialize();
        return primaryContentType;
    }

    private CountryOfManufacture countryOfManufacture = CountryOfManufacture.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CountryOfManufacture countryOfManufacture() {
        _initialize();
        return countryOfManufacture;
    }

    private EpubLicense epubLicense = EpubLicense.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EpubLicense epubLicense() {
        _initialize();
        return epubLicense;
    }

    private NoCollection noCollection = NoCollection.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NoCollection noCollection() {
        _initialize();
        return noCollection;
    }

    public boolean isNoCollection() {
        return (noCollection().exists());
    }

    private ThesisType thesisType = ThesisType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ThesisType thesisType() {
        _initialize();
        return thesisType;
    }

    private ThesisPresentedTo thesisPresentedTo = ThesisPresentedTo.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ThesisPresentedTo thesisPresentedTo() {
        _initialize();
        return thesisPresentedTo;
    }

    private ThesisYear thesisYear = ThesisYear.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ThesisYear thesisYear() {
        _initialize();
        return thesisYear;
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

    private EditionNumber editionNumber = EditionNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EditionNumber editionNumber() {
        _initialize();
        return editionNumber;
    }

    private EditionVersionNumber editionVersionNumber = EditionVersionNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EditionVersionNumber editionVersionNumber() {
        _initialize();
        return editionVersionNumber;
    }

    private NoEdition noEdition = NoEdition.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NoEdition noEdition() {
        _initialize();
        return noEdition;
    }

    public boolean isNoEdition() {
        return (noEdition().exists());
    }

    private ReligiousText religiousText = ReligiousText.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ReligiousText religiousText() {
        _initialize();
        return religiousText;
    }

    private Illustrated illustrated = Illustrated.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public Illustrated illustrated() {
        _initialize();
        return illustrated;
    }

    private NumberOfIllustrations numberOfIllustrations = NumberOfIllustrations.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NumberOfIllustrations numberOfIllustrations() {
        _initialize();
        return numberOfIllustrations;
    }

    private ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductFormDetail, ProductFormDetails> productFormDetails() {
        _initialize();
        return productFormDetails;
    }

    private ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductFormFeature, JonixProductFormFeature, ProductFormFeatureTypes>
        productFormFeatures() {
        _initialize();
        return productFormFeatures;
    }

    private ListOfOnixElement<ProductFormDescription, String> productFormDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductFormDescription, String> productFormDescriptions() {
        _initialize();
        return productFormDescriptions;
    }

    private ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ProductContentType, ProductContentTypes> productContentTypes() {
        _initialize();
        return productContentTypes;
    }

    private ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Measure, JonixMeasure, MeasureTypes> measures() {
        _initialize();
        return measures;
    }

    private ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections =
        ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EpubTechnicalProtection, EpublicationTechnicalProtections> epubTechnicalProtections() {
        _initialize();
        return epubTechnicalProtections;
    }

    private List<EpubUsageConstraint> epubUsageConstraints = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<EpubUsageConstraint> epubUsageConstraints() {
        _initialize();
        return epubUsageConstraints;
    }

    private ListOfOnixElement<MapScale, Integer> mapScales = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<MapScale, Integer> mapScales() {
        _initialize();
        return mapScales;
    }

    private ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification,
        ProductClassificationTypes> productClassifications = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<ProductClassification, JonixProductClassification, ProductClassificationTypes>
        productClassifications() {
        _initialize();
        return productClassifications;
    }

    private List<ProductPart> productParts = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<ProductPart> productParts() {
        _initialize();
        return productParts;
    }

    private List<Collection> collections = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Collection> collections() {
        _initialize();
        return collections;
    }

    private ListOfOnixElement<ContributorStatement, String> contributorStatements = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ContributorStatement, String> contributorStatements() {
        _initialize();
        return contributorStatements;
    }

    private List<Event> events = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Event> events() {
        _initialize();
        return events;
    }

    private List<Conference> conferences = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Conference> conferences() {
        _initialize();
        return conferences;
    }

    private ListOfOnixElement<EditionType, EditionTypes> editionTypes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EditionType, EditionTypes> editionTypes() {
        _initialize();
        return editionTypes;
    }

    private ListOfOnixElement<EditionStatement, String> editionStatements = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<EditionStatement, String> editionStatements() {
        _initialize();
        return editionStatements;
    }

    private ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Language, JonixLanguage, LanguageRoles> languages() {
        _initialize();
        return languages;
    }

    private ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Extent, JonixExtent, ExtentTypes> extents() {
        _initialize();
        return extents;
    }

    private ListOfOnixElement<IllustrationsNote, String> illustrationsNotes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<IllustrationsNote, String> illustrationsNotes() {
        _initialize();
        return illustrationsNotes;
    }

    private ListOfOnixDataCompositeWithKey<AncillaryContent, JonixAncillaryContent, IllustrationAndOtherContentTypes>
        ancillaryContents = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<AncillaryContent, JonixAncillaryContent, IllustrationAndOtherContentTypes>
        ancillaryContents() {
        _initialize();
        return ancillaryContents;
    }

    private ListOfOnixDataComposite<Subject, JonixSubject> subjects = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Subject, JonixSubject> subjects() {
        _initialize();
        return subjects;
    }

    private List<NameAsSubject> nameAsSubjects = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<NameAsSubject> nameAsSubjects() {
        _initialize();
        return nameAsSubjects;
    }

    private ListOfOnixElement<AudienceCode, AudienceTypes> audienceCodes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<AudienceCode, AudienceTypes> audienceCodes() {
        _initialize();
        return audienceCodes;
    }

    private ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences =
        ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<Audience, JonixAudience, AudienceCodeTypes> audiences() {
        _initialize();
        return audiences;
    }

    private ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<AudienceRange, JonixAudienceRange> audienceRanges() {
        _initialize();
        return audienceRanges;
    }

    private ListOfOnixElement<AudienceDescription, String> audienceDescriptions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<AudienceDescription, String> audienceDescriptions() {
        _initialize();
        return audienceDescriptions;
    }

    private ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Complexity, JonixComplexity> complexitys() {
        _initialize();
        return complexitys;
    }
}
