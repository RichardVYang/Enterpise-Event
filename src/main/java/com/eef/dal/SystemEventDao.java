package com.eef.dal;

import com.eef.objectmodel.SystemEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemEventDao {
    private static final Logger log = LoggerFactory.getLogger(SystemEventDao.class);

    public void save(SystemEvent message) {
        log.info("SystemEventDao::save() entering...");
        // TODO - persist message to database

    }
}
