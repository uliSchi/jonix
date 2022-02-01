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
import com.tectonica.jonix.common.struct.JonixTerritory;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupportingResource}&gt;</li>
 * <li>&lt;{@link TextContent}&gt;</li>
 * <li>&lt;{@link CitedContent}&gt;</li>
 * <li>&lt;{@link Market}&gt;</li>
 * <li>&lt;{@link Price}&gt;</li>
 * <li>&lt;{@link SalesRights}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link SupportingResource} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link SupportingResource} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link SupportingResource} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link EventOccurrence} ⯈ {@link SupportingResource} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PromotionDetail} ⯈ {@link PromotionalEvent} ⯈ {@link SupportingResource} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link TextContent} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link TextContent} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link CitedContent} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail} ⯈ {@link CitedContent} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link Market} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link Territory}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link PublishingDetail} ⯈ {@link SalesRights} ⯈ {@link Territory}</li>
 * </ul>
 */
public class Territory implements OnixDataComposite<JonixTerritory>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Territory";
    public static final String shortname = "territory";

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
    public static final Territory EMPTY = new Territory();

    public Territory() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Territory(org.w3c.dom.Element element) {
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
                case CountriesIncluded.refname:
                case CountriesIncluded.shortname:
                    countriesIncluded = new CountriesIncluded(e);
                    break;
                case RegionsIncluded.refname:
                case RegionsIncluded.shortname:
                    regionsIncluded = new RegionsIncluded(e);
                    break;
                case RegionsExcluded.refname:
                case RegionsExcluded.shortname:
                    regionsExcluded = new RegionsExcluded(e);
                    break;
                case CountriesExcluded.refname:
                case CountriesExcluded.shortname:
                    countriesExcluded = new CountriesExcluded(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Territory&gt; or &lt;territory&gt;) is explicitly provided in the ONIX XML
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

    private CountriesIncluded countriesIncluded = CountriesIncluded.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public CountriesIncluded countriesIncluded() {
        _initialize();
        return countriesIncluded;
    }

    private RegionsIncluded regionsIncluded = RegionsIncluded.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public RegionsIncluded regionsIncluded() {
        _initialize();
        return regionsIncluded;
    }

    private RegionsExcluded regionsExcluded = RegionsExcluded.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public RegionsExcluded regionsExcluded() {
        _initialize();
        return regionsExcluded;
    }

    private CountriesExcluded countriesExcluded = CountriesExcluded.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public CountriesExcluded countriesExcluded() {
        _initialize();
        return countriesExcluded;
    }

    @Override
    public JonixTerritory asStruct() {
        _initialize();
        JonixTerritory struct = new JonixTerritory();
        struct.countriesIncluded = countriesIncluded.value;
        struct.regionsIncluded = regionsIncluded.value;
        struct.regionsExcluded = regionsExcluded.value;
        struct.countriesExcluded = countriesExcluded.value;
        return struct;
    }
}
