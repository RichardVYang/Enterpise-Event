package com.eef.adapter.inbound;

import com.eef.objectmodel.SystemEvent;

public interface InboundAdaptor<T> {

    public T receiveEvent();
}
