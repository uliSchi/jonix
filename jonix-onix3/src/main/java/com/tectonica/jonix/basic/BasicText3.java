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

package com.tectonica.jonix.basic;

import com.tectonica.jonix.basic.BasicText;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.onix3.Text;
import com.tectonica.jonix.onix3.TextContent;

/**
 * ONIX3 concrete implementation for {@link BasicText}
 * 
 * @author Zach Melamed
 */
public class BasicText3 extends BasicText
{
	private static final long serialVersionUID = 1L;

	public BasicText3(TextContent textContent)
	{
		textType = textContent.getTextTypeValue();
		Text textElement = pickTextObject(textContent);
		if (textElement != null) // invalid ONIX
		{
			textFormat = textElement.textformat;
			text = textElement.value;
		}
	}

	/**
	 * ONIX-3 requires at least one <Text> element, and allow more than one to provide translations in several
	 * languages. This simplistic implementation simply prioritizes English.
	 */
	private Text pickTextObject(TextContent textContent)
	{
		if (textContent.texts != null)
		{
			for (Text text : textContent.texts)
			{
				if (text.language == null || text.language == LanguageCodes.English)
					return text;
			}
			return textContent.texts.get(0); // return the first element, regardless of its language
		}
		return null;
	}
}