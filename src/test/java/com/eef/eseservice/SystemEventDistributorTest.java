package com.eef.eseservice;

import com.eef.objectmodel.SystemEvent;
import org.junit.Test;

import java.util.Date;

public class SystemEventDistributorTest {


    @Test
    public void jmsRouteTest() {

        SystemEvent se = new SystemEvent();
        se.setCategory("Error");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventType("Error"); // agent, or other third party
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setSystemType("online");
        se.setSystemName("PC");
        se.setEventDesc("Default event message");
        se.setEventDate(new Date());

        new SystemEventService().process(se);
    }


    @Test
    public void kafkaRouteTest() {

        SystemEvent se = new SystemEvent();
        se.setCategory("Error");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventType("Warning"); // agent, or other third party
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setSystemType("online");
        se.setSystemName("PC");
        se.setEventDesc("Default event message");
        se.setEventDate(new Date());

        new SystemEventService().process(se);
    }

    @Test
    public void smptRouteTest() {

        SystemEvent se = new SystemEvent();
        se.setCategory("Error");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventType("Info"); // agent, or other third party
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setSystemType("online");
        se.setSystemName("PC");
        se.setEventDesc("Default event message");
        se.setEventDate(new Date());

        new SystemEventService().process(se);
    }

    @Test
    public void smsRouteTest() {

        SystemEvent se = new SystemEvent();
        se.setCategory("Error");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventType("Something else"); // agent, or other third party
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setSystemType("online");
        se.setSystemName("PC");
        se.setEventDesc("Default event message");
        se.setEventDate(new Date());

        new SystemEventService().process(se);
    }

    @Test
    public void slackRouteTest() {

        SystemEvent se = new SystemEvent();
        se.setCategory("Error");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventType("Something else"); // agent, or other third party
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setSystemType("online");
        se.setSystemName("PC");
        se.setEventDesc("Default event message");
        se.setEventDate(new Date());

        new SystemEventService().process(se);
    }





}
