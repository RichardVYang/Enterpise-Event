package com.eef.adapter.outbound;

import com.eef.objectmodel.SystemEvent;
import com.eef.util.EventUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlackOutboundAdaptor implements OutboundAdaptor<SystemEvent>{
    private static final Logger log = LoggerFactory.getLogger(SlackOutboundAdaptor.class);

    @Override
    public Boolean send(SystemEvent event) {
        log.info("SlackOutboundAdaptor::send() entering ...");

        String enrichedMessage = EventUtil.slackEnrichEvent(event);

        // TODO - specific implementation code to send message to downstreams

        return true;
    }
}
