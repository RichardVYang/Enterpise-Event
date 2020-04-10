package com.eef.eseprocessor;

import com.eef.adapter.outbound.SmtpOutboundAdaptor;
import com.eef.eseinferenceengine.SystemEventHealthInferenceRuleEngine;
import com.eef.eseruleengine.SystemEventRuleEngine;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SystemHealthProcessor implements SystemProcessor {
    private static final Logger log = LoggerFactory.getLogger(SystemHealthProcessor.class);

    @Override
    public Boolean process(SystemEvent event) {
        log.info("SystemHealthProcessor::processEvent()...");
        // TODO process Error, Warning, Debug, Info, and Trace logic here.
        List rules = new SystemEventHealthInferenceRuleEngine().inferRule(event);
        new SystemEventRuleEngine().executeRule(rules);

        return new SmtpOutboundAdaptor().send(event);

    }
}
