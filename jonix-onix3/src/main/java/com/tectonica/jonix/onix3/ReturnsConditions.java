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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.ReturnsConditionsCodeTypes;
import com.tectonica.jonix.common.struct.JonixReturnsConditions;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link ReturnsConditions}</li>
 * </ul>
 */
public class ReturnsConditions
    implements OnixDataCompositeWithKey<JonixReturnsConditions, ReturnsConditionsCodeTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "ReturnsConditions";
    public static final String shortname = "returnsconditions";

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
    public static final ReturnsConditions EMPTY = new ReturnsConditions();

    public ReturnsConditions() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public ReturnsConditions(org.w3c.dom.Element element) {
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
                case ReturnsCodeType.refname:
                case ReturnsCodeType.shortname:
                    returnsCodeType = new ReturnsCodeType(e);
                    break;
                case ReturnsCode.refname:
                case ReturnsCode.shortname:
                    returnsCode = new ReturnsCode(e);
                    break;
                case ReturnsCodeTypeName.refname:
                case ReturnsCodeTypeName.shortname:
                    returnsCodeTypeName = new ReturnsCodeTypeName(e);
                    break;
                case ReturnsNote.refname:
                case ReturnsNote.shortname:
                    returnsNotes = JPU.addToList(returnsNotes, new ReturnsNote(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;ReturnsConditions&gt; or &lt;returnsconditions&gt;) is explicitly provided in the
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

    private ReturnsCodeType returnsCodeType = ReturnsCodeType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ReturnsCodeType returnsCodeType() {
        _initialize();
        return returnsCodeType;
    }

    private ReturnsCode returnsCode = ReturnsCode.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ReturnsCode returnsCode() {
        _initialize();
        return returnsCode;
    }

    private ReturnsCodeTypeName returnsCodeTypeName = ReturnsCodeTypeName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ReturnsCodeTypeName returnsCodeTypeName() {
        _initialize();
        return returnsCodeTypeName;
    }

    private ListOfOnixElement<ReturnsNote, String> returnsNotes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<ReturnsNote, String> returnsNotes() {
        _initialize();
        return returnsNotes;
    }

    @Override
    public JonixReturnsConditions asStruct() {
        _initialize();
        JonixReturnsConditions struct = new JonixReturnsConditions();
        struct.returnsCodeType = returnsCodeType.value;
        struct.returnsCodeTypeName = returnsCodeTypeName.value;
        struct.returnsCode = returnsCode.value;
        struct.returnsNotes = returnsNotes.values();
        return struct;
    }

    @Override
    public ReturnsConditionsCodeTypes structKey() {
        return returnsCodeType().value;
    }
}
