package eu.trentorise.smartcampus.services.trento.events.impl;

import it.sayservice.platform.core.bus.service.Service;
import it.sayservice.platform.core.bus.service.ServiceEngineInterface;
import it.sayservice.platform.core.bus.service.ServiceExecutorParameters;
import it.sayservice.platform.core.bus.service.ServiceMethod;
import it.sayservice.platform.core.bus.service.ServiceParameters;
import it.sayservice.platform.core.bus.service.dataflow.ServiceDataFlow;
import it.sayservice.platform.core.bus.service.management.ServiceStatus;
import it.sayservice.platform.core.bus.service.management.ServiceValidation;
import it.sayservice.platform.core.bus.service.persistence.ServicePersistence;
import it.sayservice.platform.core.common.exception.EntityNotFoundException;
import it.sayservice.platform.core.common.exception.ServiceException;
import it.sayservice.platform.core.bus.cache.CacheManagerFactory;
import it.sayservice.platform.core.bus.data.dao.ServiceStatusDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
*
* Generated Service class: DO NOT EDIT!
*
*/
public class ServiceImpl extends Service implements ServiceEngineInterface {

	private static final String SERVICE_ID = "eu.trentorise.smartcampus.services.trento.events.TrentoEvents";
	
	
	private ServiceParameters serviceParameters;

    public ServiceImpl () {
    }

    public ServiceImpl (
            Map<String, Long> defaultEventPersistenceConf,
            Map<String, Map<String, Object>> defaultServiceStatusConf,
            Map<String, List<Map<String, Object>>> defaultInitialQueriesConf
            ) {
            this.defaultEventPersistenceConf = defaultEventPersistenceConf;
            this.defaultServiceStatusConf = defaultServiceStatusConf;
            this.defaultInitialQueriesConf = defaultInitialQueriesConf;
    }
	
	public ServiceImpl (
			ServiceParameters serviceParameters,
			Map<String, Long> defaultEventPersistenceConf,
			Map<String, Map<String, Object>> defaultServiceStatusConf,
			Map<String, List<Map<String, Object>>> defaultInitialQueriesConf,
			Map<String, DataSource> dataSources,
			ServiceExecutorParameters serviceExecutorParameters
			) throws Exception {
			this.defaultEventPersistenceConf = defaultEventPersistenceConf;
			this.defaultServiceStatusConf = defaultServiceStatusConf;
			this.defaultInitialQueriesConf = defaultInitialQueriesConf;
            init(serviceParameters,serviceExecutorParameters);			
	}

    public void init(ServiceParameters serviceParameters, ServiceExecutorParameters serviceExecutorParameters) throws Exception {
            this.serviceParameters = serviceParameters;
            
                //start operation GetEvents
                {
                    ServiceStatus serviceStatus = new ServiceStatus();
                    Map<String, String> parametersTypes = new HashMap<String, String>();
                    
                    parametersTypes.put("cities", "String");

                    ServiceStatusDAO serviceStatusDAO = this.serviceParameters.getServiceStatusDAO();
                    
                    ServicePersistence servicePersistence = new GetEventsServicePersistence(serviceParameters.getMongoDB());
        
                try {
                    serviceStatus = serviceStatusDAO.load( "eu.trentorise.smartcampus.services.trento.events.TrentoEvents", "GetEvents");
                } catch (EntityNotFoundException e) {
                        String period = (String)getDefaultServiceStatusConf("GetEvents").get(PERIOD);
                        String periodOnDefault = (String)getDefaultServiceStatusConf("GetEvents").get(PERIOD_ON_DEFAULT);
                        String periodOnFailure = (String)getDefaultServiceStatusConf("GetEvents").get(PERIOD_ON_FAILURE);
                        long cacheValidityPeriod = (Long)getDefaultServiceStatusConf("GetEvents").get(CACHE_VALIDITY_PERIOD);
                        long validityPeriod = (Long)getDefaultServiceStatusConf("GetEvents").get(VALIDITY_PERIOD);
                        long delay = (Long)getDefaultServiceStatusConf("GetEvents").get(DELAY);
                        boolean automaticRefresh = (Boolean)getDefaultServiceStatusConf("GetEvents").get(AUTOMATIC_REFRESH);
                        boolean runnableAfterDelay = (Boolean)getDefaultServiceStatusConf("GetEvents").get(RUNNABLE_AFTER_DELAY);
                        boolean serviceBlocked = (Boolean)getDefaultServiceStatusConf("GetEvents").get(SERVICE_BLOCKED);
                        boolean dataflowInvokable = (Boolean)getDefaultServiceStatusConf("GetEvents").get(DATAFLOW_INVOKABLE);              
                        boolean storable = (Boolean)getDefaultServiceStatusConf("GetEvents").get(STORABLE);
                        
                        serviceStatus.setStorable(storable);
                        if (storable) {
	                        serviceStatus.setAutomaticRefresh(automaticRefresh); 
	                        if (automaticRefresh) {
	                            serviceStatus.setPeriod(period);
	                            serviceStatus.setPeriodOnDefault(periodOnDefault);
	                            serviceStatus.setPeriodOnFailure(periodOnFailure);
	                            serviceStatus.setRunnableAfterDelay(runnableAfterDelay);
	                        }
                        }

                        serviceStatus.setCacheValidityPeriod(cacheValidityPeriod);
                        serviceStatus.setValidityPeriod(validityPeriod);                            
                        serviceStatus.setDelay(delay); // Fixed
                        serviceStatus.setMethodName("GetEvents");
                        serviceStatus.setServiceId(SERVICE_ID);
                        serviceStatus.setServiceBlocked(serviceBlocked);
                        serviceStatus.setDataFlowInvokable(dataflowInvokable);
                        serviceStatus.setRemoteUrl(serviceExecutorParameters.getUrl());
                        serviceStatus.setRemote(serviceExecutorParameters.isRemote());
                        serviceStatusDAO.store(serviceStatus);
                        
                    }  
                    List<Map<String, Object>> queries = this.getDefaultInitialQueriesConf().get("GetEvents");
                    if(queries != null && ! queries.isEmpty()) {
                        java.util.Collection<Map<String,Object>> parameters = servicePersistence.getQueryParameters();
                        if (parameters == null || parameters.isEmpty()) {
                            for(Map<String, Object> query : queries) {
                                servicePersistence.storeQueryParameters(query);
                            }
                        }
                    }
                    
                    // end of persistence
                    ServiceDataFlow serviceDataFlow = new GetEventsDataFlow();
                    ServiceValidation serviceValidation = new GetEventsServiceValidation(serviceStatus.getServiceId(), serviceStatus.getMethodName(), serviceParameters.getPersistenceEngine());
                    // ServiceMonitoring serviceMonitoring = new GetEventsServiceMonitoring(serviceStatus.getServiceId(), serviceStatus.getMethodName(), serviceParameters.getPersistenceEngine());
                    
                    ServiceMethod serviceMethod =  new ServiceMethod("GetEvents", serviceDataFlow, serviceStatus, servicePersistence, serviceParameters, serviceValidation, null, parametersTypes);
                    serviceDataFlow.setServiceMethod(serviceMethod);
                    serviceMethods.put("GetEvents", serviceMethod);

                //end operation GetEvents
            }
    }

	public String getServiceId() {
		return SERVICE_ID;
	}
    public java.util.Set<String> getServiceMethodNames() {
        java.util.Set<String> set = new java.util.HashSet<String>();
        set.add("GetEvents");
        
        return set;
    }
	 
	public void start() throws ServiceException {
		for (String operation: serviceMethods.keySet()) {
			ServiceMethod serviceMethod = serviceMethods.get(operation);
			serviceMethod.start();
		}
	}
	
		
	
}