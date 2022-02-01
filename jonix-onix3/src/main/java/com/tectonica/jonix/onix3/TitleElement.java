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
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixTitleElement;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TitleDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link TitleDetail} ⯈ {@link TitleElement}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TitleDetail} ⯈ {@link TitleElement}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link TitleDetail} ⯈ {@link TitleElement}</li>
 * </ul>
 */
public class TitleElement implements OnixDataComposite<JonixTitleElement>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "TitleElement";
    public static final String shortname = "titleelement";

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
    public static final TitleElement EMPTY = new TitleElement();

    public TitleElement() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public TitleElement(org.w3c.dom.Element element) {
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
                case TitleElementLevel.refname:
                case TitleElementLevel.shortname:
                    titleElementLevel = new TitleElementLevel(e);
                    break;
                case PartNumber.refname:
                case PartNumber.shortname:
                    partNumber = new PartNumber(e);
                    break;
                case TitleWithoutPrefix.refname:
                case TitleWithoutPrefix.shortname:
                    titleWithoutPrefix = new TitleWithoutPrefix(e);
                    break;
                case SequenceNumber.refname:
                case SequenceNumber.shortname:
                    sequenceNumber = new SequenceNumber(e);
                    break;
                case YearOfAnnual.refname:
                case YearOfAnnual.shortname:
                    yearOfAnnual = new YearOfAnnual(e);
                    break;
                case TitlePrefix.refname:
                case TitlePrefix.shortname:
                    titlePrefix = new TitlePrefix(e);
                    break;
                case NoPrefix.refname:
                case NoPrefix.shortname:
                    noPrefix = new NoPrefix(e);
                    break;
                case TitleText.refname:
                case TitleText.shortname:
                    titleText = new TitleText(e);
                    break;
                case Subtitle.refname:
                case Subtitle.shortname:
                    subtitle = new Subtitle(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;TitleElement&gt; or &lt;titleelement&gt;) is explicitly provided in the ONIX XML
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

    private TitleElementLevel titleElementLevel = TitleElementLevel.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public TitleElementLevel titleElementLevel() {
        _initialize();
        return titleElementLevel;
    }

    private PartNumber partNumber = PartNumber.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public PartNumber partNumber() {
        _initialize();
        return partNumber;
    }

    private TitleWithoutPrefix titleWithoutPrefix = TitleWithoutPrefix.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public TitleWithoutPrefix titleWithoutPrefix() {
        _initialize();
        return titleWithoutPrefix;
    }

    private SequenceNumber sequenceNumber = SequenceNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SequenceNumber sequenceNumber() {
        _initialize();
        return sequenceNumber;
    }

    private YearOfAnnual yearOfAnnual = YearOfAnnual.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public YearOfAnnual yearOfAnnual() {
        _initialize();
        return yearOfAnnual;
    }

    private TitlePrefix titlePrefix = TitlePrefix.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TitlePrefix titlePrefix() {
        _initialize();
        return titlePrefix;
    }

    private NoPrefix noPrefix = NoPrefix.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public NoPrefix noPrefix() {
        _initialize();
        return noPrefix;
    }

    public boolean isNoPrefix() {
        return (noPrefix().exists());
    }

    private TitleText titleText = TitleText.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public TitleText titleText() {
        _initialize();
        return titleText;
    }

    private Subtitle subtitle = Subtitle.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public Subtitle subtitle() {
        _initialize();
        return subtitle;
    }

    @Override
    public JonixTitleElement asStruct() {
        _initialize();
        JonixTitleElement struct = new JonixTitleElement();
        struct.sequenceNumber = sequenceNumber.value;
        struct.titleElementLevel = titleElementLevel.value;
        struct.partNumber = partNumber.value;
        struct.yearOfAnnual = yearOfAnnual.value;
        struct.titlePrefix = titlePrefix.value;
        struct.isNoPrefix = isNoPrefix();
        struct.titleWithoutPrefix = titleWithoutPrefix.value;
        struct.titleText = titleText.value;
        struct.subtitle = subtitle.value;
        return struct;
    }
}
