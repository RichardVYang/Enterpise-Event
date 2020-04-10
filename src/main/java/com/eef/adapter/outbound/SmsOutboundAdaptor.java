package com.eef.adapter.outbound;

import com.eef.objectmodel.SystemEvent;
import com.eef.util.EventUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsOutboundAdaptor implements OutboundAdaptor<SystemEvent>{
    private static final Logger log = LoggerFactory.getLogger(SmsOutboundAdaptor.class);

    @Override
    public Boolean send(SystemEvent event) {
        log.info("SMSOutboundAdaptor::send() entering ...");

        String enrichedMessage = EventUtil.sMSEnrichEvent(event);

        // TODO - specific implementation code to send message to downstreams

        return true;
    }
}
