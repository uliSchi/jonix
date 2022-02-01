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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 27 (Subject scheme identifier)
 */
interface CodeList27 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 27</b>
 * <p>
 * Description: Subject scheme identifier
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_49.html#codelist27">ONIX
 * Codelist 27 in Reference Guide</a>
 */
public enum SubjectSchemeIdentifiers implements OnixCodelist, CodeList27 {
    /**
     * Dewey Decimal Classification
     */
    Dewey("01", "Dewey"),

    Abridged_Dewey("02", "Abridged Dewey"),

    /**
     * US Library of Congress classification
     */
    LC_classification("03", "LC classification"),

    /**
     * US Library of Congress subject heading
     */
    LC_subject_heading("04", "LC subject heading"),

    /**
     * US National Library of Medicine medical classification
     */
    NLM_classification("05", "NLM classification"),

    /**
     * US National Library of Medicine Medical subject heading
     */
    MeSH_heading("06", "MeSH heading"),

    /**
     * US National Agricultural Library subject heading
     */
    NAL_subject_heading("07", "NAL subject heading"),

    /**
     * Getty Art and Architecture Thesaurus heading
     */
    AAT("08", "AAT"),

    /**
     * Universal Decimal Classification
     */
    UDC("09", "UDC"),

    /**
     * BISAC Subject Headings are used in the North American market to categorize books based on topical content. They
     * serve as a guideline for shelving books in physical stores and browsing books in online stores. See
     * https://bisg.org/page/BISACSubjectCodes
     */
    BISAC_Subject_Heading("10", "BISAC Subject Heading"),

    /**
     * A geographical qualifier used with a BISAC subject category
     */
    BISAC_Regional_theme("11", "BISAC Regional theme"),

    /**
     * For all BIC subject codes and qualifiers, see https://www.bic.org.uk/7/BIC-Standard-Subject-Categories/
     */
    BIC_subject_category("12", "BIC subject category"),

    BIC_geographical_qualifier("13", "BIC geographical qualifier"),

    BIC_language_qualifier_language_as_subject("14", "BIC language qualifier (language as subject)"),

    BIC_time_period_qualifier("15", "BIC time period qualifier"),

    BIC_educational_purpose_qualifier("16", "BIC educational purpose qualifier"),

    BIC_reading_level_and_special_interest_qualifier("17", "BIC reading level and special interest qualifier"),

    /**
     * Used for German National Bibliography since 2004 (100 subjects). Is different from value 30. See
     * http://www.dnb.de/service/pdf/ddc_wv_aktuell.pdf (in German) or http://www.dnb.de/eng/service/pdf/ddc_wv_aktuell_eng.pdf
     * (English)
     */
    DDC_Sachgruppen_der_Deutschen_Nationalbibliografie("18", "DDC-Sachgruppen der Deutschen Nationalbibliografie"),

    LC_fiction_genre_heading("19", "LC fiction genre heading"),

    /**
     * For indexing and search purposes, not normally intended for display. Where multiple keywords or keyword phrases
     * are sent, this should be in a single instance of the &lt;SubjectHeadingText&gt; element, and it is recommended
     * that they should be separated by semi-colons (this is consistent with Library of Congress preferred practice)
     */
    Keywords("20", "Keywords"),

    /**
     * See PA/BIC CBMC guidelines at http://www.bic.org.uk/8/Children%27s-Books-Marketing-Classifications/
     */
    BIC_children_s_book_marketing_category("21", "BIC children’s book marketing category"),

    /**
     * BISAC Merchandising Themes are used in addition to BISAC Subject Headings to denote an audience to which a work
     * may be of particular appeal, a time of year or event for which a work may be especially appropriate, or to
     * further describe fictional works that have been subject-coded by genre
     */
    BISAC_Merchandising_Theme("22", "BISAC Merchandising Theme"),

    Publisher_s_own_category_code("23", "Publisher’s own category code"),

    /**
     * As specified in &lt;SubjectSchemeName&gt;
     */
    Proprietary_subject_scheme("24", "Proprietary subject scheme"),

    /**
     * Latin America
     */
    Tabla_de_materias_ISBN("25", "Tabla de materias ISBN"),

    /**
     * See https://vlb.de/assets/images/wgsneuversion2_0.pdf (in German)
     */
    Warengruppen_Systematik_des_deutschen_Buchhandels("26", "Warengruppen-Systematik des deutschen Buchhandels"),

    /**
     * Schlagwortnormdatei - Subject Headings Authority File in the German-speaking countries. See
     * http://www.dnb.de/standardisierung/normdateien/swd.htm (in German) and http://www.dnb.de/eng/standardisierung/normdateien/swd.htm
     * (English). DEPRECATED in favor of the GND
     */
    SWD("27", "SWD"),

    /**
     * Subject classification used by Electre (France)
     */
    Th_mes_Electre("28", "Thèmes Electre"),

    /**
     * France. A four-digit number, see https://clil.centprod.com/listeActive.html (in French)
     */
    CLIL_Classification_th_matique("29", "CLIL Classification thématique"),

    /**
     * Deutsche Bibliothek subject groups. Used for German National Bibliography until 2003 (65 subjects). Is different
     * from value 18. See http://www.dnb.de/service/pdf/ddc_wv_alt_neu.pdf (in German)
     */
    DNB_Sachgruppen("30", "DNB-Sachgruppen"),

    /**
     * Nederlandse Uniforme Genre-Indeling (former Dutch book trade classification)
     */
    NUGI("31", "NUGI"),

    /**
     * Nederlandstalige Uniforme Rubrieksindeling (Dutch book trade classification, from 2002, see
     * http://www.boek.nl/nur (in Dutch)
     */
    NUR("32", "NUR"),

    /**
     * ECPA Christian Product Category Book Codes, consisting of up to three x 3-letter blocks, for Super Category,
     * Primary Category and Sub-Category. See http://www.ecpa.org/ECPA/cbacategories.xls
     */
    ECPA_Christian_Book_Category("33", "ECPA Christian Book Category"),

    /**
     * Schema Indeling Systematische Catalogus Openbare Bibliotheken (Dutch library classification)
     */
    SISO("34", "SISO"),

    /**
     * A modified Dewey Decimal Classification used in the Republic of Korea
     */
    Korean_Decimal_Classification_KDC("35", "Korean Decimal Classification (KDC)"),

    /**
     * German Translation of Dewey Decimal Classification 22. Also known as DDC 22 ger. See
     * http://www.ddc-deutsch.de/produkte/uebersichten/
     */
    DDC_Deutsch_22("36", "DDC Deutsch 22"),

    /**
     * Norwegian book trade product categories (Bokgrupper) administered by the Norwegian Publishers Association
     * (http://www.forleggerforeningen.no/)
     */
    Bokgrupper("37", "Bokgrupper"),

    /**
     * Norwegian bookselling subject categories (Bokhandelens varegrupper) administered by the Norwegian Booksellers
     * Association (http://bokhandlerforeningen.no/)
     */
    Varegrupper("38", "Varegrupper"),

    /**
     * Norwegian school curriculum version. Deprecated
     */
    L_replaner_KL06("39", "Læreplaner-KL06"),

    /**
     * Japanese subject classification scheme
     */
    Nippon_Decimal_Classification("40", "Nippon Decimal Classification"),

    /**
     * BookSelling Qualifier: Russian book trade classification
     */
    BSQ("41", "BSQ"),

    /**
     * Spain: subject coding scheme of the Asociaci&#243;n Nacional de Editores de Libros y Material de Ense&#241;anza
     */
    ANELE_Materias("42", "ANELE Materias"),

    /**
     * Codes for Norwegian 'utdanningsprogram' used in secondary education. See: http://www.udir.no/. (Formerly labelled
     * 'Skolefag')
     */
    Utdanningsprogram("43", "Utdanningsprogram"),

    /**
     * Codes for Norwegian 'programomr&#229;de' used in secondary education. See http://www.udir.no/. (Formerly labelled
     * 'Videreg&#229;ende' or 'Programfag')
     */
    Programomr_de("44", "Programområde"),

    /**
     * Norwegian list of categories for books and other material used in education
     */
    Undervisningsmateriell("45", "Undervisningsmateriell"),

    /**
     * Norwegian version of Dewey Decimal Classification
     */
    Norsk_DDK("46", "Norsk DDK"),

    /**
     * Swedish bookselling subject categories
     */
    Varugrupper("47", "Varugrupper"),

    /**
     * Swedish classification scheme
     */
    SAB("48", "SAB"),

    /**
     * Swedish bookselling educational subject type
     */
    L_romedelstyp("49", "Läromedelstyp"),

    /**
     * Swedish publishers preliminary subject classification
     */
    F_rhandsbeskrivning("50", "Förhandsbeskrivning"),

    /**
     * Controlled subset of UDC codes used by the Spanish ISBN Agency
     */
    Spanish_ISBN_UDC_subset("51", "Spanish ISBN UDC subset"),

    /**
     * Subject categories defined by El Corte Ingl&#233;s and used widely in the Spanish book trade
     */
    ECI_subject_categories("52", "ECI subject categories"),

    /**
     * Classificazione commerciale editoriale (Italian book trade subject category based on BIC). CCE documentation
     * available at https://www.ie-online.it/CCE2_2.0.pdf
     */
    Soggetto_CCE("53", "Soggetto CCE"),

    /**
     * CCE Geographical qualifier
     */
    Qualificatore_geografico_CCE("54", "Qualificatore geografico CCE"),

    /**
     * CCE Language qualifier
     */
    Qualificatore_di_lingua_CCE("55", "Qualificatore di lingua CCE"),

    /**
     * CCE Time Period qualifier
     */
    Qualificatore_di_periodo_storico_CCE("56", "Qualificatore di periodo storico CCE"),

    /**
     * CCE Educational Purpose qualifier
     */
    Qualificatore_di_livello_scolastico_CCE("57", "Qualificatore di livello scolastico CCE"),

    /**
     * CCE Reading Level Qualifier
     */
    Qualificatore_di_et_di_lettura_CCE("58", "Qualificatore di età di lettura CCE"),

    /**
     * Subject code list of the German association of educational media publishers. See
     * http://www.bildungsmedien.de/service/onixlisten/unterrichtsfach_onix_codelist27_value59_0408.pdf
     */
    VdS_Bildungsmedien_F_cher("59", "VdS Bildungsmedien Fächer"),

    /**
     * Norwegian primary and secondary school subject categories (fagkoder), see http://www.udir.no/
     */
    Fagkoder("60", "Fagkoder"),

    /**
     * Journal of Economic Literature classification scheme
     */
    JEL_classification("61", "JEL classification"),

    /**
     * National Library of Canada subject heading (English)
     */
    CSH("62", "CSH"),

    /**
     * R&#233;pertoire de vedettes-mati&#232;re Biblioth&#232;que de l'Universit&#233; Laval) (French)
     */
    RVM("63", "RVM"),

    /**
     * Yleinen suomalainen asiasanasto: Finnish General Thesaurus. See http://onki.fi/fi/browser/ (in Finnish).
     * Deprecated. No longer updated, and replaced by YSO (see code 71)
     */
    YSA("64", "YSA"),

    /**
     * Allm&#228;n tesaurus p&#229; svenska: Swedish translation of the Finnish General Thesaurus. See
     * http://onki.fi/fi/browser/ (in Finnish). Deprecated. No longer updated, and replaced by YSO (see code 71)
     */
    All_rs("65", "Allärs"),

    /**
     * Yleisten kirjastojen luokitusj&#228;rjestelm&#228;: Finnish Public Libraries Classification System. See
     * http://ykl.kirjastot.fi/ (in Finnish)
     */
    YKL("66", "YKL"),

    /**
     * Musiikin asiasanasto: Finnish Music Thesaurus. See http://onki.fi/fi/browser/ (in Finnish)
     */
    MUSA("67", "MUSA"),

    /**
     * Specialtesaurus f&#246;r musik: Swedish translation of the Finnish Music Thesaurus. See
     * http://onki.fi/fi/browser/ (in Finnish)
     */
    CILLA("68", "CILLA"),

    /**
     * Fiktiivisen aineiston asiasanasto: Finnish thesaurus for fiction. See http://kaunokki.kirjastot.fi/ (in Finnish)
     */
    Kaunokki("69", "Kaunokki"),

    /**
     * Specialtesaurus f&#246;r fiktivt material: Swedish translation of the Finnish thesaurus for fiction. See
     * http://kaunokki.kirjastot.fi/sv-FI/ (in Finnish)
     */
    Bella("70", "Bella"),

    /**
     * Yleinen suomalainen ontologia: Finnish General Upper Ontology. See http://onki.fi/fi/browser/ (In Finnish)
     */
    YSO("71", "YSO"),

    /**
     * Finnish Place Ontology. See http://onki.fi/fi/browser/ (in Finnish)
     */
    Paikkatieto_ontologia("72", "Paikkatieto ontologia"),

    /**
     * Finnish book trade categorisation
     */
    Suomalainen_kirja_alan_luokitus("73", "Suomalainen kirja-alan luokitus"),

    /**
     * Sears List of Subject Headings
     */
    Sears("74", "Sears"),

    /**
     * BIC E4Libraries Category Headings, see http://www.bic.org.uk/51/E4libraries-Subject-Category-Headings/
     */
    BIC_E4L("75", "BIC E4L"),

    /**
     * Code Sujet Rayon: subject categories used by bookstores in France
     */
    CSR("76", "CSR"),

    /**
     * Finnish school subject categories
     */
    Suomalainen_oppiaineluokitus("77", "Suomalainen oppiaineluokitus"),

    /**
     * See https://isbn.jpo.or.jp/doc/08.pdf#page=44 (in Japanese)
     */
    Japanese_book_trade_C_Code("78", "Japanese book trade C-Code"),

    Japanese_book_trade_Genre_Code("79", "Japanese book trade Genre Code"),

    /**
     * Finnish fiction genre classification. See http://ykl.kirjastot.fi/fi-FI/lisaluokat/ (in Finnish)
     */
    Fiktiivisen_aineiston_lis_luokitus("80", "Fiktiivisen aineiston lisäluokitus"),

    Arabic_Subject_heading_scheme("81", "Arabic Subject heading scheme"),

    /**
     * Arabized version of BIC subject category scheme developed by ElKotob.com
     */
    Arabized_BIC_subject_category("82", "Arabized BIC subject category"),

    /**
     * Arabized version of Library of Congress scheme
     */
    Arabized_LC_subject_headings("83", "Arabized LC subject headings"),

    /**
     * Classification scheme used by Library of Alexandria
     */
    Bibliotheca_Alexandrina_Subject_Headings("84", "Bibliotheca Alexandrina Subject Headings"),

    /**
     * Location defined by postal code. Format is two-letter country code (from List 91), space, postal code. Note some
     * postal codes themselves contain spaces, eg 'GB N7 9DP' or 'US 10125'
     */
    Postal_code("85", "Postal code"),

    /**
     * ID number for geographical place, as defined at http://www.geonames.org (eg 2825297 is Stuttgart, Germany, see
     * http://www.geonames.org/2825297)
     */
    GeoNames_ID("86", "GeoNames ID"),

    /**
     * Used for classification of academic and specialist publication in German-speaking countries. See
     * http://www.newbooks-services.com/de/top/unternehmensportrait/klassifikation-und-mapping.html (German) and
     * http://www.newbooks-services.com/en/top/about-newbooks/classification-mapping.html (English)
     */
    NewBooks_Subject_Classification("87", "NewBooks Subject Classification"),

    /**
     * Subject classification maintained by the Editorial Board of Chinese Library Classification. See
     * http://cct.nlc.gov.cn for access to details of the scheme
     */
    Chinese_Library_Classification("88", "Chinese Library Classification"),

    /**
     * Subject classification for Books, Audiovisual products and E-publications formulated by China National Technical
     * Committee 505
     */
    NTCPDSAC_Classification("89", "NTCPDSAC Classification"),

    /**
     * German code scheme indicating association with seasons, holidays, events (eg Autumn, Back to School, Easter)
     */
    Season_and_Event_Indicator("90", "Season and Event Indicator"),

    /**
     * Gemeinsame Normdatei - Joint Authority File in the German-speaking countries. See http://www.dnb.de/EN/gnd
     * (English). Combines the PND, SWD and GKD into a single authority file, and should be used in preference to the
     * older codes
     */
    GND("91", "GND"),

    /**
     * UK Standard Library Categories, the successor to BIC's E4L classification scheme. See
     * https://www.bic.org.uk/51/UK-Standard-Library-Categories/
     */
    BIC_UKSLC("92", "BIC UKSLC"),

    /**
     * International multilingual subject category scheme - see https://ns.editeur.org/thema
     */
    Thema_subject_category("93", "Thema subject category"),

    Thema_place_qualifier("94", "Thema place qualifier"),

    Thema_language_qualifier("95", "Thema language qualifier"),

    Thema_time_period_qualifier("96", "Thema time period qualifier"),

    Thema_educational_purpose_qualifier("97", "Thema educational purpose qualifier"),

    Thema_interest_age_special_interest_qualifier("98", "Thema interest age / special interest qualifier"),

    Thema_style_qualifier("99", "Thema style qualifier"),

    /**
     * Swedish subject categories maintained by Bokrondellen
     */
    _mnesord("A2", "Ämnesord"),

    /**
     * Polish Statistical Book and E-book Classification
     */
    Statystyka_Ksi_ek_Papierowych_M_wionych_I_Elektronicznych("A3",
        "Statystyka Książek Papierowych, Mówionych I Elektronicznych"),

    /**
     * Common Core State Standards curriculum alignment, for links to US educational standards. &lt;SubjectCode&gt; uses
     * the full dot notation. See http://www.corestandards.org/developers-and-publishers
     */
    CCSS("A4", "CCSS"),

    /**
     * French library subject headings
     */
    Rameau("A5", "Rameau"),

    /**
     * French educational subject classification, URI http://data.education.fr/voc/scolomfr/scolomfr-voc-015GTPX
     */
    Nomenclature_discipline_scolaire("A6", "Nomenclature discipline scolaire"),

    /**
     * International Standard Industry Classification, a classification of economic activities. Use for books that are
     * about a particular industry or economic activity. &lt;SubjectCode&gt; should be a single letter denoting an ISIC
     * section OR a 2-, 3- or 4-digit number denoting an ISIC division, group or class. See
     * http://unstats.un.org/unsd/cr/registry/isic-4.asp
     */
    ISIC("A7", "ISIC"),

    /**
     * Library of Congress Children's Subject Headings: LCSHAC supplementary headings for Children's books
     */
    LC_Children_s_Subject_Headings("A8", "LC Children’s Subject Headings"),

    /**
     * Swedish bookselling educational subject
     */
    Ny_L_romedel("A9", "Ny Läromedel"),

    /**
     * EuroVoc multilingual thesaurus. &lt;SubjectCode&gt; should be a EuroVoc concept dc:identifier (for example, 2777,
     * 'refrigerated products'). See http://eurovoc.europa.eu
     */
    EuroVoc("B0", "EuroVoc"),

    /**
     * Controlled vocabulary for educational objectives. See https://bisg.org/page/EducationalTaxonomy
     */
    BISG_Educational_Taxonomy("B1", "BISG Educational Taxonomy"),

    /**
     * For indexing and search purposes, MUST not be displayed. Where multiple keywords or keyword phrases are sent,
     * this should be in a single instance of the &lt;SubjectHeadingText&gt; element, and it is recommended that they
     * should be separated by semi-colons. Use of code B2 should be very rare: use B2 in preference to code 20 only
     * where it is important to show the keyword list is specifically NOT for display to purchasers (eg some keywords
     * for a medical textbook may appear offensive if displayed out of context)
     */
    Keywords_not_for_display("B2", "Keywords (not for display)"),

    /**
     * French higher and vocational educational subject classification, URI http://data.education.fr/voc/scolomfr/scolomfr-voc-029
     */
    Nomenclature_Dipl_me("B3", "Nomenclature Diplôme"),

    /**
     * For fiction and non-fiction, one or more key names, provided - like keywords - for indexing and search purposes.
     * Where multiple character names are sent, this should be in a single instance of &lt;SubjectHeadingText&gt;, and
     * multiple names should be separated by semi-colons. Note &lt;NameAsSubject&gt; should be used for people who are
     * the central subject of the book. Code B4 may be used for names of lesser importance
     */
    Key_character_names("B4", "Key character names"),

    /**
     * For fiction and non-fiction, one or more key names, provded - like keywords - for indexing and search purposes.
     * Where multiple place names are sent, this should in a single instance of &lt;SubjectHeadingText&gt;, and multiple
     * names should be separated by semi-colons. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Key_place_names("B5", "Key place names"),

    /**
     * Faceted Application of Subject Terminology, OCLC subject scheme based on but different from LCSH (see code 04).
     * For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    FAST("B6", "FAST"),

    /**
     * Next Generation Science Standards for K-12 education in the USA (https://www.nextgenscience.org).
     * &lt;SubjectCode&gt; is a code such as 4-PS3-2. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    NGSS("B7", "NGSS"),

    /**
     * MVB classification of 'reading rationales', which classify unconscious motives that lead to a book purchase.
     * Categories are assigned and maintained by MVB. For use in ONIX 3.0 only. See https://vlb.de/lesemotive
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    MVB_Lesemotive("B8", "MVB-Lesemotive"),

    /**
     * Finnish Suomalainen oppiaineluokitus. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    LOPS21_Subject_module("B9", "LOPS21 Subject module"),

    /**
     * Codes for Norwegian curriculum for primary and secondary education. For use in ONIX 3.0 only. See
     * L&#230;replaner-LK20 at https://www.udir.no/om-udir/data/kl06-grep/
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    L_replaner_LK20("C0", "Læreplaner-LK20"),

    /**
     * Codes for competency aims in the Norwegian curriculum for primary and secondary education. For use in ONIX 3.0
     * only. See Kompetansem&#229;l-LK20 at https://www.udir.no/om-udir/data/kl06-grep/
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Kompetansem_l_LK20("C1", "Kompetansemål-LK20"),

    /**
     * Codes for sets of competency aims in the Norwegian curriculum for primary and secondary education. For use in
     * ONIX 3.0 only. See Kompetansem&#229;lsett-LK20 at https://www.udir.no/om-udir/data/kl06-grep/
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Kompetansem_lsett_LK20("C2", "Kompetansemålsett-LK20"),

    /**
     * Codes for interdisciplinary topics in the Norwegian curriculum for primary and secondary education. For use in
     * ONIX 3.0 only. See Tverrfaglige temaer-LK20 at https://www.udir.no/om-udir/data/kl06-grep/
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Tverrfaglige_temaer_LK20("C3", "Tverrfaglige temaer-LK20"),

    /**
     * For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    CLIL_Type_d_article_scolaire("C4", "CLIL – Type d’article scolaire"),

    /**
     * Gestionnaire d'Acc&#232;s aux resources - see https://gar.education.fr/ For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    GAR_Type_p_dagogique("C5", "GAR – Type pédagogique"),

    /**
     * UNESCO ISCED Fields of education and training (2013), eg &lt;SubjectCode&gt; 0222 is 'History and archaeology'.
     * For use in ONIX 3.0 only. See http://uis.unesco.org/sites/default/files/documents/international-standard-classification-of-education-fields-of-education-and-training-2013-detailed-field-descriptions-2015-en.pdf
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    ISCED_F("C6", "ISCED-F"),

    /**
     * German category scheme for games, puzzles and toys. For use in ONIX 3.0 only. See
     * https://www.ludologie.de/fileadmin/user_upload/PDFs/211126_Kategorisierung_von_Spielen_Puzzles_und_Spielwaren.pdf
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Klassifikationen_von_Spielen_Puzzles_und_Spielwaren("C7", "Klassifikationen von Spielen, Puzzles und Spielwaren");

    public final String code;
    public final String description;

    SubjectSchemeIdentifiers(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, SubjectSchemeIdentifiers> map;

    private static Map<String, SubjectSchemeIdentifiers> map() {
        Map<String, SubjectSchemeIdentifiers> result = map;
        if (result == null) {
            synchronized (SubjectSchemeIdentifiers.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (SubjectSchemeIdentifiers e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static SubjectSchemeIdentifiers byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
