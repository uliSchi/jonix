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
import com.tectonica.jonix.common.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixEpubLicenseExpression;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link EpubLicense}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link DescriptiveDetail} ⯈ {@link EpubLicense} ⯈ {@link EpubLicenseExpression}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Reissue} ⯈ {@link Price} ⯈ {@link EpubLicense} ⯈ {@link EpubLicenseExpression}</li>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link Price} ⯈ {@link EpubLicense} ⯈ {@link EpubLicenseExpression}</li>
 * </ul>
 */
public class EpubLicenseExpression
    implements OnixDataCompositeWithKey<JonixEpubLicenseExpression, LicenseExpressionTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseExpression";
    public static final String shortname = "epublicenseexpression";

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
    public static final EpubLicenseExpression EMPTY = new EpubLicenseExpression();

    public EpubLicenseExpression() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubLicenseExpression(org.w3c.dom.Element element) {
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
                case EpubLicenseExpressionType.refname:
                case EpubLicenseExpressionType.shortname:
                    epubLicenseExpressionType = new EpubLicenseExpressionType(e);
                    break;
                case EpubLicenseExpressionLink.refname:
                case EpubLicenseExpressionLink.shortname:
                    epubLicenseExpressionLink = new EpubLicenseExpressionLink(e);
                    break;
                case EpubLicenseExpressionTypeName.refname:
                case EpubLicenseExpressionTypeName.shortname:
                    epubLicenseExpressionTypeName = new EpubLicenseExpressionTypeName(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;EpubLicenseExpression&gt; or &lt;epublicenseexpression&gt;) is explicitly provided
     *         in the ONIX XML
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

    private EpubLicenseExpressionType epubLicenseExpressionType = EpubLicenseExpressionType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public EpubLicenseExpressionType epubLicenseExpressionType() {
        _initialize();
        return epubLicenseExpressionType;
    }

    private EpubLicenseExpressionLink epubLicenseExpressionLink = EpubLicenseExpressionLink.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public EpubLicenseExpressionLink epubLicenseExpressionLink() {
        _initialize();
        return epubLicenseExpressionLink;
    }

    private EpubLicenseExpressionTypeName epubLicenseExpressionTypeName = EpubLicenseExpressionTypeName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EpubLicenseExpressionTypeName epubLicenseExpressionTypeName() {
        _initialize();
        return epubLicenseExpressionTypeName;
    }

    @Override
    public JonixEpubLicenseExpression asStruct() {
        _initialize();
        JonixEpubLicenseExpression struct = new JonixEpubLicenseExpression();
        struct.epubLicenseExpressionType = epubLicenseExpressionType.value;
        struct.epubLicenseExpressionTypeName = epubLicenseExpressionTypeName.value;
        struct.epubLicenseExpressionLink = epubLicenseExpressionLink.value;
        return struct;
    }

    @Override
    public LicenseExpressionTypes structKey() {
        return epubLicenseExpressionType().value;
    }
}
