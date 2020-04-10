package com.eef.eseinferenceengine;

import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SystemEventKafkaInferenceRuleEngine implements InferenceRuleEngine {
    private static final Logger log = LoggerFactory.getLogger(SystemEventKafkaInferenceRuleEngine.class);


    /**
     * Use the given contextual event to pull inference rules from database or cvs in repos server.
     * Execute these inference rules to derive all the application rules in the rule engine that need to be executed.
     * @param event a contextual event of SystemEvent type
     * @return a list of applicable rules in the rule engine that need to be executed
     */
    @Override
    public List inferRule(SystemEvent event) {
        log.info("SystemEventKafkaInferenceEngine::inferRule()...");

        //TODO  - get inference rules from persistent state, from database or cvs in repos, and use the contextual event to determine applicable rules


        return new ArrayList();

    }
}
