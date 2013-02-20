package eu.trentorise.smartcampus.services.trento.events.test;

import it.sayservice.platform.core.common.exception.ServiceException;
import it.sayservice.platform.servicebus.test.DataFlowTestHelper;

import java.util.HashMap;
import java.util.Map;

import eu.trentorise.smartcampus.services.trento.events.impl.GetEventsDataFlow;

public class TestDataFlow {

	public static void main(String[] args) throws ServiceException {
		DataFlowTestHelper helper = new DataFlowTestHelper();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("cities", "Trento");
		Map<String, Object> out = helper.executeDataFlow(
				"eu.trentorise.smartcampus.services.trento.events.TrentoEvents",
				"GetEvents", new GetEventsDataFlow(),
				map);
		System.err.println(out);
	}
}
