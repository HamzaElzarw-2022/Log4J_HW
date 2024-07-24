package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyTimerLoggings {

    private final Logger logger = LogManager.getLogger(MyTimerLoggings.class);

    public void startLogging() {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(debugLogger(), 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(infoLogger(), 0, 60, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(errorLogger(), 0, 3600, TimeUnit.SECONDS);
    }

    private Runnable debugLogger() {
        return () -> logger.debug("debug logger");
    }

    private Runnable infoLogger() {
        return () -> logger.info("info logger");
    }

    private Runnable errorLogger() {
        return () -> logger.error("error logger");
    }

}
