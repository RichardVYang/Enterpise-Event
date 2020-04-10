package com.eef.ecerule;

import com.eef.eseruleengine.SystemEventRuleEngine;
import com.eef.objectmodel.CustomerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EceEventRule implements EceRule {
    private static final Logger log = LoggerFactory.getLogger(EceEventRule.class);


    @Override
    public Boolean executeRule(CustomerEvent event) {
        log.info("EceEventRule::executeRule entering...");

        //TODO if this event exists in the conditional rules, check all those conditions to satisfy before proceed.
        //TODO Otherwise, return true and proceed normally.

        return true;
    }
}
