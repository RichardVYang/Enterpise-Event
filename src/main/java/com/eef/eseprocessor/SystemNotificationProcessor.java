package com.eef.eseprocessor;

import com.eef.adapter.outbound.SlackOutboundAdaptor;
import com.eef.adapter.outbound.SmsOutboundAdaptor;
import com.eef.adapter.outbound.SmtpOutboundAdaptor;
import com.eef.eseinferenceengine.SystemEventInferenceRuleEngine;
import com.eef.eseruleengine.SystemEventRuleEngine;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SystemNotificationProcessor implements SystemProcessor {
    private static final Logger log = LoggerFactory.getLogger(SystemNotificationProcessor.class);

    @Override
    public Boolean process(SystemEvent event) {
        log.info("SystemNotificationProcessor::process()...");
        // TODO - inference engine and rule engine
        List rules = new SystemEventInferenceRuleEngine().inferRule(event);
        new SystemEventRuleEngine().executeRule(rules);

        // Following adapters use the same inference rule of SystemEventRuleEngine above.
        new SmtpOutboundAdaptor().send(event);
        new SlackOutboundAdaptor().send(event);
        new SmsOutboundAdaptor().send(event);

        return true;
    }
}
