package com.eef.controller;

import com.eef.objectmodel.CustomerEvent;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerEventControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void customerEventIntegrationTest() throws Exception {
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

        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/ece/customerevent", ce, String.class));
    }

}
