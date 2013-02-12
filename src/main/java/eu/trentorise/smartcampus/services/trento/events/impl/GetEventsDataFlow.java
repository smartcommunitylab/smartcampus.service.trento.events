package eu.trentorise.smartcampus.services.trento.events.impl;

import it.sayservice.platform.core.common.util.AppConfig;
import it.sayservice.platform.core.bus.service.xss.XSSDocumentParser;
import it.sayservice.platform.core.bus.service.compiler.InvokeConnector;
import it.sayservice.platform.core.bus.service.compiler.InvokeDataFlowScriptNode;
import it.sayservice.xss.api.data.XSSData;
import it.sayservice.xss.api.XSSDataException;
import it.sayservice.platform.core.bus.service.dataflow.ServiceDataFlow;
import java.util.ArrayList;
import java.io.Reader;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.w3c.dom.Document;
import bsh.Interpreter;
import bsh.EvalError;
import bsh.ParseException;
import bsh.TargetError;
import com.google.protobuf.Message;
import org.apache.log4j.Logger;
import it.sayservice.platform.core.bus.common.exception.*;
import javax.script.ScriptException;
import it.sayservice.platform.core.bus.service.ServiceMethod;
import it.sayservice.platform.core.i18n.ExceptionMessage;
import it.sayservice.platform.core.bus.service.compiler.InvokeGeolocalize;
import it.sayservice.platform.core.bus.service.compiler.InvokeScript;
import it.sayservice.platform.core.bus.service.compiler.InvokeMerge;
import it.sayservice.platform.core.bus.service.compiler.InvokeConstructor;
import it.sayservice.platform.core.bus.service.compiler.InvokeFilter;
import it.sayservice.platform.core.bus.service.compiler.InvokeTransformer;
import it.sayservice.platform.core.bus.service.compiler.InvokeVariableValidation;
import it.sayservice.platform.core.message.ProtoBean;


/**
*
* Generated DataFlow class: DO NOT EDIT!
*
*/
public class GetEventsDataFlow implements ServiceDataFlow {

	Logger log = Logger.getLogger(this.getClass());


	private Map<String, Object> contextVariables;

	private String htmlString;
	private org.w3c.dom.Document html;
	private eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage dayProto;
	private java.util.List<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr> descriptors;
	private java.util.List<String> dates;
	private java.util.List<String> pages;
	private eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent eventMsg;

	private ServiceMethod serviceMethod;

	public GetEventsDataFlow () {
		this.contextVariables = new HashMap<String, Object>();
	}

	public void setServiceMethod(ServiceMethod serviceMethod) {
		this.serviceMethod = serviceMethod;	
	}

	public List<Message> invoke(String serviceExecutionId, Map<String, Object> parameters) throws DataFlowException {
	contextVariables.put("htmlString", htmlString);
	contextVariables.put("html", html);
	contextVariables.put("dayProto", dayProto);
	contextVariables.put("descriptors", descriptors);
	contextVariables.put("dates", dates);
	contextVariables.put("pages", pages);
	contextVariables.put("eventMsg", eventMsg);


		List<Message> output = new java.util.ArrayList<Message>();
		try {
		String cities = null;
		if (!(parameters.get("cities") instanceof String)) {
				throw new DataFlowException(ExceptionMessage.PARAMETER_INCORRECT);
		} else {
				cities = (String)parameters.get("cities");
		}
		contextVariables.put("cities", cities);
		InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "cities", cities);

		
		//Connector (HTTP)
		it.sayservice.platform.core.bus.service.connector.HTTPConnector connector = new it.sayservice.platform.core.bus.service.connector.HTTPConnector();
		connector.setSessionSupport("REQUIRED", null);
		connector.setPost(false);
		connector.setEncoding("ISO-8859-1");

		//Connector (HTTP)
		it.sayservice.platform.core.bus.service.connector.HTTPConnector pageConnector = new it.sayservice.platform.core.bus.service.connector.HTTPConnector();
		pageConnector.setSessionSupport("MANDATORY", connector);
		pageConnector.setPost(false);
		pageConnector.setEncoding("ISO-8859-1");

		//Script
		{
		try {
			java.util.List<java.lang.String> scriptResult1 = (java.util.List<java.lang.String>)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "getDates", "", contextVariables, serviceExecutionId, serviceMethod);
			dates = (java.util.List<String>)scriptResult1;
			contextVariables.put("dates", dates);
			InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "dates", dates);
			} catch (Exception e0) {
				log.error("DataFlow Error: " + e0.getClass().getName());
				throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
			}
		}

		//Foreach
		Collection eventList = new java.util.ArrayList();
		for (String date: (Collection<String>)InvokeScript.invoke("dates", contextVariables)) {
			contextVariables.put("date", date);
			InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "date", date);
			contextVariables.put("eventList", eventList);
			InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "eventList", eventList);

			//Connect
			connector.setUrl((String)InvokeScript.invoke("\"http://www.trentinocultura.net/asp_cat/main.asp?data=\"+date+\"&IDProspettiva=35&SearchType=AGENDA_SEARCH&TipoVista=Elenco&Pag=1\"", contextVariables));
			try {
				InvokeConnector<java.io.Reader> connectorInvoker = new InvokeConnector<java.io.Reader>();
			java.io.Reader connectResult1 = connectorInvoker.invoke(connector, "connector", "htmlString", serviceExecutionId, serviceMethod);
			it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer connectTransformer1 = new it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer();
			htmlString = (String)connectTransformer1.transform(connectResult1);
				contextVariables.put("htmlString", htmlString);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "htmlString", htmlString);
				} catch (ConnectorException e0) {
					log.error("DataFlow Error: " + e0.getClass().getName());
					throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e0);
				} catch (TransformerException e1) {
					log.error("DataFlow Error: " + e1.getClass().getName());
					throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e1);
				}

			//Script
			{
			try {
				org.w3c.dom.Document scriptResult2 = (org.w3c.dom.Document)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "transformHtml", "htmlString", contextVariables, serviceExecutionId, serviceMethod);
				html = (org.w3c.dom.Document)scriptResult2;
				contextVariables.put("html", html);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "html", html);
				} catch (Exception e0) {
					log.error("DataFlow Error: " + e0.getClass().getName());
					throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
				}
			}

			//XSS
			XSSDocumentParser xssParser1 = new XSSDocumentParser(serviceMethod.getXSSParserFactory(),"service/trentoevents/trentinocultura-elenco.xss.xml");
			try {
							XSSData xssData1 = xssParser1.parse((org.w3c.dom.Document)InvokeScript.invoke("html", contextVariables), serviceExecutionId, serviceMethod, true);
				eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventPageProtoBean xssProtoBean1 = new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventPageProtoBean(xssData1);
				dayProto = (eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage) xssProtoBean1.buildMessage();
				contextVariables.put("dayProto", dayProto);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "dayProto", dayProto);
				} catch (XSSException e0) {
					log.error("DataFlow Error: " + e0.getClass().getName());
					throw new DataFlowException(ExceptionMessage.XSS_ERROR, e0);
				} catch (XSSDataException e1) {
					log.error("DataFlow Error: " + e1.getClass().getName());
					throw new DataFlowException(ExceptionMessage.XSS_ERROR, e1);
				}

			//Script
			{
			try {
				java.util.List<java.lang.String> scriptResult3 = (java.util.List<java.lang.String>)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "extractPages", "dayProto", contextVariables, serviceExecutionId, serviceMethod);
				pages = (java.util.List<String>)scriptResult3;
				contextVariables.put("pages", pages);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "pages", pages);
				} catch (Exception e0) {
					log.error("DataFlow Error: " + e0.getClass().getName());
					throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
				}
			}

			//Script
			{
			try {
				java.util.List<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr> scriptResult4 = (java.util.List<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr>)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "createDescriptors", "dayProto,cities", contextVariables, serviceExecutionId, serviceMethod);
				descriptors = (java.util.List<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr>)scriptResult4;
				contextVariables.put("descriptors", descriptors);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "descriptors", descriptors);
				} catch (Exception e0) {
					log.error("DataFlow Error: " + e0.getClass().getName());
					throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
				}
			}

			//Foreach
			Collection tmp = new java.util.ArrayList();
			for (String page: (Collection<String>)InvokeScript.invoke("pages", contextVariables)) {
				contextVariables.put("page", page);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "page", page);
				contextVariables.put("tmp", tmp);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "tmp", tmp);

				//Connect
				pageConnector.setUrl((String)InvokeScript.invoke("\"http://www.trentinocultura.net/asp_cat/main.asp?data=\"+date+\"&IDProspettiva=35&SearchType=AGENDA_SEARCH&TipoVista=Elenco&Pag=\"+page", contextVariables));
				try {
					InvokeConnector<java.io.Reader> pageConnectorInvoker = new InvokeConnector<java.io.Reader>();
			java.io.Reader connectResult2 = pageConnectorInvoker.invoke(pageConnector, "pageConnector", "htmlString", serviceExecutionId, serviceMethod);
			it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer connectTransformer2 = new it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer();
			htmlString = (String)connectTransformer2.transform(connectResult2);
					contextVariables.put("htmlString", htmlString);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "htmlString", htmlString);
					} catch (ConnectorException e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e0);
					} catch (TransformerException e1) {
						log.error("DataFlow Error: " + e1.getClass().getName());
						throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e1);
					}

				//Script
				{
				try {
					org.w3c.dom.Document scriptResult5 = (org.w3c.dom.Document)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "transformHtml", "htmlString", contextVariables, serviceExecutionId, serviceMethod);
					html = (org.w3c.dom.Document)scriptResult5;
					contextVariables.put("html", html);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "html", html);
					} catch (Exception e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
					}
				}

				//XSS
				XSSDocumentParser xssParser2 = new XSSDocumentParser(serviceMethod.getXSSParserFactory(),"service/trentoevents/trentinocultura-elenco.xss.xml");
				try {
									XSSData xssData2 = xssParser2.parse((org.w3c.dom.Document)InvokeScript.invoke("html", contextVariables), serviceExecutionId, serviceMethod, true);
					eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventPageProtoBean xssProtoBean2 = new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventPageProtoBean(xssData2);
					dayProto = (eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage) xssProtoBean2.buildMessage();
					contextVariables.put("dayProto", dayProto);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "dayProto", dayProto);
					} catch (XSSException e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.XSS_ERROR, e0);
					} catch (XSSDataException e1) {
						log.error("DataFlow Error: " + e1.getClass().getName());
						throw new DataFlowException(ExceptionMessage.XSS_ERROR, e1);
					}

				//Script
				{
				try {
					java.util.List<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr> scriptResult6 = (java.util.List<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr>)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "mergeDescriptors", "descriptors,dayProto,cities", contextVariables, serviceExecutionId, serviceMethod);
					descriptors = (java.util.List<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr>)scriptResult6;
					contextVariables.put("descriptors", descriptors);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "descriptors", descriptors);
					} catch (Exception e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
					}
				}

			}
			pages = (java.util.ArrayList)tmp;
			contextVariables.put("pages", pages);
			contextVariables.remove("page");
			contextVariables.remove("tmp");

			//Foreach
			Collection dayEventList = new java.util.ArrayList();
			for (eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr evtDescr: (Collection<eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr>)InvokeScript.invoke("descriptors", contextVariables)) {
				contextVariables.put("evtDescr", evtDescr);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "evtDescr", evtDescr);
				contextVariables.put("dayEventList", dayEventList);
				InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "dayEventList", dayEventList);

				//Connect
				pageConnector.setUrl((String)InvokeScript.invoke("\"http://www.trentinocultura.net\"+evtDescr.getLink()", contextVariables));
				try {
					InvokeConnector<java.io.Reader> pageConnectorInvoker = new InvokeConnector<java.io.Reader>();
			java.io.Reader connectResult3 = pageConnectorInvoker.invoke(pageConnector, "pageConnector", "htmlString", serviceExecutionId, serviceMethod);
			it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer connectTransformer3 = new it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer();
			htmlString = (String)connectTransformer3.transform(connectResult3);
					contextVariables.put("htmlString", htmlString);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "htmlString", htmlString);
					} catch (ConnectorException e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e0);
					} catch (TransformerException e1) {
						log.error("DataFlow Error: " + e1.getClass().getName());
						throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e1);
					}

				//Script
				{
				try {
					org.w3c.dom.Document scriptResult7 = (org.w3c.dom.Document)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "transformHtml", "htmlString", contextVariables, serviceExecutionId, serviceMethod);
					html = (org.w3c.dom.Document)scriptResult7;
					contextVariables.put("html", html);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "html", html);
					} catch (Exception e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
					}
				}

				//XSS
				XSSDocumentParser xssParser3 = new XSSDocumentParser(serviceMethod.getXSSParserFactory(),"service/trentoevents/trentinocultura-singolo.xss.xml");
				try {
									XSSData xssData3 = xssParser3.parse((org.w3c.dom.Document)InvokeScript.invoke("html", contextVariables), serviceExecutionId, serviceMethod, true);
					eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventProtoBean xssProtoBean3 = new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventProtoBean(xssData3);
					eventMsg = (eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent) xssProtoBean3.buildMessage();
					contextVariables.put("eventMsg", eventMsg);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "eventMsg", eventMsg);
					} catch (XSSException e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.XSS_ERROR, e0);
					} catch (XSSDataException e1) {
						log.error("DataFlow Error: " + e1.getClass().getName());
						throw new DataFlowException(ExceptionMessage.XSS_ERROR, e1);
					}

				//Geolocalize
				try {
					it.sayservice.platform.core.message.Core.POI poi1 = InvokeGeolocalize.geolocalize((String)InvokeScript.invoke("eventMsg.getPlace()", contextVariables), serviceExecutionId, true, serviceMethod);
				it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean poiBean1 = new it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean(poi1);
				ProtoBean localizeOutBean1 = new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventProtoBean(eventMsg);
				Interpreter interpreter1= new Interpreter();
				interpreter1.set("outpoibean", localizeOutBean1);
				interpreter1.set("value", poiBean1);
				interpreter1.eval("outpoibean.poi = value");
				eventMsg = (eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent)((ProtoBean)interpreter1.get("outpoibean")).buildMessage();
					contextVariables.put("eventMsg", eventMsg);
					} catch (LocalizeException e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						continue;
					}

				//Script
				{
				try {
					Object scriptResult8 = (Object)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.trento.events.scripts.EventsScript.class, "updateDate", "eventMsg", contextVariables, serviceExecutionId, serviceMethod);
					dayEventList.add(scriptResult8);
					contextVariables.put("dayEventList", dayEventList);
					InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "dayEventList", dayEventList);
					} catch (Exception e0) {
						log.error("DataFlow Error: " + e0.getClass().getName());
						throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
					}
				}

			}
			eventList.addAll(dayEventList);
			contextVariables.remove("evtDescr");
			contextVariables.remove("dayEventList");

		}
		output.addAll(eventList);
		contextVariables.remove("date");
		contextVariables.remove("eventList");

	return output;
	} catch (ParseException pe) {
		log.error("Script Error: Parse Exception.", pe);
		throw new DataFlowException(pe.getMessage(), pe);
	} catch (EvalError ee) {
		log.error("Script Error: Eval Error.", ee);
		throw new DataFlowException(ee.getMessage(), ee);
	} catch (Exception e) {
		if (e instanceof DataFlowException) {
			throw (DataFlowException)e;
		} else {
			log.error("Unexpected Error", e);
			throw new DataFlowException(e.getMessage(), e);
		}
	}
	}

	public Message.Builder getOutputBuilder() {
		return eu.trentorise.smartcampus.services.trento.events.data.message.Events.Event.newBuilder();
	}

	public void resetXSS() {
		serviceMethod.getXSSParserFactory().undeploy("service/trentoevents/trentinocultura-elenco.xss.xml");
		serviceMethod.getXSSParserFactory().undeploy("service/trentoevents/trentinocultura-elenco.xss.xml");
		serviceMethod.getXSSParserFactory().undeploy("service/trentoevents/trentinocultura-singolo.xss.xml");
	}

}
