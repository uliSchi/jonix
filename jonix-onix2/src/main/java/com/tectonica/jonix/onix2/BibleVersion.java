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
import com.tectonica.jonix.codelist.BibleVersions;
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
 * <h1>Bible version</h1><p>An ONIX code indicating the version of a Bible or selected Biblical text, for example King
 * James, Jerusalem, New American Standard, Reina Valera. Mandatory in each occurrence of the &lt;Bible&gt; composite,
 * and repeatable if a work includes text in two or more versions.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Fixed-length, three letters</td></tr><tr><td>Codelist</td><td>List
 * 83</td></tr><tr><td>Reference name</td><td><tt>&lt;BibleVersion&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b353&gt;</tt></td></tr><tr><td>Example</td><td><tt>&lt;BibleVersion&gt;JER&lt;/BibleVersion&gt;</tt>
 * Jerusalem</td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Bible&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ReligiousText ⯈ Bible ⯈ BibleVersion</li>
 * </ul>
 */
public class BibleVersion implements OnixElement<BibleVersions>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "BibleVersion";
    public static final String shortname = "b353";

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

    public BibleVersions value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public BibleVersions _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final BibleVersion EMPTY = new BibleVersion();

    public BibleVersion() {
        exists = false;
    }

    public BibleVersion(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = BibleVersions.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;BibleVersion&gt; or &lt;b353&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
