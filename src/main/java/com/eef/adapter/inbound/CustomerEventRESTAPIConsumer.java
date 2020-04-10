package com.eef.adapter.inbound;

import com.eef.objectmodel.CustomerEvent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

public class CustomerEventRESTAPIConsumer {

    @PostMapping("/ece/customerevent")
    public String postCustomerEvent(@RequestBody CustomerEvent eventRequest) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForEntity("http://localhost:8080/ece/customerevent", eventRequest, String.class);

        return response.getBody().toString();
    }

}
