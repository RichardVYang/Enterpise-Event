package com.eef.eseprocessor;

import com.eef.adapter.outbound.JmsOutboundAdaptor;
import com.eef.eseinferenceengine.SystemEventJmsInferenceRuleEngine;
import com.eef.eseruleengine.SystemEventRuleEngine;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JmsSystemProcessor implements SystemProcessor {
    private static final Logger log = LoggerFactory.getLogger(JmsSystemProcessor.class);

    @Override
    public Boolean process(SystemEvent event) {
        log.info("JmsSystemProcessor::process()...");

        List rules = new SystemEventJmsInferenceRuleEngine().inferRule(event);
        new SystemEventRuleEngine().executeRule(rules);

        return new JmsOutboundAdaptor().send(event);
    }
}