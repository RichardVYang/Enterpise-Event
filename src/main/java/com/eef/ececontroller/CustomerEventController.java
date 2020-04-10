package com.eef.ececontroller;

import com.eef.ecehandler.CustomerEventHandler;
import com.eef.objectmodel.CustomerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* Customer Object Model

    private String sourceName;
    private String sourceType;
    private String eventType;
    private String eventId;
    private String correlationId;
    private String category;
    private String subCategory;
    private String eventDesc;
    private Date eventDate;
 */

/*
 Postman
 POST: http://localhost:8080/ece/customerevent/
 Body raw JSON:

 {
"sourceName": "Reservation",
"sourceType": "Java in Linux OS",
"eventType": "search",
"eventId": "abc123",
"correlationId": "13579aceg",
"category": "customer",
"subCategory": "client",
"eventDesc": "customer search flight from Atlanta airport to Chicago airport on 12/15/2019",
"eventDate": "2019-11-15T17:29:50.991+0000"
}
 */


/**
 * This RESTful API provides entry points to ECE for customer interfacing systems to consume directly.
 * The Inbound Adapters will also delegate incoming events to this RESTful API.
 * Customer interfacing systems have the option to consume this RESTful API directly or interface with the appropriate
 * inbound adapter.
 */

@RestController
@RequestMapping("/ece")
public class CustomerEventController {
    private static final Logger log = LoggerFactory.getLogger(CustomerEventController.class);

    @Autowired
    CustomerEventHandler handler;

    @PostMapping("/customerevent")
    @ResponseBody
    public ResponseEntity<?> postEvent(@RequestBody CustomerEvent event) {
        log.info("CustomerEventController::postEvent() entering...");
        handler.handle(event);

        //TODO handle exception and return it
        return new ResponseEntity<>("Success", HttpStatus.OK);

    }


}
