package com.eef.util;


import com.eef.eseprocessor.SystemHandlerService;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/* Most of the methods here are duplicated with CustomerEventValidation. This makes it easy to separate ECE from ESE
    into different project.
 */

public final class SystemEventValidation {
    private static final Logger log = LoggerFactory.getLogger(SystemEventValidation.class);

    private SystemEventValidation() {}

    public static boolean isPresented(String name) {
        return (null == name) ? false : (name.length() > 0) ? true : false;
    }

    public static boolean isObjectNull(Object object) {
        return (null != object) ? true : false;
    }

    public static void logConsole(String message) {
        log.info(message);
    }

    /*
    This is a simple validation to make sure all required data are presented.
     There are other patterns for validation as well to identify all those missing data and log them appropriately.
     */
    public static boolean isPresented(SystemEvent event) {
        boolean isValid = !isPresented(event.getSystemName()) ? false :
                !isPresented(event.getSubSystemName()) ? false :
                !isPresented(event.getSystemType()) ? false :
                        !isPresented(event.getSubSystemType()) ? false :
                            !isPresented(event.getEventType()) ? false :
                                !isPresented(event.getEventId()) ? false :
                                        !isPresented(event.getCorrelationId()) ? false :
                                                !isPresented(event.getCategory()) ? false :
                                                        !isPresented(event.getSubCategory()) ? false :
                                                                !isPresented(event.getEventDesc()) ? false :
                                                                        !isObjectNull(event.getEventDate()) ? false : true;

        return isValid;

    }

    public static List<String> isValid(SystemEvent event) {
        String message = " is missing";
        List<String>missingList = new ArrayList<>();

        if (!isPresented(event.getSystemName())) {
            missingList.add("SystemName");
            logConsole( "SystemName" + message);
        }
        if (!isPresented(event.getSubSystemName())) {
            missingList.add("SubSystemName");
            logConsole("SubSystemName" + message);
        }
        if (!isPresented(event.getSystemType())) {
            missingList.add("SystemType");
            logConsole("SystemType"+message);
        }
        if (!isPresented(event.getSubSystemType())) {
            missingList.add("SubSystemType");
            logConsole("SubSystemType"+message);
        }
        if (!isPresented(event.getEventType())) {
            missingList.add("EventType");
            logConsole("EventType"+message);
        }
        if (!isPresented(event.getEventId())) {
            missingList.add("EventId");
            logConsole("EventId"+message);
        }
        if (!isPresented(event.getCorrelationId())) {
            missingList.add("CorrelationId");
            logConsole("CorrelationId"+message);
        }
        if (!isPresented(event.getCategory())) {
            missingList.add("CorrelationId");
            logConsole("Category" + message);
        }
        if (!isPresented(event.getSubCategory())) {
            missingList.add("SubCategory");
            logConsole("SubCategory"+message);
        }
        if (!isPresented(event.getEventDesc())) {
            missingList.add("EventDesc");
            logConsole("EventDesc"+message);
        }
        if (!isObjectNull(event.getEventDate()) ) {
            missingList.add("EventDate");
            logConsole("EventDate"+message);
        }

        return missingList;
    }


}
