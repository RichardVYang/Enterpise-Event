package com.eef.eseruleengine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SystemEventRuleEngine implements RuleEngine {
    private static final Logger log = LoggerFactory.getLogger(SystemEventRuleEngine.class);

    @Override
    public void executeRule(List rules) {
        log.info("SystemEventRuleEngine::executeRule()...");
        // TODO use the given rule names in the list to pull the rules from database and execute the rules
    }
}
