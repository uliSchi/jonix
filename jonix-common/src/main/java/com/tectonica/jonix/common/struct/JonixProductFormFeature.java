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

package com.tectonica.jonix.common.struct;

import com.tectonica.jonix.common.JonixKeyedStruct;
import com.tectonica.jonix.common.JonixStruct;
import com.tectonica.jonix.common.codelist.ProductFormFeatureTypes;

import java.io.Serializable;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * This class is a {@link JonixStruct} that represents both Onix2 <code>&lt;ProductFormFeature></code> and Onix3
 * <code>&lt;ProductFormFeature></code>.<p>It can be retrieved from the composite by invoking its
 * <code>asStruct()</code> method.
 */
@SuppressWarnings("serial")
public class JonixProductFormFeature implements JonixKeyedStruct<ProductFormFeatureTypes>, Serializable {
    public static final JonixProductFormFeature EMPTY = new JonixProductFormFeature();

    /**
     * the key of this struct (by which it can be looked up)
     */
    public ProductFormFeatureTypes productFormFeatureType;

    /**
     * (type: dt.NonEmptyString)
     */
    public List<String> productFormFeatureDescriptions;

    /**
     * (type: dt.NonEmptyString)
     */
    public String productFormFeatureValue;

    @Override
    public ProductFormFeatureTypes key() {
        return productFormFeatureType;
    }
}
