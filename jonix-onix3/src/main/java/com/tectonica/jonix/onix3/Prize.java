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
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPrize;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link CollateralDetail}&gt;</li>
 * <li>&lt;{@link Contributor}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link Prize}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Collection} ⯈ {@link Contributor} ⯈ {@link Prize}</li>
 * </ul>
 */
public class Prize implements OnixDataComposite<JonixPrize>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Prize";
    public static final String shortname = "prize";

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
    public static final Prize EMPTY = new Prize();

    public Prize() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Prize(org.w3c.dom.Element element) {
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
                case PrizeName.refname:
                case PrizeName.shortname:
                    prizeNames = JPU.addToList(prizeNames, new PrizeName(e));
                    break;
                case PrizeYear.refname:
                case PrizeYear.shortname:
                    prizeYear = new PrizeYear(e);
                    break;
                case PrizeCountry.refname:
                case PrizeCountry.shortname:
                    prizeCountry = new PrizeCountry(e);
                    break;
                case PrizeRegion.refname:
                case PrizeRegion.shortname:
                    prizeRegion = new PrizeRegion(e);
                    break;
                case PrizeCode.refname:
                case PrizeCode.shortname:
                    prizeCode = new PrizeCode(e);
                    break;
                case PrizeStatement.refname:
                case PrizeStatement.shortname:
                    prizeStatements = JPU.addToList(prizeStatements, new PrizeStatement(e));
                    break;
                case PrizeJury.refname:
                case PrizeJury.shortname:
                    prizeJurys = JPU.addToList(prizeJurys, new PrizeJury(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Prize&gt; or &lt;prize&gt;) is explicitly provided in the ONIX XML
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

    private ListOfOnixElement<PrizeName, String> prizeNames = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixElement<PrizeName, String> prizeNames() {
        _initialize();
        return prizeNames;
    }

    private PrizeYear prizeYear = PrizeYear.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PrizeYear prizeYear() {
        _initialize();
        return prizeYear;
    }

    private PrizeCountry prizeCountry = PrizeCountry.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PrizeCountry prizeCountry() {
        _initialize();
        return prizeCountry;
    }

    private PrizeRegion prizeRegion = PrizeRegion.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PrizeRegion prizeRegion() {
        _initialize();
        return prizeRegion;
    }

    private PrizeCode prizeCode = PrizeCode.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public PrizeCode prizeCode() {
        _initialize();
        return prizeCode;
    }

    private ListOfOnixElement<PrizeStatement, String> prizeStatements = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PrizeStatement, String> prizeStatements() {
        _initialize();
        return prizeStatements;
    }

    private ListOfOnixElement<PrizeJury, String> prizeJurys = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<PrizeJury, String> prizeJurys() {
        _initialize();
        return prizeJurys;
    }

    @Override
    public JonixPrize asStruct() {
        _initialize();
        JonixPrize struct = new JonixPrize();
        struct.prizeCode = prizeCode.value;
        struct.prizeCountry = prizeCountry.value;
        struct.prizeJurys = prizeJurys.values();
        struct.prizeNames = prizeNames.values();
        struct.prizeYear = prizeYear.value;
        return struct;
    }
}
