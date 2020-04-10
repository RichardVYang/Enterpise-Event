package com.eef.eseservice;

import com.eef.Constants;
import com.eef.esehandler.SystemEventHandler;
import com.eef.objectmodel.SystemEvent;
import com.eef.util.SystemEventValidation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/*
    private String systemName; // name of system where original event starts
    private String subSystemName;
    private String systemType; // type of the system
    private String subSystemType;
    private String eventType;  // error, warning, etc
    private String eventId;
    private String correlationId;
    private String category;
    private String subCategory;
    private String eventDesc;
    private Date eventDate;

 */

public class SystemEventHandlerTest {

    @Test
    public void systemEventValidateTest() {
        SystemEvent se = new SystemEvent();
        se.setSystemName("FORT");
        se.setSubSystemName("Alert");
        se.setSystemType("Java Component");
        se.setSubSystemType("Java Component");
        se.setEventType("Error");
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setCategory("Production Issue");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventDesc("Severe production issue has occurred");
        se.setEventDate(new Date());

        boolean result = SystemEventValidation.isPresented(se);
        Assert.assertTrue(result);
    }

    @Test
    public void systemAlertEventTest() {
        SystemEvent se = new SystemEvent();
        se.setSystemName("FORT System");
        se.setSubSystemName("Alert Subsystem");
        se.setSystemType("Java Component");
        se.setSubSystemType("Java Component");
        se.setEventType("Alert");
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setCategory(Constants.ALERT);
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventDesc("Severe production issue has occurred");
        se.setEventDate(new Date());

        new SystemEventHandler().handle(se);
    }

    @Test
    public void systemNotifyEventTest() {
        SystemEvent se = new SystemEvent();
        se.setSystemName("FORT System");
        se.setSubSystemName("Messaging Subsystem");
        se.setSystemType("Java Component");
        se.setSubSystemType("Java Component");
        se.setEventType("Notify");
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setCategory(Constants.NOTIFICATION);
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventDesc("Severe production issue has occurred");
        se.setEventDate(new Date());

        new SystemEventHandler().handle(se);
    }

    @Test
    public void systemErrorEventTest() {
        SystemEvent se = new SystemEvent();
        se.setSystemName("FORT System");
        se.setSubSystemName("Alert Subsystem");
        se.setSystemType("Java Component");
        se.setSubSystemType("Java Component");
        se.setEventType("System Health");
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setCategory(Constants.ERROR); // Error, Warning, Debug, Info, Trace are persist in database only.  Alert an Notification events are delegated.
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventDesc("Severe production issue has occurred");
        se.setEventDate(new Date());

        new SystemEventHandler().handle(se);
    }
/*
    @Test
    public void jMSMessageTest() {
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
    public void kAfkaMessageTest() {
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
    public void sMTPMessageTest() {
        SystemEvent se = new SystemEvent();
        se.setCategory("Warning");
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
    public void sMSMessageTest() {
        SystemEvent se = new SystemEvent();
        se.setCategory("Info");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventType("Trace"); // agent, or other third party
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setSystemType("online");
        se.setSystemName("PC");
        se.setEventDesc("Default event message");
        se.setEventDate(new Date());

        new SystemEventService().process(se);
    }

    @Test
    public void slackMessageTest() {
        SystemEvent se = new SystemEvent();
        se.setCategory("Error");
        se.setSubCategory("SystemA.ComponentB.ClassC.MethodC");
        se.setEventType("Default"); // agent, or other third party
        se.setEventId("ABC123");
        se.setCorrelationId("12345abcde");
        se.setSystemType("online");
        se.setSystemName("PC");
        se.setEventDesc("Default event message");
        se.setEventDate(new Date());

        new SystemEventService().process(se);
    }
*/

}
