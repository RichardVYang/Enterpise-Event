package com.eef.util;

import com.eef.objectmodel.CustomerEvent;

public final class CustomerEventValidation {
    private CustomerEventValidation() {}

    public static boolean isPresented(String name) {
        return (null == name) ? false : (name.length() > 0) ? true : false;
    }

    public static boolean isObjectNull(Object object) {
        return (null != object) ? true : false;
    }

// There are other validations for well-form, type, length, and etc which will need to implement.
    public static boolean isEventValid(CustomerEvent event) {
        boolean isValid = !isPresented(event.getSourceName()) ? false :
                !isPresented(event.getSourceType()) ? false :
                        !isPresented(event.getEventType()) ? false :
                            !isPresented(event.getEventId()) ? false :
                                !isPresented(event.getCorrelationId()) ? false :
                                    !isPresented(event.getCategory()) ? false :
                                        !isPresented(event.getSubCategory()) ? false :
                                                !isPresented(event.getEventDesc()) ? false :
                                                        !isObjectNull(event.getEventDate()) ? false : true;

        return isValid;

    }

}
