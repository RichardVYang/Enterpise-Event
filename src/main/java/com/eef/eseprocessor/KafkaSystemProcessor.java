package com.eef.eseprocessor;

import com.eef.adapter.outbound.KafkaOutboundAdaptor;
import com.eef.eseinferenceengine.SystemEventKafkaInferenceRuleEngine;
import com.eef.eseruleengine.SystemEventRuleEngine;
import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class KafkaSystemProcessor implements SystemProcessor {
    private static final Logger log = LoggerFactory.getLogger(KafkaSystemProcessor.class);

    @Override
    public Boolean process(SystemEvent event) {
        log.info("KafkaProcessor::processEvent()...");
        // TODO - inference engine and rule engine
        List rules = new SystemEventKafkaInferenceRuleEngine().inferRule(event);
        new SystemEventRuleEngine().executeRule(rules);

        return new KafkaOutboundAdaptor().send(event);
    }
}
