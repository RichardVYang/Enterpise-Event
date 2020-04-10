package com.eef.adapter.outbound;

import com.eef.objectmodel.SystemEvent;
import com.eef.util.EventUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaOutboundAdaptor implements OutboundAdaptor<SystemEvent> {
    private static final Logger log = LoggerFactory.getLogger(KafkaOutboundAdaptor.class);

    @Override
    public Boolean send(SystemEvent event) {
        log.info("KafkaOutboundAdaptor::send() entering ...");

        String enrichedMessage = EventUtil.kafkaEnrichEvent(event);

        // TODO - specific implementation code to send message to downstreams via Kafka

        return true;
    }
}
