package com.eef.ecehandler;

import com.eef.eceservice.CustomerEventService;
import com.eef.objectmodel.CustomerEvent;
import com.eef.util.ConsistentHash;
import com.eef.util.CustomerEventValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CustomerEventHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomerEventHandler.class);

    private static volatile int executorPoolSize = 5; // need to load the value from the container property file
    private static volatile int threadPoolSize = 10; // need to load the value from the container property file

    private static volatile List<ExecutorService> executors = new ArrayList<ExecutorService>();

    static {
        for (int i = 0; i < executorPoolSize; i++) {
            ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
            executors.add(executor); // Each executor service will have threadPoolSize threads and ordering is not important
        }
    }

    private ExecutorService getExecutor(String key) {
        ExecutorService executor = executors.get(ConsistentHash.getConsistentHashBucket(key,  executors.size()));
        return executor;
    }

    public void handle(CustomerEvent event) {
        log.info("CustomerEventHandler::handle() Entering...");
        if (CustomerEventValidation.isEventValid(event)) {
            ExecutorService service = getExecutor(event.getCategory());
            service.execute(() -> new CustomerEventService().process(event));

        } else {
            log.info("Invalid event");
        }

    }
}
