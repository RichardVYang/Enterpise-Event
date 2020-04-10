package com.eef.eseservice;

import com.eef.objectmodel.SystemEvent;
import com.eef.util.EventUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SystemEventService {
    private static final Logger log = LoggerFactory.getLogger(SystemEventService.class);

    public void process(SystemEvent event) {
        log.info("SystemEventService::process()...");
            String categoryType = EventUtil.getRouterTypeFromSysEventCategory(event.getCategory());
            if (categoryType.length() > 0) {
                if (SystemEventDistributor.contain(categoryType)) {
                    SystemEventDistributor.SendEvent(event, categoryType);
                } else {
                    log.info("Unable to locate category: " + categoryType + " event: " + event);
                }
            } else {
                log.info("Event " + event + " does not contain valid category: " + categoryType);
            }
    }

}
