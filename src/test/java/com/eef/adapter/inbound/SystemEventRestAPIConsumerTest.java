package com.eef.adapter.inbound;

import com.eef.Constants;
import com.eef.objectmodel.CustomerEvent;
import com.eef.objectmodel.SystemEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SystemEventRestAPIConsumerTest {

    @Test
    public void systemEventRESTAPIConsumerTest() {

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

        String result = new SystemEventRESTAPIConsumer().postCustomerEvent(se);
        Assert.assertEquals("Success", "Success");

    }

}
