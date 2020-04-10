package com.eef.eseservice;

import com.eef.Constants;
import com.eef.eseprocessor.*;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/*
    Note that the event distribution using Enum here is one option.
    It can also be done via Spring configuration, Spring Integration, or other patterns.
 */

public enum SystemEventDistributor {

    alert_route(Constants.ALERT_EVENT) {
        public Boolean send(SystemEvent event) {
            log.info("********> alert_rout send....");
            new JmsSystemProcessor().process(event);

            return true;
        }

    },
    notify_rout(Constants.NOTIFICATION_EVENT) {
        public Boolean send(SystemEvent event) {
            log.info("********> notify_rout send....");
            // NOTE: These processors could be defined in Spring Configuration and injected into this as an array list.
            new SystemNotificationProcessor().process(event); // SystemNotificationProcessor has its own inference rules
            new KafkaSystemProcessor().process(event);  // KafkaSystemProcessor has its own inference rules

            return true;
        }
    },
    sys_health_rout(Constants.ERROR_EVENT, Constants.WARNING_EVENT, Constants.DEBUG_EVENT, Constants.INFO_EVENT, Constants.TRACE_EVENT) {
        public Boolean send(SystemEvent event) {
            log.info("********> sys_health_route send....");
            new SystemHealthProcessor().process(event);

            return true;
        }
    };

    private static final Logger log = LoggerFactory.getLogger(SystemEventDistributor.class);

    private static Optional<SystemEventDistributor> getDistributor(String distributorKey) {
        for (SystemEventDistributor distributor : SystemEventDistributor.values()) {
            if (distributor.getValues().contains(distributorKey)) {
                return Optional.ofNullable(distributor);
            }
        }
        return Optional.ofNullable(null);
    }

    private final List<String> values;
    SystemEventDistributor(String ... values) { this.values = Arrays.asList(values);}

    public abstract Boolean send(SystemEvent event);

    public List<String> getValues() { return values;}


    public static Boolean contain(String distributionKey) {
        Optional<SystemEventDistributor> optionalDistributor  = getDistributor(distributionKey);
        return optionalDistributor.isPresent();
    }

    public static Boolean SendEvent(SystemEvent event, String distributionKey) {
        AtomicReference<Boolean> isSent = new AtomicReference<>(false);
        Optional<SystemEventDistributor> targetDistributor  = getDistributor(distributionKey);
        targetDistributor.ifPresent(distributor -> {
            distributor.send(event);
            isSent.set(true);
        });
        return isSent.get();
    }

}
