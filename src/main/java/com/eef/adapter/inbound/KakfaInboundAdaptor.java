package com.eef.adapter.inbound;

import com.eef.Constants;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class KakfaInboundAdaptor implements InboundAdaptor<SystemEvent>{
    private static final Logger log = LoggerFactory.getLogger(KakfaInboundAdaptor.class);

    @Override
    public SystemEvent receiveEvent() {

        //TODO pull event from topic, validate, and construct object model and delegate to RESTful API
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

        return se;

    }

    public void send(SystemEvent event) {
        String result = new SystemEventRESTAPIConsumer().postCustomerEvent(event);
    }
}
