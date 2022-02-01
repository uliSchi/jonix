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
import com.tectonica.jonix.common.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.common.codelist.InsertPointTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixInsertPoint;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link InsertManifest}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link SupplementManifest} ⯈ {@link InsertManifest} ⯈ {@link InsertPoint}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductionDetail} ⯈ {@link ProductionManifest} ⯈ {@link InsertManifest} ⯈ {@link InsertPoint}</li>
 * </ul>
 */
public class InsertPoint implements OnixDataCompositeWithKey<JonixInsertPoint, InsertPointTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "InsertPoint";
    public static final String shortname = "insertpoint";

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
    public static final InsertPoint EMPTY = new InsertPoint();

    public InsertPoint() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public InsertPoint(org.w3c.dom.Element element) {
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
                case InsertPointType.refname:
                case InsertPointType.shortname:
                    insertPointType = new InsertPointType(e);
                    break;
                case InsertPointValue.refname:
                case InsertPointValue.shortname:
                    insertPointValue = new InsertPointValue(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;InsertPoint&gt; or &lt;insertpoint&gt;) is explicitly provided in the ONIX XML
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

    private InsertPointType insertPointType = InsertPointType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public InsertPointType insertPointType() {
        _initialize();
        return insertPointType;
    }

    private InsertPointValue insertPointValue = InsertPointValue.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public InsertPointValue insertPointValue() {
        _initialize();
        return insertPointValue;
    }

    @Override
    public JonixInsertPoint asStruct() {
        _initialize();
        JonixInsertPoint struct = new JonixInsertPoint();
        struct.insertPointType = insertPointType.value;
        struct.insertPointValue = insertPointValue.value;
        return struct;
    }

    @Override
    public InsertPointTypes structKey() {
        return insertPointType().value;
    }
}
