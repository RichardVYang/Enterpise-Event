package com.eef.eseservice;

import com.eef.ecehandler.CustomerEventHandler;
import com.eef.objectmodel.CustomerEvent;
import com.eef.util.CustomerEventValidation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CustomerEventHandlerTest {
  /*
  "sourceName": "Reservation",
"sourceType": "Java in Linux OS",
"eventType": "search",
"eventId": "abc123",
"correlationId": "13579aceg",
"category": "customer",
"subCategory": "client",
"eventData": "Event Description",
"eventDate": "2019-11-15T17:29:50.991+0000"
   */

  @Test
  public void validateEventTest() {
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

      boolean result = CustomerEventValidation.isEventValid(ce);
      System.out.println("Validattion result: " + result);
      Assert.assertTrue(result);
  }

    @Test
    public void customerEventTest() {
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

        new CustomerEventHandler().handle(ce);
    }


}
