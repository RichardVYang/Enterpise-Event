package com.eef.eseinferenceengine;

import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SystemEventJmsInferenceRuleEngine implements InferenceRuleEngine {
    private static final Logger log = LoggerFactory.getLogger(SystemEventJmsInferenceRuleEngine.class);


    @Override
    public List inferRule(SystemEvent event) {
        log.info("SystemEventJmsInferenceEngine::inferRule()...");

        //TODO  - get inference rules from persistent state and use the contextual event to determine applicable rules


        return new ArrayList();

    }
}
