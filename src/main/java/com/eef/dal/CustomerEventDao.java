package com.eef.dal;

import com.eef.objectmodel.CustomerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerEventDao {

    private static final Logger log = LoggerFactory.getLogger(CustomerEventDao.class);

    public void save(CustomerEvent event) {
        log.info("CustomerEventDao::save() entering...");
        // TODO - logic to persist this event to database

    }

}
