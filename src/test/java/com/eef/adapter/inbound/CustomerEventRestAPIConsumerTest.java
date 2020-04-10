package com.eef.adapter.inbound;

import com.eef.objectmodel.CustomerEvent;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.Date;

public class CustomerEventRestAPIConsumerTest {

    @Test
    public void customerEventRESTAPIConsumerTest() {

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

        String result = new CustomerEventRESTAPIConsumer().postCustomerEvent(ce);
        Assert.assertEquals("Success", "Success");

    }
}
