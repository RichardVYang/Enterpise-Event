package com.eef.util;

import com.eef.Constants;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EventUtil {
    private static final Logger log = LoggerFactory.getLogger(EventUtil.class);
    private EventUtil() {}

    public static String getRouterTypeFromSysEventCategory(String categoryType) {
        String router = categoryType.contains(Constants.ERROR) ? Constants.ERROR_EVENT:
                categoryType.contains(Constants.WARNING) ? Constants.WARNING_EVENT :
                        categoryType.contains(Constants.INFO) ? Constants.INFO_EVENT :
                                categoryType.contains(Constants.DEBUG) ? Constants.DEBUG_EVENT :
                                        categoryType.contains(Constants.TRACE) ? Constants.TRACE_EVENT :
                                                categoryType.contains(Constants.ALERT) ? Constants.ALERT_EVENT :
                                                        categoryType.contains(Constants.NOTIFICATION) ? Constants.NOTIFICATION_EVENT : "";

        return router;

    }

    public static String getRouterTypeFromCustomEventType(String event) {
    String eventType = event.contains("agent") ? "agent" :
            event.contains("customer") ? "customer" :
            event.contains("employee") ? "employee" : "default";

        return eventType;
}

    public static String jMSEnrichEvent(final SystemEvent event) {
        log.info("MessageUtil::jMSEnrichEvent() Entering....");
        //TODO - implement real JMS event enrichment


        String enrichedMessage = "";

        return enrichedMessage;
    }
    public static String kafkaEnrichEvent(final SystemEvent event) {
        log.info("MessageUtil::kafkaEnrichEvent() Entering....");
        //TODO - implement real Kafka event enrichment

        String enrichedMessage = "";

        return enrichedMessage;
    }
    public static String sMTPEnrichEvent(final SystemEvent event) {
        log.info("MessageUtil::sMTPEnrichEvent() Entering....");
        //TODO - implement real SMTP event enrichment

        String enrichedMessage = "";

        return enrichedMessage;
    }
    public static String sMSEnrichEvent(final SystemEvent event) {
        log.info("MessageUtil::sMSEnrichEvent() Entering....");
        //TODO - implement real SMS event enrichment
        String enrichedMessage = "";

        return enrichedMessage;
    }
    public static String slackEnrichEvent(final SystemEvent event) {
        log.info("MessageUtil::slackEnrichEvent() Entering....");
        //TODO - implement real Slack event enrichment

        String enrichedMessage = "";

        return enrichedMessage;
    }


}
