package com.eef.adapter.inbound;

import com.eef.objectmodel.SystemEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

public class SystemEventRESTAPIConsumer {

    @PostMapping("/ese/systemevent")
    public String postCustomerEvent(@RequestBody SystemEvent eventRequest) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForEntity("http://localhost:8080/ese/systemevent", eventRequest, String.class);

        return response.getBody().toString();
    }
}
