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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TextItemIdentifierTypes;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixPageRun;
import com.tectonica.jonix.common.struct.JonixTextItemIdentifier;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Text item composite</h1><p>A group of data elements which are specific to text content. The composite must occur
 * once and only once in a &lt;ContentItem&gt; composite which describes a text content item. (Similar composites are
 * being defined for other media, and the occurrence of one of them will be mandatory in any &lt;ContentItem&gt;
 * composite.)</p><table border='1' cellpadding='3'><tr><td>Reference name</td><td><tt>&lt;TextItem&gt;</tt></td></tr><tr><td>Short
 * tag</td><td><tt>&lt;textitem&gt;</tt></td></tr></table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentItem} ⯈ {@link TextItem}</li>
 * </ul>
 */
public class TextItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TextItem";
    public static final String shortname = "textitem";

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
    public static final TextItem EMPTY = new TextItem();

    public TextItem() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TextItem(org.w3c.dom.Element element) {
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
                case TextItemType.refname:
                case TextItemType.shortname:
                    textItemType = new TextItemType(e);
                    break;
                case FirstPageNumber.refname:
                case FirstPageNumber.shortname:
                    firstPageNumber = new FirstPageNumber(e);
                    break;
                case LastPageNumber.refname:
                case LastPageNumber.shortname:
                    lastPageNumber = new LastPageNumber(e);
                    break;
                case NumberOfPages.refname:
                case NumberOfPages.shortname:
                    numberOfPages = new NumberOfPages(e);
                    break;
                case TextItemIdentifier.refname:
                case TextItemIdentifier.shortname:
                    textItemIdentifiers = JPU.addToList(textItemIdentifiers, new TextItemIdentifier(e));
                    break;
                case PageRun.refname:
                case PageRun.shortname:
                    pageRuns = JPU.addToList(pageRuns, new PageRun(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;TextItem&gt; or &lt;textitem&gt;) is explicitly provided in the ONIX XML
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

    private TextItemType textItemType = TextItemType.EMPTY;

    /**
     * <p>An ONIX code which identifies the nature of a text item. Mandatory in each occurrence of the &lt;TextItem&gt;
     * composite, and non-repeatable.</p>
     * Jonix-Comment: this field is required
     */
    public TextItemType textItemType() {
        _initialize();
        return textItemType;
    }

    private FirstPageNumber firstPageNumber = FirstPageNumber.EMPTY;

    /**
     * <p>The number of the page on which a text item begins in a paginated product. Optional and non-repeating;
     * required when the text item is being referenced as part of a structured table of contents.</p>
     * Jonix-Comment: this field is required
     */
    public FirstPageNumber firstPageNumber() {
        _initialize();
        return firstPageNumber;
    }

    private LastPageNumber lastPageNumber = LastPageNumber.EMPTY;

    /**
     * <p>The number of the page on which a text item ends in a paginated product. Optional and non-repeating, and can
     * occur only when &lt;FirstPageNumber&gt; is also present.</p>
     * Jonix-Comment: this field is optional
     */
    public LastPageNumber lastPageNumber() {
        _initialize();
        return lastPageNumber;
    }

    private NumberOfPages numberOfPages = NumberOfPages.EMPTY;

    /**
     * <p>The page extent of a text item within a paginated product. Optional and non-repeating, but normally expected
     * when the text item is being referenced as part of a structured table of contents.</p>
     * Jonix-Comment: this field is optional
     */
    public NumberOfPages numberOfPages() {
        _initialize();
        return numberOfPages;
    }

    private ListOfOnixDataCompositeWithKey<TextItemIdentifier, JonixTextItemIdentifier, TextItemIdentifierTypes>
        textItemIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * <p>A repeatable group of data elements which together define an identifier of a text item in accordance with a
     * specified scheme. The composite is optional.</p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<TextItemIdentifier, JonixTextItemIdentifier, TextItemIdentifierTypes>
        textItemIdentifiers() {
        _initialize();
        return textItemIdentifiers;
    }

    private ListOfOnixDataComposite<PageRun, JonixPageRun> pageRuns = ListOfOnixDataComposite.empty();

    /**
     * <p>A repeatable group of data elements which together define a run of contiguous pages on which a text item
     * appears. The composite is optional, but may be repeated where the text item covers two or more separate page
     * runs.</p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<PageRun, JonixPageRun> pageRuns() {
        _initialize();
        return pageRuns;
    }
}
