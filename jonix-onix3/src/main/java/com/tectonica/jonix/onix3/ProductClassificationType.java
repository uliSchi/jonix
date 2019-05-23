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
 * <h1>Product classification type code</h1><p>An ONIX code identifying the scheme from which the identifier in &lt;ProductClassificationCode&gt; is taken. Mandatory in each occurrence of the &lt;ProductClassification&gt; composite, and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed length, two digits</td></tr><tr><td>Codelist</td><td>List 9</td></tr><tr><td>Reference name</td><td><tt>&lt;ProductClassificationType&gt;</tt></td></tr><tr><td>Short tag</td><td><tt>&lt;b274&gt;</tt></td></tr><tr><td>Cardinality</td><td>1</td></tr><tr><td>Example</td><td><tt>&lt;b274&gt;02&lt;/b063&gt;</tt> (UNSPSC)</td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;ProductClassification&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ ProductClassification ⯈ ProductClassificationType</li>
 * </ul>
 */
public class ProductClassificationType implements OnixElement<ProductClassificationTypes>, Serializable
{
   private static final long serialVersionUID = 1L;

   public static final String refname = "ProductClassificationType";
   public static final String shortname = "b274";

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

   public ProductClassificationTypes value;

   /**
   * Internal API, use the {@link #value()} method or the {@link #value} field instead
   */
   @Override
   public ProductClassificationTypes _value() {
      return value;
   }

   /////////////////////////////////////////////////////////////////////////////////
   // SERVICES
   /////////////////////////////////////////////////////////////////////////////////

   private final boolean exists;
   public static final ProductClassificationType EMPTY = new ProductClassificationType();

   public ProductClassificationType() {
      exists = false;
   }

   public ProductClassificationType(org.w3c.dom.Element element) {
      exists = true;
      datestamp = JPU.getAttribute(element, "datestamp");
      sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
      sourcename = JPU.getAttribute(element, "sourcename");

      value = ProductClassificationTypes.byCode(JPU.getContentAsString(element));
   }

   /**
    * @return whether this tag (&lt;ProductClassificationType&gt; or &lt;b274&gt;) is explicitly provided in the ONIX XML
    */
   @Override
   public boolean exists() {
      return exists;
   }
}
