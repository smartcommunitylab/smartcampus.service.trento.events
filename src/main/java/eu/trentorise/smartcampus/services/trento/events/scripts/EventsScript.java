/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
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
 ******************************************************************************/
package eu.trentorise.smartcampus.services.trento.events.scripts;

import it.sayservice.platform.core.bus.common.exception.TransformerException;
import it.sayservice.platform.core.bus.service.transformer.ReaderToXMLTransformer;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.w3c.dom.Document;

import eu.trentorise.smartcampus.services.trento.events.data.message.Events;
import eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent;
import eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr;
import eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage;

public class EventsScript {

	private static final String DATE_FORMAT_SHORT = "dd/MM/yyyy";
	private static final int horizon = 7;

	public Document transformHtml(String html) throws IOException, TransformerException {
		CleanerProperties props = new CleanerProperties();
		// set some properties to non-default values
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);
		// do parsing
		TagNode tagNode = new HtmlCleaner(props).clean(html);
		// serialize to xml file
		
		ReaderToXMLTransformer transformer = new ReaderToXMLTransformer();
		return transformer.transform(new StringReader(new PrettyXmlSerializer(props).getAsString(tagNode)));
	} 
	
	public List<String> getDates() {
		List<String> res = new ArrayList<String>(horizon-1);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_SHORT);
		for (int i = 0; i < horizon; i++) {
			res.add(sdf.format(c.getTime()));
			c.add(Calendar.DATE, 1);
		}
		return res;
	}
	
	public List<String> extractPages(TCEventPage pageDescr) {
		List<String> res = new ArrayList<String>();
		for (int i = 1; i <= pageDescr.getTotalpages(); i++) {
			res.add(""+i);
		}
		return res;
	}
	
	/**
	 * 
	 * @param list to merge to
	 * @param pageDescr event descriptors in the current page 
	 * @param cities comma-separated list of cities (localita') to consider for filtering.
	 * @return merged list
	 */
	public List<TCEventDescr> mergeDescriptors(List<TCEventDescr> list, TCEventPage pageDescr, String cities) {
		List<TCEventDescr> res = new ArrayList<Events.TCEventDescr>();
		if (list != null && !list.isEmpty()) res.addAll(list);
		String citiesExt = ","+cities+",";
		if (pageDescr != null && pageDescr.getEventsCount() > 0) {
			for (TCEventDescr d : pageDescr.getEventsList()) {
				if (citiesExt.contains(","+d.getCity()+",")) {
					res.add(d);
				}
			}
		}
		return res;
	}
	public List<TCEventDescr> createDescriptors(TCEventPage pageDescr, String cities) {
		return mergeDescriptors(null, pageDescr, cities);
	}

	public TCEvent updateDate(TCEvent evt, String date) {
		TCEvent.Builder builder = TCEvent.newBuilder(evt);
		builder.setEventDate(date);
		return builder.build();
	}
}
