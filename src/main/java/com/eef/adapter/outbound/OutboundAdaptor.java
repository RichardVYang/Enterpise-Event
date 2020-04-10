package com.eef.adapter.outbound;

import com.eef.objectmodel.SystemEvent;

public interface OutboundAdaptor<T> {

    public Boolean send(T event);


}
