/*
 * Copyright (C) 2012 Zach Melamed
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

import java.io.Serializable;
import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>License expression link</h1><p>The URI for the license expression. Mandatory in each instance of the &lt;EpubLicenseExpression&gt; composite, and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable length text, suggested maximum length 300 characters</td></tr><tr><td>Reference name</td><td><tt>&lt;EpubLicenseExpressionLink&gt;</tt></td></tr><tr><td>Short tag</td><td><tt>&lt;x510&gt;</tt></td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Example</td><td><tt>&lt;EpubLicenseExpressionLink&gt;http://creativecommons.org/licenses/by/3.0/deed.en_GB&lt;/EpubLicenseExpressionLink&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;EpubLicenseExpression&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ EpubLicense ⯈ EpubLicenseExpression ⯈ EpubLicenseExpressionLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ EpubLicense ⯈ EpubLicenseExpression ⯈ EpubLicenseExpressionLink</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ EpubLicense ⯈ EpubLicenseExpression ⯈ EpubLicenseExpressionLink</li>
 * </ul>
 */
public class EpubLicenseExpressionLink implements OnixElement<String>, Serializable
{
   private static final long serialVersionUID = 1L;

   public static final String refname = "EpubLicenseExpressionLink";
   public static final String shortname = "x510";

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
   // VALUE MEMBER
   /////////////////////////////////////////////////////////////////////////////////

   /**
   * Raw Format: Variable length text, suggested maximum length 300 characters<p>
   * (type: dt.NonEmptyURI)
   */
   public String value;

   /**
   * Internal API, use the {@link #value()} method or the {@link #value} field instead
   */
   @Override
   public String _value() {
      return value;
   }

   /////////////////////////////////////////////////////////////////////////////////
   // SERVICES
   /////////////////////////////////////////////////////////////////////////////////

   private final boolean exists;
   public static final EpubLicenseExpressionLink EMPTY = new EpubLicenseExpressionLink();

   public EpubLicenseExpressionLink() {
      exists = false;
   }

   public EpubLicenseExpressionLink(org.w3c.dom.Element element) {
      exists = true;
      datestamp = JPU.getAttribute(element, "datestamp");
      sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
      sourcename = JPU.getAttribute(element, "sourcename");

      value = JPU.getContentAsString(element);
   }

   /**
    * @return whether this tag (&lt;EpubLicenseExpressionLink&gt; or &lt;x510&gt;) is explicitly provided in the ONIX XML
    */
   @Override
   public boolean exists() {
      return exists;
   }
}
