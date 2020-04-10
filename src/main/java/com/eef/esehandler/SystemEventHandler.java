package com.eef.esehandler;


import com.eef.eseprocessor.SystemHandlerService;
import com.eef.objectmodel.SystemEvent;
import com.eef.util.ConsistentHash;
import com.eef.util.SystemEventValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SystemEventHandler {

    private static final Logger log = LoggerFactory.getLogger(SystemEventHandler.class);

    private static volatile int executorPoolSize = 5; // need to load the value from the container property file
    private static volatile int threadPoolSize = 10; // need to load the value from the container property file

    // Each of the executorPoolSize executors will have a blocking queue with number of thread size threadPoolSize
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

    public void handle(SystemEvent event) {
        log.info("CustomerEventHandler::handle() Entering...");
      //  if (SystemEventValidation.isPresented(event)) {
        if (SystemEventValidation.isValid(event).isEmpty()) {
            ExecutorService service = getExecutor(event.getCategory());
            service.execute(() -> new SystemHandlerService().process(event));
        } else {
            log.info("Invalid event");
        }

    }
}
