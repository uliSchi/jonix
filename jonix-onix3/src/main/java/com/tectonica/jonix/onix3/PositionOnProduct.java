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
import com.tectonica.jonix.codelist.PositionOnProducts;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Position on product</h1><p>An ONIX code indicating a position on a product; in this case, the position in which a
 * barcode appears. Required if the &lt;BarcodeType&gt; element indicates that the barcode appears on the product, even
 * if the position is ‘unknown’. Omitted if the &lt;BarcodeType&gt; element specifies that the product does not carry a
 * barcode. Non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed length, two
 * digits</td></tr><tr><td>Codelist</td><td>List 142</td></tr><tr><td>Reference name</td><td><tt>&lt;PositionOnProduct&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;x313&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Example</td><td><tt>&lt;x313&gt;01&lt;/x313&gt;</tt>
 * (Cover 4 - the back cover of a book)</td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;Barcode&gt;</li>
 * <li>&lt;Price&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ Barcode ⯈ PositionOnProduct</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ PositionOnProduct</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ PositionOnProduct</li>
 * </ul>
 */
public class PositionOnProduct implements OnixElement<PositionOnProducts>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PositionOnProduct";
    public static final String shortname = "x313";

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

    public PositionOnProducts value;

    /**
     * Internal API, use the {@link #value()} method or the {@link #value} field instead
     */
    @Override
    public PositionOnProducts _value() {
        return value;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SERVICES
    /////////////////////////////////////////////////////////////////////////////////

    private final boolean exists;
    public static final PositionOnProduct EMPTY = new PositionOnProduct();

    public PositionOnProduct() {
        exists = false;
    }

    public PositionOnProduct(org.w3c.dom.Element element) {
        exists = true;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        value = PositionOnProducts.byCode(JPU.getContentAsString(element));
    }

    /**
     * @return whether this tag (&lt;PositionOnProduct&gt; or &lt;x313&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }
}
