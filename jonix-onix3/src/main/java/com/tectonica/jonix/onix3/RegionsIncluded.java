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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.Regions;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Regions included</h1><p>One or more ONIX codes identifying regions included in the territory. A region is an area
 * which is not a country, but which is precisely defined in geographical terms, <i>eg</i> World, Northern Ireland,
 * Australian Capital Territory. Successive codes must be separated by spaces. Optional and non-repeating, but either
 * &lt;CountriesIncluded&gt; or &lt;RegionsIncluded&gt; is mandatory in each occurrence of the &lt;Territory&gt;
 * composite.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>One or more variable-length codes, each
 * consisting of upper case letters, with or without a hyphen and further upper case letters or digits, successive codes
 * being separated by spaces. Suggested maximum length 750 characters</td></tr><tr><td>Codelist</td><td>List 49 Where
 * possible and appropriate, country subdivision codes are derived from the UN LOCODE scheme based on ISO
 * 3166-2</td></tr><tr><td>Reference name</td><td><tt>&lt;RegionsIncluded&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;x450&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td><tt>&lt;x450&gt;GB-SCT
 * GB-NIR GB-WLS&lt;/x450&gt;</tt> (Includes Scotland, Northern Ireland, Wales)</td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Territory&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ SupportingResource ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ SupportingResource ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ SupportingResource ⯈ Territory ⯈
 * RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ TextContent ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ TextContent ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ ContentDetail ⯈ ContentItem ⯈ CitedContent ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ CollateralDetail ⯈ CitedContent ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ Market ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ Territory ⯈ RegionsIncluded</li>
 * <li>ONIXMessage ⯈ Product ⯈ PublishingDetail ⯈ SalesRights ⯈ Territory ⯈ RegionsIncluded</li>
 * </ul>
 */
public class RegionsIncluded implements OnixElement<java.util.Set<Regions>>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "RegionsIncluded";
    public static final String shortname = "x450";

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
    // VALUE MEMBER
    /////////////////////////////////////////////////////////////////////////////////

    public java.util.Set<Regions> value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public java.util.Set<Regions> _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final RegionsIncluded EMPTY = new RegionsIncluded();

    public RegionsIncluded() {
        exists = false;
    }

    public RegionsIncluded(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = new java.util.HashSet<>();
        for (String split : JPU.getContentAsString(element).trim().split(" +")) {
            value.add(Regions.byCode(split));
        }
    }

    /**
     * @return whether this tag (&lt;RegionsIncluded&gt; or &lt;x450&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
