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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.StockQuantityCodeTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixStockQuantityCoded;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Stock quantity coded composite</h1><p>A group of data elements which together specify coded stock level without
 * stating the exact quantity of stock. Either &lt;StockQuantityCoded&gt; or &lt;OnHand&gt; is mandatory in each
 * occurrence of the &lt;Stock&gt; composite, even if the onhand quantity is zero. Non-repeating.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td><tt>&lt;StockQuantityCoded&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;stockquantitycoded&gt;</tt></td></tr></table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Stock}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Stock} ⯈ {@link StockQuantityCoded}</li>
 * </ul>
 *
 * @since Onix-2.13
 */
public class StockQuantityCoded
    implements OnixDataCompositeWithKey<JonixStockQuantityCoded, StockQuantityCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "StockQuantityCoded";
    public static final String shortname = "stockquantitycoded";

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
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final StockQuantityCoded EMPTY = new StockQuantityCoded();

    public StockQuantityCoded() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public StockQuantityCoded(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
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
                case StockQuantityCodeType.refname:
                case StockQuantityCodeType.shortname:
                    stockQuantityCodeType = new StockQuantityCodeType(e);
                    break;
                case StockQuantityCode.refname:
                case StockQuantityCode.shortname:
                    stockQuantityCode = new StockQuantityCode(e);
                    break;
                case StockQuantityCodeTypeName.refname:
                case StockQuantityCodeTypeName.shortname:
                    stockQuantityCodeTypeName = new StockQuantityCodeTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;StockQuantityCoded&gt; or &lt;stockquantitycoded&gt;) is explicitly provided in the
     *         ONIX XML
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

    private StockQuantityCodeType stockQuantityCodeType = StockQuantityCodeType.EMPTY;

    /**
     * <p>An ONIX code identifying the scheme from which the value in the &lt;StockQuantityCode&gt; element is taken.
     * Mandatory in each occurrence of the &lt;StockQuantityCoded&gt; composite, and non-repeating.</p>
     * Jonix-Comment: this field is required
     */
    public StockQuantityCodeType stockQuantityCodeType() {
        _initialize();
        return stockQuantityCodeType;
    }

    private StockQuantityCode stockQuantityCode = StockQuantityCode.EMPTY;

    /**
     * <p>A code value taken from the scheme specified in the &lt;StockQuantityCodeType&gt; element. Mandatory in each
     * occurrence of the &lt;StockQuantityCoded&gt; composite, and non-repeating.</p>
     * Jonix-Comment: this field is required
     */
    public StockQuantityCode stockQuantityCode() {
        _initialize();
        return stockQuantityCode;
    }

    private StockQuantityCodeTypeName stockQuantityCodeTypeName = StockQuantityCodeTypeName.EMPTY;

    /**
     * <p>A name that identifies a proprietary stock quantity coding scheme when the code in the
     * &lt;StockQuantityCodeType&gt; element indicates a proprietary scheme, <em>eg</em> a wholesaler’s own code.
     * Optional, and non-repeating.</p>
     * Jonix-Comment: this field is optional
     */
    public StockQuantityCodeTypeName stockQuantityCodeTypeName() {
        _initialize();
        return stockQuantityCodeTypeName;
    }

    @Override
    public JonixStockQuantityCoded asStruct() {
        _initialize();
        JonixStockQuantityCoded struct = new JonixStockQuantityCoded();
        struct.stockQuantityCodeType = stockQuantityCodeType.value;
        struct.stockQuantityCode = stockQuantityCode.value;
        struct.stockQuantityCodeTypeName = stockQuantityCodeTypeName.value;
        return struct;
    }

    @Override
    public StockQuantityCodeTypes structKey() {
        return stockQuantityCodeType().value;
    }
}
