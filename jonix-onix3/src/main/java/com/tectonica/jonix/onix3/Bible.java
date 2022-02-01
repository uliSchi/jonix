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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.BibleContentss;
import com.tectonica.jonix.common.codelist.BiblePurposes;
import com.tectonica.jonix.common.codelist.BibleTextFeatures;
import com.tectonica.jonix.common.codelist.BibleVersions;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixBible;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ReligiousText}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link ReligiousText} ⯈ {@link Bible}</li>
 * </ul>
 */
public class Bible implements OnixDataComposite<JonixBible>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Bible";
    public static final String shortname = "bible";

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
    public static final Bible EMPTY = new Bible();

    public Bible() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Bible(org.w3c.dom.Element element) {
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
                case BibleContents.refname:
                case BibleContents.shortname:
                    bibleContentss = JPU.addToList(bibleContentss, new BibleContents(e));
                    break;
                case BibleVersion.refname:
                case BibleVersion.shortname:
                    bibleVersions = JPU.addToList(bibleVersions, new BibleVersion(e));
                    break;
                case StudyBibleType.refname:
                case StudyBibleType.shortname:
                    studyBibleType = new StudyBibleType(e);
                    break;
                case BibleTextOrganization.refname:
                case BibleTextOrganization.shortname:
                    bibleTextOrganization = new BibleTextOrganization(e);
                    break;
                case BibleReferenceLocation.refname:
                case BibleReferenceLocation.shortname:
                    bibleReferenceLocation = new BibleReferenceLocation(e);
                    break;
                case BiblePurpose.refname:
                case BiblePurpose.shortname:
                    biblePurposes = JPU.addToList(biblePurposes, new BiblePurpose(e));
                    break;
                case BibleTextFeature.refname:
                case BibleTextFeature.shortname:
                    bibleTextFeatures = JPU.addToList(bibleTextFeatures, new BibleTextFeature(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Bible&gt; or &lt;bible&gt;) is explicitly provided in the ONIX XML
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

    private ListOfOnixElement<BibleContents, BibleContentss> bibleContentss = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<BibleContents, BibleContentss> bibleContentss() {
        _initialize();
        return bibleContentss;
    }

    private ListOfOnixElement<BibleVersion, BibleVersions> bibleVersions = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<BibleVersion, BibleVersions> bibleVersions() {
        _initialize();
        return bibleVersions;
    }

    private StudyBibleType studyBibleType = StudyBibleType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public StudyBibleType studyBibleType() {
        _initialize();
        return studyBibleType;
    }

    private BibleTextOrganization bibleTextOrganization = BibleTextOrganization.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public BibleTextOrganization bibleTextOrganization() {
        _initialize();
        return bibleTextOrganization;
    }

    private BibleReferenceLocation bibleReferenceLocation = BibleReferenceLocation.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public BibleReferenceLocation bibleReferenceLocation() {
        _initialize();
        return bibleReferenceLocation;
    }

    private ListOfOnixElement<BiblePurpose, BiblePurposes> biblePurposes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<BiblePurpose, BiblePurposes> biblePurposes() {
        _initialize();
        return biblePurposes;
    }

    private ListOfOnixElement<BibleTextFeature, BibleTextFeatures> bibleTextFeatures = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<BibleTextFeature, BibleTextFeatures> bibleTextFeatures() {
        _initialize();
        return bibleTextFeatures;
    }

    @Override
    public JonixBible asStruct() {
        _initialize();
        JonixBible struct = new JonixBible();
        struct.bibleContentss = bibleContentss.values();
        struct.biblePurposes = biblePurposes.values();
        struct.bibleReferenceLocation = bibleReferenceLocation.value;
        struct.bibleTextFeatures = bibleTextFeatures.values();
        struct.bibleTextOrganization = bibleTextOrganization.value;
        struct.bibleVersions = bibleVersions.values();
        struct.studyBibleType = studyBibleType.value;
        return struct;
    }
}
