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
import com.tectonica.jonix.common.ListOfOnixDataComposite;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixPrize;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link Product}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link CollateralDetail}</li>
 * </ul>
 */
public class CollateralDetail implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "CollateralDetail";
    public static final String shortname = "collateraldetail";

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
    public static final CollateralDetail EMPTY = new CollateralDetail();

    public CollateralDetail() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public CollateralDetail(org.w3c.dom.Element element) {
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
                case TextContent.refname:
                case TextContent.shortname:
                    textContents = JPU.addToList(textContents, new TextContent(e));
                    break;
                case CitedContent.refname:
                case CitedContent.shortname:
                    citedContents = JPU.addToList(citedContents, new CitedContent(e));
                    break;
                case SupportingResource.refname:
                case SupportingResource.shortname:
                    supportingResources = JPU.addToList(supportingResources, new SupportingResource(e));
                    break;
                case Prize.refname:
                case Prize.shortname:
                    prizes = JPU.addToList(prizes, new Prize(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;CollateralDetail&gt; or &lt;collateraldetail&gt;) is explicitly provided in the
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

    private List<TextContent> textContents = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<TextContent> textContents() {
        _initialize();
        return textContents;
    }

    private List<CitedContent> citedContents = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<CitedContent> citedContents() {
        _initialize();
        return citedContents;
    }

    private List<SupportingResource> supportingResources = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<SupportingResource> supportingResources() {
        _initialize();
        return supportingResources;
    }

    private ListOfOnixDataComposite<Prize, JonixPrize> prizes = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<Prize, JonixPrize> prizes() {
        _initialize();
        return prizes;
    }
}
