package com.eef.eseinferenceengine;

import com.eef.objectmodel.SystemEvent;

import java.util.List;

public interface InferenceRuleEngine {

    /**
     * The Inference Engine provides the capabilities to filter events, to process/check various conditional rules
     * and when those conditional rules are satisfied, one or more rule names will be identified and returned as a list
     * for the Rule Engine to proceed. This Inference Rule Engine uses the conditional rules from database or CSV file as
     * a memory cache.
     * @param event is a contextual event originating from external customers.
     * @return A list containing rule names that satisfy the Inference Rule Engine.
     */
    public List inferRule(SystemEvent event);
}

