package com.eef.eseprocessor;

import com.eef.objectmodel.SystemEvent;

public interface SystemProcessor {

    public Boolean process(SystemEvent event);
}
