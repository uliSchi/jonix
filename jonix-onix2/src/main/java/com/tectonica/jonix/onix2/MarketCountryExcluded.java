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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.OnixElement;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Market country excluded</h1><p>One or more ISO standard codes identifying a country which is excluded from a
 * territory specified in &lt;MarketTerritory&gt;. Successive codes are separated by spaces. Thus, a single occurrence
 * of the element can carry an unlimited number of country codes. Optional and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>One or more fixed-length codes, each with two upper case letters, successive
 * codes being separated by spaces. Suggested maximum length 300 characters. [Note that ISO 3166-1 specifies that
 * country codes shall be sent as upper case only.]</td></tr><tr><td>Codelist</td><td>ISO 3166-1 two-letter country
 * codes - List 91</td></tr><tr><td>Reference name</td><td><tt>&lt;MarketCountryExcluded&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;j405&gt;</tt></td></tr><tr><td>Example</td><td><tt>&lt;j405&gt;US
 * CA&lt;/j405&gt;</tt></td></tr></table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link MarketRepresentation}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link MarketRepresentation} ⯈ {@link MarketCountryExcluded}</li>
 * </ul>
 *
 * @since Onix-2.12
 */
public class MarketCountryExcluded implements OnixElement<java.util.Set<String>>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "MarketCountryExcluded";
    public static final String shortname = "j405";

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
     * This is the raw content of MarketCountryExcluded. Could be null if {@code exists() == false}. Use {@link
     * #value()} instead if you want to get this as an {@link java.util.Optional}.
     * <p>
     * Raw Format: One or more fixed-length codes, each with two upper case letters, successive codes being separated by
     * spaces. Suggested maximum length 300 characters. [Note that ISO 3166-1 specifies that country codes shall be sent
     * as upper case only.]<p> (type: NonEmptyString)
     */
    public java.util.Set<String> value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public java.util.Set<String> _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final MarketCountryExcluded EMPTY = new MarketCountryExcluded();

    public MarketCountryExcluded() {
        exists = false;
    }

    public MarketCountryExcluded(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = new java.util.HashSet<>();
        for (String split : JPU.getContentAsString(element).split(" +")) {
            value.add(String.valueOf(split));
        }
    }

    /**
     * @return whether this tag (&lt;MarketCountryExcluded&gt; or &lt;j405&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
