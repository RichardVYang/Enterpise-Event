package com.eef.eseprocessor;

import com.eef.dal.SystemEventDao;
import com.eef.objectmodel.SystemEvent;
import com.eef.eseservice.SystemEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SystemHandlerService {
    private static final Logger log = LoggerFactory.getLogger(SystemHandlerService.class);

    public  void process(SystemEvent event) {
        log.info("SystemHandlerService.process() entering ...");

        new SystemEventDao().save(event);
        new SystemEventService().process(event);


    }

}
