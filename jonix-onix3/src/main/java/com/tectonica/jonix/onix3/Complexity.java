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
import com.tectonica.jonix.common.struct.JonixComplexity;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link DescriptiveDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link Complexity}</li>
 * </ul>
 */
public class Complexity implements OnixDataComposite<JonixComplexity>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Complexity";
    public static final String shortname = "complexity";

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
    public static final Complexity EMPTY = new Complexity();

    public Complexity() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Complexity(org.w3c.dom.Element element) {
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
                case ComplexitySchemeIdentifier.refname:
                case ComplexitySchemeIdentifier.shortname:
                    complexitySchemeIdentifier = new ComplexitySchemeIdentifier(e);
                    break;
                case ComplexityCode.refname:
                case ComplexityCode.shortname:
                    complexityCode = new ComplexityCode(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Complexity&gt; or &lt;complexity&gt;) is explicitly provided in the ONIX XML
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

    private ComplexitySchemeIdentifier complexitySchemeIdentifier = ComplexitySchemeIdentifier.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ComplexitySchemeIdentifier complexitySchemeIdentifier() {
        _initialize();
        return complexitySchemeIdentifier;
    }

    private ComplexityCode complexityCode = ComplexityCode.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public ComplexityCode complexityCode() {
        _initialize();
        return complexityCode;
    }

    @Override
    public JonixComplexity asStruct() {
        _initialize();
        JonixComplexity struct = new JonixComplexity();
        struct.complexityCode = complexityCode.value;
        struct.complexitySchemeIdentifier = complexitySchemeIdentifier.value;
        return struct;
    }
}
