package com.eef.ecerule;

import com.eef.objectmodel.CustomerEvent;

public interface EceRule {

    /**
     * This method provides the capabilities to filter out further processing of certain events and to validate
     * all specified conditions are satisfied before further processing those particular events. These conditions can be
     * declared and persisted in database or CSV file. One or more conditions need to associate with a contextual event
     * so that when that event arrives, it can perform the conditional check.  Events that are not associated
     * with any condition can proceed normally.
     *
     * @param event is a contextual event that originates from various systems within a company.
     * @return a Boolean true to proceed or false to terminate the processing of this event.
     */
    public Boolean executeRule(CustomerEvent event);
}
