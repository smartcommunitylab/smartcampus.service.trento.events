package eu.trentorise.smartcampus.services.trento.events.impl;

import it.sayservice.platform.core.common.exception.EntityNotFoundException;
import it.sayservice.platform.core.bus.common.exception.PersistenceException;
import it.sayservice.platform.core.bus.data.mongo.AbstractMongoPersistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.Message;
import com.mongodb.DB;

public class GetEventsServicePersistence extends AbstractMongoPersistence {

    public GetEventsServicePersistence(DB db) {
        super(db);
    }

    @Override
    protected String getServiceId() {
        return "eu.trentorise.smartcampus.services.trento.events.TrentoEvents";
    }

    @Override
    protected String getMethodName() {
        return "GetEvents";
    }

    @Override
    protected Builder<?> getProtoBuilder() {
        return eu.trentorise.smartcampus.services.trento.events.data.message.Events.Event .newBuilder();
    }

    @Override
    protected Class<?> getParamType(String param) {
        if (param.equals("cities")) return String .class;
        return null;
    }
    
}
