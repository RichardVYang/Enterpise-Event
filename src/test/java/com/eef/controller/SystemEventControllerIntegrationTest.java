package com.eef.controller;

import com.eef.Constants;
import com.eef.objectmodel.SystemEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class SystemEventControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void customerEventIntegrationTest() throws Exception {
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

        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/ese/systemevent", se, String.class));
    }
}
