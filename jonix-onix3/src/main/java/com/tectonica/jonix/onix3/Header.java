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
import com.tectonica.jonix.common.OnixHeader;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Header}</li>
 * </ul>
 */
public class Header implements OnixHeader, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Header";
    public static final String shortname = "header";

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
    public static final Header EMPTY = new Header();

    public Header() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Header(org.w3c.dom.Element element) {
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
                case Sender.refname:
                case Sender.shortname:
                    sender = new Sender(e);
                    break;
                case SentDateTime.refname:
                case SentDateTime.shortname:
                    sentDateTime = new SentDateTime(e);
                    break;
                case MessageNumber.refname:
                case MessageNumber.shortname:
                    messageNumber = new MessageNumber(e);
                    break;
                case MessageRepeat.refname:
                case MessageRepeat.shortname:
                    messageRepeat = new MessageRepeat(e);
                    break;
                case DefaultLanguageOfText.refname:
                case DefaultLanguageOfText.shortname:
                    defaultLanguageOfText = new DefaultLanguageOfText(e);
                    break;
                case DefaultPriceType.refname:
                case DefaultPriceType.shortname:
                    defaultPriceType = new DefaultPriceType(e);
                    break;
                case DefaultCurrencyCode.refname:
                case DefaultCurrencyCode.shortname:
                    defaultCurrencyCode = new DefaultCurrencyCode(e);
                    break;
                case Addressee.refname:
                case Addressee.shortname:
                    addressees = JPU.addToList(addressees, new Addressee(e));
                    break;
                case MessageNote.refname:
                case MessageNote.shortname:
                    messageNotes = JPU.addToList(messageNotes, new MessageNote(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Header&gt; or &lt;header&gt;) is explicitly provided in the ONIX XML
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

    private Sender sender = Sender.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public Sender sender() {
        _initialize();
        return sender;
    }

    private SentDateTime sentDateTime = SentDateTime.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public SentDateTime sentDateTime() {
        _initialize();
        return sentDateTime;
    }

    private MessageNumber messageNumber = MessageNumber.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public MessageNumber messageNumber() {
        _initialize();
        return messageNumber;
    }

    private MessageRepeat messageRepeat = MessageRepeat.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public MessageRepeat messageRepeat() {
        _initialize();
        return messageRepeat;
    }

    private DefaultLanguageOfText defaultLanguageOfText = DefaultLanguageOfText.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public DefaultLanguageOfText defaultLanguageOfText() {
        _initialize();
        return defaultLanguageOfText;
    }

    private DefaultPriceType defaultPriceType = DefaultPriceType.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public DefaultPriceType defaultPriceType() {
        _initialize();
        return defaultPriceType;
    }

    private DefaultCurrencyCode defaultCurrencyCode = DefaultCurrencyCode.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public DefaultCurrencyCode defaultCurrencyCode() {
        _initialize();
        return defaultCurrencyCode;
    }

    private List<Addressee> addressees = Collections.emptyList();

    /**
     * Jonix-Comment: this list may be empty
     */
    public List<Addressee> addressees() {
        _initialize();
        return addressees;
    }

    private ListOfOnixElement<MessageNote, String> messageNotes = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<MessageNote, String> messageNotes() {
        _initialize();
        return messageNotes;
    }
}
