package eu.trentorise.smartcampus.services.trento.events.data.message;

import java.util.List;
import java.util.LinkedList;

import it.sayservice.xss.api.XSSDataException;
import it.sayservice.xss.api.data.XSSData;
import it.sayservice.xss.api.data.DOMData;

import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;

import it.sayservice.platform.core.message.ProtoBean;
/**
*
* Generated ProtoBean class: DO NOT EDIT!
*
*/
public class EventsProtoBean {
   public static class TCEventPageProtoBean implements ProtoBean {
          private Long pagenumber;
    public Long getPagenumber() {
      return pagenumber;
    }
    public void setPagenumber(Long pagenumber) {
      this.pagenumber = pagenumber;
    }
    
          private Long totalpages;
    public Long getTotalpages() {
      return totalpages;
    }
    public void setTotalpages(Long totalpages) {
      this.totalpages = totalpages;
    }
    
          private List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean> eventsList;
    public List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean> getEventsList() {
      return eventsList;
    }
    public void setEventsList(List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean> eventsList) {
      this.eventsList = eventsList;
    }
    public eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean getEvents(int i) {
      return eventsList .get(i);
    }
    public int getEventsCount() {
      return eventsList .size();
    }
    
    
    public TCEventPageProtoBean() {
    	super();
    }
    
    public TCEventPageProtoBean(eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage reference) {
      super();
                        setPagenumber(reference.getPagenumber());
                                    setTotalpages(reference.getTotalpages());
                                    if (reference.getEventsList()!=null) {
        eventsList = new LinkedList<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean>();
        for (eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr item : reference.getEventsList()) {
          getEventsList().add(new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean(item));
        }
      }
                      }  

    public TCEventPageProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("pagenumber") != null && !data.get("pagenumber").isEmpty()) {
            if (data.get("pagenumber").size()>1) throw new XSSDataException("Incorrect data cardinality for field pagenumber: expected single value.");
            
            Object item = data.get("pagenumber").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field pagenumber: expected DOMData");
                                  setPagenumber(convertToLong(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("totalpages") != null && !data.get("totalpages").isEmpty()) {
            if (data.get("totalpages").size()>1) throw new XSSDataException("Incorrect data cardinality for field totalpages: expected single value.");
            
            Object item = data.get("totalpages").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field totalpages: expected DOMData");
                                  setTotalpages(convertToLong(((DOMData)item).getStringValue()));
                                      }
                                eventsList = new LinkedList<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean>();
          if (data.get("events")!=null) {
            for (Object item : data.get("events")) {
                              if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field events: expected XSSData");
                getEventsList().add(new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean((XSSData)item));
                          }
          }
                  }  

    
    public eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage buildMessage() {
      eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage .Builder builder = eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventPage .newBuilder();
                        if (getPagenumber() != null) {
      	builder.setPagenumber(getPagenumber());
      }
                                    if (getTotalpages() != null) {
      	builder.setTotalpages(getTotalpages());
      }
                              if (getEventsList()!=null) {
        for (eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.TCEventDescrProtoBean item : getEventsList()) {
                    builder. addEvents(item.buildMessage());
                  }
      }
                  return builder.buildPartial();
    }
    
    
  }
  public static class TCEventDescrProtoBean implements ProtoBean {
          private String startDate;
    public String getStartDate() {
      return startDate;
    }
    public void setStartDate(String startDate) {
      this.startDate = startDate;
    }
    
          private String category;
    public String getCategory() {
      return category;
    }
    public void setCategory(String category) {
      this.category = category;
    }
    
          private String title;
    public String getTitle() {
      return title;
    }
    public void setTitle(String title) {
      this.title = title;
    }
    
          private String link;
    public String getLink() {
      return link;
    }
    public void setLink(String link) {
      this.link = link;
    }
    
          private String city;
    public String getCity() {
      return city;
    }
    public void setCity(String city) {
      this.city = city;
    }
    
    
    public TCEventDescrProtoBean() {
    	super();
    }
    
    public TCEventDescrProtoBean(eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr reference) {
      super();
                        setStartDate(reference.getStartDate());
                                    setCategory(reference.getCategory());
                                    setTitle(reference.getTitle());
                                    setLink(reference.getLink());
                                    setCity(reference.getCity());
                      }  

    public TCEventDescrProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("startDate") != null && !data.get("startDate").isEmpty()) {
            if (data.get("startDate").size()>1) throw new XSSDataException("Incorrect data cardinality for field startDate: expected single value.");
            
            Object item = data.get("startDate").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field startDate: expected DOMData");
                                  setStartDate(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("category") != null && !data.get("category").isEmpty()) {
            if (data.get("category").size()>1) throw new XSSDataException("Incorrect data cardinality for field category: expected single value.");
            
            Object item = data.get("category").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field category: expected DOMData");
                                  setCategory(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("title") != null && !data.get("title").isEmpty()) {
            if (data.get("title").size()>1) throw new XSSDataException("Incorrect data cardinality for field title: expected single value.");
            
            Object item = data.get("title").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field title: expected DOMData");
                                  setTitle(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("link") != null && !data.get("link").isEmpty()) {
            if (data.get("link").size()>1) throw new XSSDataException("Incorrect data cardinality for field link: expected single value.");
            
            Object item = data.get("link").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field link: expected DOMData");
                                  setLink(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("city") != null && !data.get("city").isEmpty()) {
            if (data.get("city").size()>1) throw new XSSDataException("Incorrect data cardinality for field city: expected single value.");
            
            Object item = data.get("city").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field city: expected DOMData");
                                  setCity(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr buildMessage() {
      eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr .Builder builder = eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEventDescr .newBuilder();
                        if (getStartDate() != null) {
      	builder.setStartDate(getStartDate());
      }
                                    if (getCategory() != null) {
      	builder.setCategory(getCategory());
      }
                                    if (getTitle() != null) {
      	builder.setTitle(getTitle());
      }
                                    if (getLink() != null) {
      	builder.setLink(getLink());
      }
                                    if (getCity() != null) {
      	builder.setCity(getCity());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class TCEventProtoBean implements ProtoBean {
          private String title;
    public String getTitle() {
      return title;
    }
    public void setTitle(String title) {
      this.title = title;
    }
    
          private List<String> dateFromList;
    public List<String> getDateFromList() {
      return dateFromList;
    }
    public void setDateFromList(List<String> dateFromList) {
      this.dateFromList = dateFromList;
    }
    public String getDateFrom(int i) {
      return dateFromList .get(i);
    }
    public int getDateFromCount() {
      return dateFromList .size();
    }
    
          private List<String> dateToList;
    public List<String> getDateToList() {
      return dateToList;
    }
    public void setDateToList(List<String> dateToList) {
      this.dateToList = dateToList;
    }
    public String getDateTo(int i) {
      return dateToList .get(i);
    }
    public int getDateToCount() {
      return dateToList .size();
    }
    
          private String place;
    public String getPlace() {
      return place;
    }
    public void setPlace(String place) {
      this.place = place;
    }
    
          private String city;
    public String getCity() {
      return city;
    }
    public void setCity(String city) {
      this.city = city;
    }
    
          private String time;
    public String getTime() {
      return time;
    }
    public void setTime(String time) {
      this.time = time;
    }
    
          private String address;
    public String getAddress() {
      return address;
    }
    public void setAddress(String address) {
      this.address = address;
    }
    
          private String category;
    public String getCategory() {
      return category;
    }
    public void setCategory(String category) {
      this.category = category;
    }
    
          private String details;
    public String getDetails() {
      return details;
    }
    public void setDetails(String details) {
      this.details = details;
    }
    
          private String tel;
    public String getTel() {
      return tel;
    }
    public void setTel(String tel) {
      this.tel = tel;
    }
    
          private String fax;
    public String getFax() {
      return fax;
    }
    public void setFax(String fax) {
      this.fax = fax;
    }
    
          private String mail;
    public String getMail() {
      return mail;
    }
    public void setMail(String mail) {
      this.mail = mail;
    }
    
          private String www;
    public String getWww() {
      return www;
    }
    public void setWww(String www) {
      this.www = www;
    }
    
          private String price;
    public String getPrice() {
      return price;
    }
    public void setPrice(String price) {
      this.price = price;
    }
    
          private String organization;
    public String getOrganization() {
      return organization;
    }
    public void setOrganization(String organization) {
      this.organization = organization;
    }
    
          private String notes;
    public String getNotes() {
      return notes;
    }
    public void setNotes(String notes) {
      this.notes = notes;
    }
    
          private it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean poi;
    public it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean getPoi() {
      return poi;
    }
    public void setPoi(it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean poi) {
      this.poi = poi;
    }
    
          private String eventDate;
    public String getEventDate() {
      return eventDate;
    }
    public void setEventDate(String eventDate) {
      this.eventDate = eventDate;
    }
    
    
    public TCEventProtoBean() {
    	super();
    }
    
    public TCEventProtoBean(eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent reference) {
      super();
                        setTitle(reference.getTitle());
                                    setDateFromList(reference.getDateFromList());
                                    setDateToList(reference.getDateToList());
                                    setPlace(reference.getPlace());
                                    setCity(reference.getCity());
                                    setTime(reference.getTime());
                                    setAddress(reference.getAddress());
                                    setCategory(reference.getCategory());
                                    setDetails(reference.getDetails());
                                    setTel(reference.getTel());
                                    setFax(reference.getFax());
                                    setMail(reference.getMail());
                                    setWww(reference.getWww());
                                    setPrice(reference.getPrice());
                                    setOrganization(reference.getOrganization());
                                    setNotes(reference.getNotes());
                                    setPoi(new it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean(reference.getPoi()));
                                    setEventDate(reference.getEventDate());
                      }  

    public TCEventProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("title") != null && !data.get("title").isEmpty()) {
            if (data.get("title").size()>1) throw new XSSDataException("Incorrect data cardinality for field title: expected single value.");
            
            Object item = data.get("title").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field title: expected DOMData");
                                  setTitle(convertToString(((DOMData)item).getStringValue()));
                                      }
                                dateFromList = new LinkedList<String>();
          if (data.get("dateFrom")!=null) {
            for (Object item : data.get("dateFrom")) {
                              if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field dateFrom: expected DOMData");
                                  getDateFromList().add(convertToString(((DOMData)item).getStringValue()));
                                          }
          }
                                dateToList = new LinkedList<String>();
          if (data.get("dateTo")!=null) {
            for (Object item : data.get("dateTo")) {
                              if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field dateTo: expected DOMData");
                                  getDateToList().add(convertToString(((DOMData)item).getStringValue()));
                                          }
          }
                                if (data.get("place") != null && !data.get("place").isEmpty()) {
            if (data.get("place").size()>1) throw new XSSDataException("Incorrect data cardinality for field place: expected single value.");
            
            Object item = data.get("place").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field place: expected DOMData");
                                  setPlace(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("city") != null && !data.get("city").isEmpty()) {
            if (data.get("city").size()>1) throw new XSSDataException("Incorrect data cardinality for field city: expected single value.");
            
            Object item = data.get("city").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field city: expected DOMData");
                                  setCity(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("time") != null && !data.get("time").isEmpty()) {
            if (data.get("time").size()>1) throw new XSSDataException("Incorrect data cardinality for field time: expected single value.");
            
            Object item = data.get("time").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field time: expected DOMData");
                                  setTime(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("address") != null && !data.get("address").isEmpty()) {
            if (data.get("address").size()>1) throw new XSSDataException("Incorrect data cardinality for field address: expected single value.");
            
            Object item = data.get("address").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field address: expected DOMData");
                                  setAddress(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("category") != null && !data.get("category").isEmpty()) {
            if (data.get("category").size()>1) throw new XSSDataException("Incorrect data cardinality for field category: expected single value.");
            
            Object item = data.get("category").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field category: expected DOMData");
                                  setCategory(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("details") != null && !data.get("details").isEmpty()) {
            if (data.get("details").size()>1) throw new XSSDataException("Incorrect data cardinality for field details: expected single value.");
            
            Object item = data.get("details").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field details: expected DOMData");
                                  setDetails(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("tel") != null && !data.get("tel").isEmpty()) {
            if (data.get("tel").size()>1) throw new XSSDataException("Incorrect data cardinality for field tel: expected single value.");
            
            Object item = data.get("tel").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field tel: expected DOMData");
                                  setTel(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("fax") != null && !data.get("fax").isEmpty()) {
            if (data.get("fax").size()>1) throw new XSSDataException("Incorrect data cardinality for field fax: expected single value.");
            
            Object item = data.get("fax").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field fax: expected DOMData");
                                  setFax(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("mail") != null && !data.get("mail").isEmpty()) {
            if (data.get("mail").size()>1) throw new XSSDataException("Incorrect data cardinality for field mail: expected single value.");
            
            Object item = data.get("mail").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field mail: expected DOMData");
                                  setMail(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("www") != null && !data.get("www").isEmpty()) {
            if (data.get("www").size()>1) throw new XSSDataException("Incorrect data cardinality for field www: expected single value.");
            
            Object item = data.get("www").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field www: expected DOMData");
                                  setWww(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("price") != null && !data.get("price").isEmpty()) {
            if (data.get("price").size()>1) throw new XSSDataException("Incorrect data cardinality for field price: expected single value.");
            
            Object item = data.get("price").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field price: expected DOMData");
                                  setPrice(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("organization") != null && !data.get("organization").isEmpty()) {
            if (data.get("organization").size()>1) throw new XSSDataException("Incorrect data cardinality for field organization: expected single value.");
            
            Object item = data.get("organization").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field organization: expected DOMData");
                                  setOrganization(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("notes") != null && !data.get("notes").isEmpty()) {
            if (data.get("notes").size()>1) throw new XSSDataException("Incorrect data cardinality for field notes: expected single value.");
            
            Object item = data.get("notes").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field notes: expected DOMData");
                                  setNotes(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("poi") != null && !data.get("poi").isEmpty()) {
            if (data.get("poi").size()>1) throw new XSSDataException("Incorrect data cardinality for field poi: expected single value.");
            
            Object item = data.get("poi").get(0); 
                          if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field poi: expected XSSData");
              setPoi(new it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean((XSSData)item));
                      }
                                if (data.get("eventDate") != null && !data.get("eventDate").isEmpty()) {
            if (data.get("eventDate").size()>1) throw new XSSDataException("Incorrect data cardinality for field eventDate: expected single value.");
            
            Object item = data.get("eventDate").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field eventDate: expected DOMData");
                                  setEventDate(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent buildMessage() {
      eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent .Builder builder = eu.trentorise.smartcampus.services.trento.events.data.message.Events.TCEvent .newBuilder();
                        if (getTitle() != null) {
      	builder.setTitle(getTitle());
      }
                              if (getDateFromList()!=null) {
        for (String item : getDateFromList()) {
                    builder. addDateFrom(item);
                  }
      }
                        if (getDateToList()!=null) {
        for (String item : getDateToList()) {
                    builder. addDateTo(item);
                  }
      }
                              if (getPlace() != null) {
      	builder.setPlace(getPlace());
      }
                                    if (getCity() != null) {
      	builder.setCity(getCity());
      }
                                    if (getTime() != null) {
      	builder.setTime(getTime());
      }
                                    if (getAddress() != null) {
      	builder.setAddress(getAddress());
      }
                                    if (getCategory() != null) {
      	builder.setCategory(getCategory());
      }
                                    if (getDetails() != null) {
      	builder.setDetails(getDetails());
      }
                                    if (getTel() != null) {
      	builder.setTel(getTel());
      }
                                    if (getFax() != null) {
      	builder.setFax(getFax());
      }
                                    if (getMail() != null) {
      	builder.setMail(getMail());
      }
                                    if (getWww() != null) {
      	builder.setWww(getWww());
      }
                                    if (getPrice() != null) {
      	builder.setPrice(getPrice());
      }
                                    if (getOrganization() != null) {
      	builder.setOrganization(getOrganization());
      }
                                    if (getNotes() != null) {
      	builder.setNotes(getNotes());
      }
                                    if (getPoi() != null) {
      	builder.setPoi(getPoi() .buildMessage());
      }
                                    if (getEventDate() != null) {
      	builder.setEventDate(getEventDate());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class EventDescrListProtoBean implements ProtoBean {
          private List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean> eventList;
    public List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean> getEventList() {
      return eventList;
    }
    public void setEventList(List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean> eventList) {
      this.eventList = eventList;
    }
    public eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean getEvent(int i) {
      return eventList .get(i);
    }
    public int getEventCount() {
      return eventList .size();
    }
    
          private List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean> manifestationList;
    public List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean> getManifestationList() {
      return manifestationList;
    }
    public void setManifestationList(List<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean> manifestationList) {
      this.manifestationList = manifestationList;
    }
    public eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean getManifestation(int i) {
      return manifestationList .get(i);
    }
    public int getManifestationCount() {
      return manifestationList .size();
    }
    
    
    public EventDescrListProtoBean() {
    	super();
    }
    
    public EventDescrListProtoBean(eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescrList reference) {
      super();
                        if (reference.getEventList()!=null) {
        eventList = new LinkedList<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean>();
        for (eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescr item : reference.getEventList()) {
          getEventList().add(new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean(item));
        }
      }
                                    if (reference.getManifestationList()!=null) {
        manifestationList = new LinkedList<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean>();
        for (eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescr item : reference.getManifestationList()) {
          getManifestationList().add(new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean(item));
        }
      }
                      }  

    public EventDescrListProtoBean(XSSData data) throws XSSDataException {
      super();
                        eventList = new LinkedList<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean>();
          if (data.get("event")!=null) {
            for (Object item : data.get("event")) {
                              if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field event: expected XSSData");
                getEventList().add(new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean((XSSData)item));
                          }
          }
                                manifestationList = new LinkedList<eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean>();
          if (data.get("manifestation")!=null) {
            for (Object item : data.get("manifestation")) {
                              if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field manifestation: expected XSSData");
                getManifestationList().add(new eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean((XSSData)item));
                          }
          }
                  }  

    
    public eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescrList buildMessage() {
      eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescrList .Builder builder = eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescrList .newBuilder();
                  if (getEventList()!=null) {
        for (eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean item : getEventList()) {
                    builder. addEvent(item.buildMessage());
                  }
      }
                        if (getManifestationList()!=null) {
        for (eu.trentorise.smartcampus.services.trento.events.data.message.EventsProtoBean.EventDescrProtoBean item : getManifestationList()) {
                    builder. addManifestation(item.buildMessage());
                  }
      }
                  return builder.buildPartial();
    }
    
    
  }
  public static class EventDescrProtoBean implements ProtoBean {
          private String href;
    public String getHref() {
      return href;
    }
    public void setHref(String href) {
      this.href = href;
    }
    
          private String keyword;
    public String getKeyword() {
      return keyword;
    }
    public void setKeyword(String keyword) {
      this.keyword = keyword;
    }
    
          private String shortDesc;
    public String getShortDesc() {
      return shortDesc;
    }
    public void setShortDesc(String shortDesc) {
      this.shortDesc = shortDesc;
    }
    
    
    public EventDescrProtoBean() {
    	super();
    }
    
    public EventDescrProtoBean(eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescr reference) {
      super();
                        setHref(reference.getHref());
                                    setKeyword(reference.getKeyword());
                                    setShortDesc(reference.getShortDesc());
                      }  

    public EventDescrProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("href") != null && !data.get("href").isEmpty()) {
            if (data.get("href").size()>1) throw new XSSDataException("Incorrect data cardinality for field href: expected single value.");
            
            Object item = data.get("href").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field href: expected DOMData");
                                  setHref(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("keyword") != null && !data.get("keyword").isEmpty()) {
            if (data.get("keyword").size()>1) throw new XSSDataException("Incorrect data cardinality for field keyword: expected single value.");
            
            Object item = data.get("keyword").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field keyword: expected DOMData");
                                  setKeyword(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("shortDesc") != null && !data.get("shortDesc").isEmpty()) {
            if (data.get("shortDesc").size()>1) throw new XSSDataException("Incorrect data cardinality for field shortDesc: expected single value.");
            
            Object item = data.get("shortDesc").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field shortDesc: expected DOMData");
                                  setShortDesc(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescr buildMessage() {
      eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescr .Builder builder = eu.trentorise.smartcampus.services.trento.events.data.message.Events.EventDescr .newBuilder();
                        if (getHref() != null) {
      	builder.setHref(getHref());
      }
                                    if (getKeyword() != null) {
      	builder.setKeyword(getKeyword());
      }
                                    if (getShortDesc() != null) {
      	builder.setShortDesc(getShortDesc());
      }
                        return builder.buildPartial();
    }
    
    
  }
  public static class EventProtoBean implements ProtoBean {
          private String id;
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    
          private String title;
    public String getTitle() {
      return title;
    }
    public void setTitle(String title) {
      this.title = title;
    }
    
          private String date;
    public String getDate() {
      return date;
    }
    public void setDate(String date) {
      this.date = date;
    }
    
          private String place;
    public String getPlace() {
      return place;
    }
    public void setPlace(String place) {
      this.place = place;
    }
    
          private String time;
    public String getTime() {
      return time;
    }
    public void setTime(String time) {
      this.time = time;
    }
    
          private String content;
    public String getContent() {
      return content;
    }
    public void setContent(String content) {
      this.content = content;
    }
    
          private String lastUpdate;
    public String getLastUpdate() {
      return lastUpdate;
    }
    public void setLastUpdate(String lastUpdate) {
      this.lastUpdate = lastUpdate;
    }
    
          private String img;
    public String getImg() {
      return img;
    }
    public void setImg(String img) {
      this.img = img;
    }
    
          private String district;
    public String getDistrict() {
      return district;
    }
    public void setDistrict(String district) {
      this.district = district;
    }
    
          private String cost;
    public String getCost() {
      return cost;
    }
    public void setCost(String cost) {
      this.cost = cost;
    }
    
          private String manifestation;
    public String getManifestation() {
      return manifestation;
    }
    public void setManifestation(String manifestation) {
      this.manifestation = manifestation;
    }
    
          private it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean poi;
    public it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean getPoi() {
      return poi;
    }
    public void setPoi(it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean poi) {
      this.poi = poi;
    }
    
          private String shortDesc;
    public String getShortDesc() {
      return shortDesc;
    }
    public void setShortDesc(String shortDesc) {
      this.shortDesc = shortDesc;
    }
    
          private String keyword;
    public String getKeyword() {
      return keyword;
    }
    public void setKeyword(String keyword) {
      this.keyword = keyword;
    }
    
    
    public EventProtoBean() {
    	super();
    }
    
    public EventProtoBean(eu.trentorise.smartcampus.services.trento.events.data.message.Events.Event reference) {
      super();
                        setId(reference.getId());
                                    setTitle(reference.getTitle());
                                    setDate(reference.getDate());
                                    setPlace(reference.getPlace());
                                    setTime(reference.getTime());
                                    setContent(reference.getContent());
                                    setLastUpdate(reference.getLastUpdate());
                                    setImg(reference.getImg());
                                    setDistrict(reference.getDistrict());
                                    setCost(reference.getCost());
                                    setManifestation(reference.getManifestation());
                                    setPoi(new it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean(reference.getPoi()));
                                    setShortDesc(reference.getShortDesc());
                                    setKeyword(reference.getKeyword());
                      }  

    public EventProtoBean(XSSData data) throws XSSDataException {
      super();
                        if (data.get("id") != null && !data.get("id").isEmpty()) {
            if (data.get("id").size()>1) throw new XSSDataException("Incorrect data cardinality for field id: expected single value.");
            
            Object item = data.get("id").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field id: expected DOMData");
                                  setId(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("title") != null && !data.get("title").isEmpty()) {
            if (data.get("title").size()>1) throw new XSSDataException("Incorrect data cardinality for field title: expected single value.");
            
            Object item = data.get("title").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field title: expected DOMData");
                                  setTitle(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("date") != null && !data.get("date").isEmpty()) {
            if (data.get("date").size()>1) throw new XSSDataException("Incorrect data cardinality for field date: expected single value.");
            
            Object item = data.get("date").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field date: expected DOMData");
                                  setDate(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("place") != null && !data.get("place").isEmpty()) {
            if (data.get("place").size()>1) throw new XSSDataException("Incorrect data cardinality for field place: expected single value.");
            
            Object item = data.get("place").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field place: expected DOMData");
                                  setPlace(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("time") != null && !data.get("time").isEmpty()) {
            if (data.get("time").size()>1) throw new XSSDataException("Incorrect data cardinality for field time: expected single value.");
            
            Object item = data.get("time").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field time: expected DOMData");
                                  setTime(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("content") != null && !data.get("content").isEmpty()) {
            if (data.get("content").size()>1) throw new XSSDataException("Incorrect data cardinality for field content: expected single value.");
            
            Object item = data.get("content").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field content: expected DOMData");
                                  setContent(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("lastUpdate") != null && !data.get("lastUpdate").isEmpty()) {
            if (data.get("lastUpdate").size()>1) throw new XSSDataException("Incorrect data cardinality for field lastUpdate: expected single value.");
            
            Object item = data.get("lastUpdate").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field lastUpdate: expected DOMData");
                                  setLastUpdate(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("img") != null && !data.get("img").isEmpty()) {
            if (data.get("img").size()>1) throw new XSSDataException("Incorrect data cardinality for field img: expected single value.");
            
            Object item = data.get("img").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field img: expected DOMData");
                                  setImg(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("district") != null && !data.get("district").isEmpty()) {
            if (data.get("district").size()>1) throw new XSSDataException("Incorrect data cardinality for field district: expected single value.");
            
            Object item = data.get("district").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field district: expected DOMData");
                                  setDistrict(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("cost") != null && !data.get("cost").isEmpty()) {
            if (data.get("cost").size()>1) throw new XSSDataException("Incorrect data cardinality for field cost: expected single value.");
            
            Object item = data.get("cost").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field cost: expected DOMData");
                                  setCost(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("manifestation") != null && !data.get("manifestation").isEmpty()) {
            if (data.get("manifestation").size()>1) throw new XSSDataException("Incorrect data cardinality for field manifestation: expected single value.");
            
            Object item = data.get("manifestation").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field manifestation: expected DOMData");
                                  setManifestation(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("poi") != null && !data.get("poi").isEmpty()) {
            if (data.get("poi").size()>1) throw new XSSDataException("Incorrect data cardinality for field poi: expected single value.");
            
            Object item = data.get("poi").get(0); 
                          if (!(item instanceof XSSData)) throw new XSSDataException("Incorrect data type for field poi: expected XSSData");
              setPoi(new it.sayservice.platform.core.message.CoreProtoBean.POIProtoBean((XSSData)item));
                      }
                                if (data.get("shortDesc") != null && !data.get("shortDesc").isEmpty()) {
            if (data.get("shortDesc").size()>1) throw new XSSDataException("Incorrect data cardinality for field shortDesc: expected single value.");
            
            Object item = data.get("shortDesc").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field shortDesc: expected DOMData");
                                  setShortDesc(convertToString(((DOMData)item).getStringValue()));
                                      }
                                if (data.get("keyword") != null && !data.get("keyword").isEmpty()) {
            if (data.get("keyword").size()>1) throw new XSSDataException("Incorrect data cardinality for field keyword: expected single value.");
            
            Object item = data.get("keyword").get(0); 
                            if (!(item instanceof DOMData)) throw new XSSDataException("Incorrect data type for field keyword: expected DOMData");
                                  setKeyword(convertToString(((DOMData)item).getStringValue()));
                                      }
                  }  

    
    public eu.trentorise.smartcampus.services.trento.events.data.message.Events.Event buildMessage() {
      eu.trentorise.smartcampus.services.trento.events.data.message.Events.Event .Builder builder = eu.trentorise.smartcampus.services.trento.events.data.message.Events.Event .newBuilder();
                        if (getId() != null) {
      	builder.setId(getId());
      }
                                    if (getTitle() != null) {
      	builder.setTitle(getTitle());
      }
                                    if (getDate() != null) {
      	builder.setDate(getDate());
      }
                                    if (getPlace() != null) {
      	builder.setPlace(getPlace());
      }
                                    if (getTime() != null) {
      	builder.setTime(getTime());
      }
                                    if (getContent() != null) {
      	builder.setContent(getContent());
      }
                                    if (getLastUpdate() != null) {
      	builder.setLastUpdate(getLastUpdate());
      }
                                    if (getImg() != null) {
      	builder.setImg(getImg());
      }
                                    if (getDistrict() != null) {
      	builder.setDistrict(getDistrict());
      }
                                    if (getCost() != null) {
      	builder.setCost(getCost());
      }
                                    if (getManifestation() != null) {
      	builder.setManifestation(getManifestation());
      }
                                    if (getPoi() != null) {
      	builder.setPoi(getPoi() .buildMessage());
      }
                                    if (getShortDesc() != null) {
      	builder.setShortDesc(getShortDesc());
      }
                                    if (getKeyword() != null) {
      	builder.setKeyword(getKeyword());
      }
                        return builder.buildPartial();
    }
    
    
  }

 
  protected static double convertToDouble(String value) {
    return Double.parseDouble(value);
  }
  
  protected static float convertToFloat(String value) {
    return Float.parseFloat(value);
  }

  protected static boolean convertToBoolean(String value) {
    return Boolean.parseBoolean(value);
  }

  protected static String convertToString(String value) {
    return value;
  }

  protected static int convertToInteger(String value) {
    return Integer.parseInt(value);
  }

  protected static long convertToLong(String value) {
    return Long.parseLong(value);
  }

  protected static ByteString convertToByteString(String value) {
    try {
      return ByteString.copyFrom(value.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      return ByteString.copyFrom(value.getBytes());
    }
  }
 
}
