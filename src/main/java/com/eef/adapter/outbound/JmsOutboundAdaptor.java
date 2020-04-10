package com.eef.adapter.outbound;

import com.eef.objectmodel.SystemEvent;
import com.eef.util.EventUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmsOutboundAdaptor implements OutboundAdaptor<SystemEvent> {
    private static final Logger log = LoggerFactory.getLogger(JmsOutboundAdaptor.class);

    @Override
    public Boolean send(SystemEvent event) {
        log.info("JMSOutboundAdaptor::send() entering ...");

        String enrichedMessage = EventUtil.jMSEnrichEvent(event);

        // TODO - specific implementation to send JMS message to downstream system(s)

        return true;
    }
}
