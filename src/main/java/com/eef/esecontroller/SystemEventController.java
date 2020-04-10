package com.eef.esecontroller;

import com.eef.esehandler.SystemEventHandler;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*  System Object Model
    private String systemName; // name of system where original event starts
    private String subSystemName;
    private String systemType; // type of the system
    private String subSystemType;
    private String eventType;  // error, warning, etc
    private String eventId;
    private String correlationId;
    private String category;
    private String subCategory;
    privare String payload;
    private String eventDesc;
    private Date eventDate;
 */

/*
 Postman
 POST: http://localhost:8080/ese/systemevent/
 Body raw JSON:

 {
"systemName": "Reservation",
"subSystemName": "notification",
"systemType": "Java in Linux OS",
"subSystemType": "Java in Linus OS",
"eventType": "Alert",
"eventId": "abc123",
"correlationId": "13579aceg",
"category": "Alert",
"subCategory": "client",
"payload": "pay load content",
"eventDesc": "Event Description",
"eventDate": "2019-11-15T17:29:50.991+0000"
}

 */


/**
 * This RESTful API provides the entry point to ESE for all systems to consume. The Inbound Adapters will
 * delegate all incoming events to this RESTful API.  Other systems have the option to consume this RESTUL API
 * directly or choose one of the adapter whichever is convenient.
 */

@RestController
@RequestMapping("/ese")
public class SystemEventController {
    private static final Logger log = LoggerFactory.getLogger(SystemEventController.class);

    @Autowired
    SystemEventHandler handler;

    @PostMapping("/systemevent")
    @ResponseBody
    public ResponseEntity<?> postEvent(@RequestBody SystemEvent event) {
        log.info("SystemEventController::postEvent() entering...");

        handler.handle(event);

        //TODO handle exception and return it
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }



}
