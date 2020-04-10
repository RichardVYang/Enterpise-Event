package com.eef.eceservice;

import com.eef.dal.CustomerEventDao;
import com.eef.ecerule.EceEventRule;
import com.eef.objectmodel.CustomerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerEventService {
    private static final Logger log = LoggerFactory.getLogger(CustomerEventService.class);

    public  void process(CustomerEvent event) {
        log.info("CustomerHandlerService.process() entering ...");
        boolean isEventClearToProceed = new EceEventRule().executeRule(event);
        if (isEventClearToProceed) {
            // TODO perform any other processing for this event before persisting it
            new CustomerEventDao().save(event);
        }
    }
}
