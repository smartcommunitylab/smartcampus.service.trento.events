package eu.trentorise.smartcampus.services.trento.events.test;

import it.sayservice.platform.servicebus.test.XSSTestHelper;
import it.sayservice.xss.api.data.XSSData;

import java.io.FileReader;
import java.io.StringReader;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;



public class TestXSSTrentinoCultura {

	
	public static void main(String[] args) throws Exception {
//		XSSTestHelper helper = new XSSTestHelper();
//		XSSData data = helper.processXHTMLFromHTTP("http://www.trentinocultura.net/asp_cat/main.asp?data=10/02/2013&IDProspettiva=35&SearchType=AGENDA_SEARCH&TipoVista=Elenco&Pag=1", 
//				new InputStreamReader(Compiler.class.getResourceAsStream("/service/trentoevents/trentinocultura-elenco.xss.xml")),"utf8");

		CleanerProperties props = new CleanerProperties();
		// set some properties to non-default values
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);
		// do parsing
		TagNode tagNode = new HtmlCleaner(props)
				.clean(new FileReader(
						"src/test/resources/elenco.html"));
		// serialize to xml file
		String s = new PrettyXmlSerializer(props).getAsString(tagNode);
		XSSTestHelper helper = new XSSTestHelper();

		XSSData data = helper
				.processXHTMLFromReader(
						new StringReader(s),
						new FileReader(
								"src/main/resources/service/trentoevents/trentinocultura-elenco.xss.xml"));
		System.err.println(data);
	}
}
