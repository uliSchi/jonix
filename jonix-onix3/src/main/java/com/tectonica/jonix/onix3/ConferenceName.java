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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.Languages;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Conference name</h1><p>The name of a conference or conference series to which the product is related. This
 * element is mandatory in each occurrence of the &lt;Conference&gt; composite, and non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Format</td><td>Variable length text, suggested maximum length 200
 * characters</td></tr><tr><td>Reference name</td><td><tt>&lt;ConferenceName&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;b052&gt;</tt></td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Attributes</td><td>language</td></tr><tr><td>Example</td><td><tt>&lt;b052&gt;United
 * Nations Climate Change Conference&lt;/b052&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Conference&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ Conference ⯈ ConferenceName</li>
 * </ul>
 */
public class ConferenceName implements OnixElement<String>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ConferenceName";
    public static final String shortname = "b052";

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

    public Languages language;

    /////////////////////////////////////////////////////////////////////////////////
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * Raw Format: Variable length text, suggested maximum length 200 characters<p> (type: dt.NonEmptyString)
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
    public static final ConferenceName EMPTY = new ConferenceName();

    public ConferenceName() {
        exists = false;
    }

    public ConferenceName(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
        language = Languages.byCode(JPU.getAttribute(element, "language"));

        value = JPU.getContentAsString(element);
    }

    /**
     * @return whether this tag (&lt;ConferenceName&gt; or &lt;b052&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
