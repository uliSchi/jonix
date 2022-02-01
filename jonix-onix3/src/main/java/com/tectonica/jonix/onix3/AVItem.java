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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.AvItemIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixAVItemIdentifier;
import com.tectonica.jonix.common.struct.JonixTimeRun;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ContentItem}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ContentDetail} ⯈ {@link ContentItem} ⯈ {@link AVItem}</li>
 * </ul>
 */
public class AVItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AVItem";
    public static final String shortname = "avitem";

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
    public static final AVItem EMPTY = new AVItem();

    public AVItem() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AVItem(org.w3c.dom.Element element) {
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
                case AVItemType.refname:
                case AVItemType.shortname:
                    avItemType = new AVItemType(e);
                    break;
                case AVDuration.refname:
                case AVDuration.shortname:
                    avDuration = new AVDuration(e);
                    break;
                case AVItemIdentifier.refname:
                case AVItemIdentifier.shortname:
                    avItemIdentifiers = JPU.addToList(avItemIdentifiers, new AVItemIdentifier(e));
                    break;
                case TimeRun.refname:
                case TimeRun.shortname:
                    timeRuns = JPU.addToList(timeRuns, new TimeRun(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;AVItem&gt; or &lt;avitem&gt;) is explicitly provided in the ONIX XML
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

    private AVItemType avItemType = AVItemType.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public AVItemType avItemType() {
        _initialize();
        return avItemType;
    }

    private AVDuration avDuration = AVDuration.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public AVDuration avDuration() {
        _initialize();
        return avDuration;
    }

    private ListOfOnixDataCompositeWithKey<AVItemIdentifier, JonixAVItemIdentifier, AvItemIdentifierTypes>
        avItemIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<AVItemIdentifier, JonixAVItemIdentifier, AvItemIdentifierTypes>
        avItemIdentifiers() {
        _initialize();
        return avItemIdentifiers;
    }

    private ListOfOnixDataComposite<TimeRun, JonixTimeRun> timeRuns = ListOfOnixDataComposite.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataComposite<TimeRun, JonixTimeRun> timeRuns() {
        _initialize();
        return timeRuns;
    }
}
