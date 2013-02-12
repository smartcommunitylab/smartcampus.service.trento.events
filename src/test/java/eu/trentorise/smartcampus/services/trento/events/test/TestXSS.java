package eu.trentorise.smartcampus.services.trento.events.test;

import it.sayservice.platform.servicebus.test.XSSTestHelper;
import it.sayservice.xss.api.data.XSSData;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;



public class TestXSS {

	
	public static void main(String[] args) throws Exception {
		XSSTestHelper helper = new XSSTestHelper();
//		XSSData data = helper.processXHTMLFromHTTP("http://www.comune.trento.it/Citta/Vivi-la-citta/Eventi-in-citta/(day)/9/(month)/2/(year)/2013", 
//				new InputStreamReader(Compiler.class.getResourceAsStream("/service/trentoevents/day.xml")),"utf8");

		XSSData data = helper.processXHTMLFromReader(new FileReader(new File("src/test/resources/event.html")), 
				new InputStreamReader(Compiler.class.getResourceAsStream("/service/trentoevents/event.xml")));
		System.err.println(data);
		

	}
}

//http://www.operauni.tn.it/cms-01.00/articolo.asp?idcms=123&s=39
