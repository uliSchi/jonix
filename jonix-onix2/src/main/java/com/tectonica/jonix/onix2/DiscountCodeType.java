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
import com.tectonica.jonix.codelist.DiscountCodeTypes;
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
 * <h1>Discount code type code</h1><p>An ONIX code identifying the scheme from which the value in the
 * &lt;DiscountCode&gt; element is taken. Mandatory in each occurrence of the &lt;DiscountCoded&gt; composite, and
 * non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed-length, 2 numeric
 * digits</td></tr><tr><td>Codelist</td><td>List 100</td></tr><tr><td>Reference name</td><td><tt>&lt;DiscountCodeType&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;j363&gt;</tt></td></tr><tr><td>Example</td><td><tt>&lt;DiscountCodeType&gt;02&lt;/DiscountCodeType&gt;</tt>
 * Proprietary</td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;DiscountCoded&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ Price ⯈ DiscountCoded ⯈ DiscountCodeType</li>
 * <li>ONIXMessage ⯈ Product ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ DiscountCoded ⯈ DiscountCodeType</li>
 * </ul>
 */
public class DiscountCodeType implements OnixElement<DiscountCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "DiscountCodeType";
    public static final String shortname = "j363";

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

    public DiscountCodeTypes value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public DiscountCodeTypes _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final DiscountCodeType EMPTY = new DiscountCodeType();

    public DiscountCodeType() {
        exists = false;
    }

    public DiscountCodeType(org.w3c.dom.Element element) {
        exists = true;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = DiscountCodeTypes.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;DiscountCodeType&gt; or &lt;j363&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
