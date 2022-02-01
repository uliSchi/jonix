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
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.ListOfOnixElement;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.NameIdentifierTypes;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.struct.JonixSupplyContactIdentifier;

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
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link ProductSupply} ⯈ {@link SupplyDetail} ⯈ {@link SupplyContact}</li>
 * </ul>
 */
public class SupplyContact implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "SupplyContact";
    public static final String shortname = "supplycontact";

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
    public static final SupplyContact EMPTY = new SupplyContact();

    public SupplyContact() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public SupplyContact(org.w3c.dom.Element element) {
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
                case SupplyContactRole.refname:
                case SupplyContactRole.shortname:
                    supplyContactRole = new SupplyContactRole(e);
                    break;
                case SupplyContactIdentifier.refname:
                case SupplyContactIdentifier.shortname:
                    supplyContactIdentifiers = JPU.addToList(supplyContactIdentifiers, new SupplyContactIdentifier(e));
                    break;
                case SupplyContactName.refname:
                case SupplyContactName.shortname:
                    supplyContactName = new SupplyContactName(e);
                    break;
                case ContactName.refname:
                case ContactName.shortname:
                    contactName = new ContactName(e);
                    break;
                case EmailAddress.refname:
                case EmailAddress.shortname:
                    emailAddress = new EmailAddress(e);
                    break;
                case TelephoneNumber.refname:
                case TelephoneNumber.shortname:
                    telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;SupplyContact&gt; or &lt;supplycontact&gt;) is explicitly provided in the ONIX XML
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

    private SupplyContactRole supplyContactRole = SupplyContactRole.EMPTY;

    /**
     * Jonix-Comment: this field is required
     */
    public SupplyContactRole supplyContactRole() {
        _initialize();
        return supplyContactRole;
    }

    private ListOfOnixDataCompositeWithKey<SupplyContactIdentifier, JonixSupplyContactIdentifier, NameIdentifierTypes>
        supplyContactIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * Jonix-Comment: this list is required to contain at least one item
     */
    public ListOfOnixDataCompositeWithKey<SupplyContactIdentifier, JonixSupplyContactIdentifier, NameIdentifierTypes>
        supplyContactIdentifiers() {
        _initialize();
        return supplyContactIdentifiers;
    }

    private SupplyContactName supplyContactName = SupplyContactName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public SupplyContactName supplyContactName() {
        _initialize();
        return supplyContactName;
    }

    private ContactName contactName = ContactName.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public ContactName contactName() {
        _initialize();
        return contactName;
    }

    private EmailAddress emailAddress = EmailAddress.EMPTY;

    /**
     * Jonix-Comment: this field is optional
     */
    public EmailAddress emailAddress() {
        _initialize();
        return emailAddress;
    }

    private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

    /**
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers() {
        _initialize();
        return telephoneNumbers;
    }
}
