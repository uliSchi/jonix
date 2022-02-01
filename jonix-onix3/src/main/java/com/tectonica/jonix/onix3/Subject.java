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
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixSubject;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Subject}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Subject}</li>
 * </ul>
 */
public class Subject implements OnixDataComposite<JonixSubject>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Subject";
    public static final String shortname = "subject";

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
    public static final Subject EMPTY = new Subject();

    public Subject() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Subject(org.w3c.dom.Element element) {
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
                case SubjectSchemeIdentifier.refname:
                case SubjectSchemeIdentifier.shortname:
                    subjectSchemeIdentifier = new SubjectSchemeIdentifier(e);
                    break;
                case SubjectCode.refname:
                case SubjectCode.shortname:
                    subjectCode = new SubjectCode(e);
                    break;
                case MainSubject.refname:
                case MainSubject.shortname:
                    mainSubject = new MainSubject(e);
                    break;
                case SubjectSchemeName.refname:
                case SubjectSchemeName.shortname:
                    subjectSchemeName = new SubjectSchemeName(e);
                    break;
                case SubjectSchemeVersion.refname:
                case SubjectSchemeVersion.shortname:
                    subjectSchemeVersion = new SubjectSchemeVersion(e);
                    break;
                case SubjectHeadingText.refname:
                case SubjectHeadingText.shortname:
                    subjectHeadingTexts = JPU.addToList(subjectHeadingTexts, new SubjectHeadingText(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Subject&gt; or &lt;subject&gt;) is explicitly provided in the ONIX XML
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

    private SubjectSchemeIdentifier subjectSchemeIdentifier = SubjectSchemeIdentifier.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public SubjectSchemeIdentifier subjectSchemeIdentifier() {
        _initialize();
        return subjectSchemeIdentifier;
    }

    private SubjectCode subjectCode = SubjectCode.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public SubjectCode subjectCode() {
        _initialize();
        return subjectCode;
    }

    private MainSubject mainSubject = MainSubject.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public MainSubject mainSubject() {
        _initialize();
        return mainSubject;
    }

    public boolean isMainSubject() {
        return (mainSubject().exists());
    }

    private SubjectSchemeName subjectSchemeName = SubjectSchemeName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SubjectSchemeName subjectSchemeName() {
        _initialize();
        return subjectSchemeName;
    }

    private SubjectSchemeVersion subjectSchemeVersion = SubjectSchemeVersion.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SubjectSchemeVersion subjectSchemeVersion() {
        _initialize();
        return subjectSchemeVersion;
    }

    private ListOfOnixElement<SubjectHeadingText, String> subjectHeadingTexts = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<SubjectHeadingText, String> subjectHeadingTexts() {
        _initialize();
        return subjectHeadingTexts;
    }

    @Override
    public JonixSubject asStruct() {
        _initialize();
        JonixSubject struct = new JonixSubject();
        struct.subjectCode = subjectCode.value;
        struct.subjectHeadingTexts = subjectHeadingTexts.values();
        struct.subjectSchemeIdentifier = subjectSchemeIdentifier.value;
        struct.subjectSchemeName = subjectSchemeName.value;
        struct.subjectSchemeVersion = subjectSchemeVersion.value;
        return struct;
    }
}
