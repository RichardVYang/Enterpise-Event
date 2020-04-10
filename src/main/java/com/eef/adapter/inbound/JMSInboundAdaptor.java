package com.eef.adapter.inbound;

import com.eef.objectmodel.CustomerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JMSInboundAdaptor implements InboundAdaptor<CustomerEvent> {
    private static final Logger log = LoggerFactory.getLogger(JMSInboundAdaptor.class);

    @Override
    public CustomerEvent receiveEvent() {

        //TODO pull event from queue, validate, and construct object model and delegate to RESTful API
        CustomerEvent ce = new CustomerEvent();
        ce.setCategory("customer");
        ce.setSubCategory("client");
        ce.setEventType("search");
        ce.setEventId("ABC123");
        ce.setCorrelationId("12345abcde");
        ce.setSourceType("Java in Linux OS");
        ce.setSourceName("Reservation");
        ce.setEventDesc("customer search flight from Atlanta airport to Chicago airport on 12/15/2019");
        ce.setEventDate(new Date());
        return ce;


    }

    public void send(CustomerEvent event) {
        String result = new CustomerEventRESTAPIConsumer().postCustomerEvent(event);
    }
}
