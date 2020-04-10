package com.eef.adapter.inbound;

import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FTPInboundAdaptor implements InboundAdaptor {
    private static final Logger log = LoggerFactory.getLogger(FTPInboundAdaptor.class);


    @Override
    public SystemEvent receiveEvent() {

        //TODO pull event from ftp location, validate, and construct object model and delegate to RESTful API
        return new SystemEvent();


    }
}
