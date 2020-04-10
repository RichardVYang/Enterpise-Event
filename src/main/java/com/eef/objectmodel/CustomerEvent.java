package com.eef.objectmodel;

import java.util.Date;

/*
 Postman
 POST: http://localhost:8080/ece/customerevent/
 Body raw JSON:

 {
"sourceName": "Reservation",
"sourceType": "Java in Linus OS",
"eventType": "search",
"eventId": "abc123",
"correlationId": "13579aceg",
"category": "customer",
"subCategory": "client",
"eventDesc": "Event Description",
"eventDate": "2019-11-15T17:29:50.991+0000"
}
 */

public class CustomerEvent {
    // TODO - fine-tune attributes

    private String sourceName;  // name of the device
    private String sourceType; // type of the device
    private String eventType;  // event type
    private String eventId;     // ID of the event
    private String correlationId;   // Correlation ID of this event with other event
    private String category;        // event category
    private String subCategory;     // sub category of event
    private String eventDesc;    // event contains content of message
    private Date eventDate;  // the date and time the event is being captured

    private String payload;


    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }


    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

}
