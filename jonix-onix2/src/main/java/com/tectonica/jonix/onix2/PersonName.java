/*
 * Copyright (C) 2012 Zach Melamed
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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Person name</h1><p>The name of a person who contributed to the creation of the product, unstructured, and
 * presented in normal order. Optional and non-repeating: see Group&nbsp;PR.8 introductory text for valid
 * options.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable-length text, suggested maximum length
 * 100 characters</td></tr><tr><td>Reference name</td><td><tt>&lt;PersonName&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b036&gt;</tt></td></tr><tr><td>Example</td><td><tt>&lt;PersonName&gt;James J. Johnson
 * III&lt;/PersonName&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Name&gt;</li>
 * <li>&lt;Contributor&gt;</li>
 * <li>&lt;CopyrightOwner&gt;</li>
 * <li>&lt;ConferenceSponsor&gt;</li>
 * <li>&lt;PersonAsSubject&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ Name ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ Name ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ Name ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ Name ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ Name ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ Name ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ Name ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Contributor ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ Contributor ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ SubSeriesRecord ⯈ Contributor ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ MainSeriesRecord ⯈ Contributor ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Series ⯈ Contributor ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ CopyrightStatement ⯈ CopyrightOwner ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ Conference ⯈ ConferenceSponsor ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ PersonAsSubject ⯈ PersonName</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentItem ⯈ PersonAsSubject ⯈ PersonName</li>
 * </ul>
 */
public class PersonName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PersonName";
    public static final String shortname = "b036";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable-length text, suggested maximum length 100 characters<p> (type: NonEmptyString)
     */
    public String value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public String _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PersonName EMPTY = new PersonName();

    public PersonName() {
        exists = false;
    }

    public PersonName(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;PersonName&gt; or &lt;b036&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
