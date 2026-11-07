package lld.practice.loggingframework;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class LogManager {
    private final ConcurrentHashMap<String, Logger> loggers;
    private final AsyncLogProcessor asyncLogProcessor;

    private static final int DEFAULT_THREAD_COUNT = 2;
    private static final boolean DAEMON = true;

    private LogManager() {
        this.loggers = new ConcurrentHashMap<>();
        this.asyncLogProcessor = new AsyncLogProcessor(Executors.newFixedThreadPool(DEFAULT_THREAD_COUNT, runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(DAEMON);
            return thread;
        }));
    }

    public static LogManager getInstance() {
        return Holder.INSTANCE;
    }

    public AsyncLogProcessor getProcessor() {
        return asyncLogProcessor;
    }

    public Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, Logger::new);
    }

    public void shutdown() {
        asyncLogProcessor.shutdown();
        loggers.values().forEach(Logger::shutdown);
    }

    private static class Holder {
        private static final LogManager INSTANCE = new LogManager();
    }
}
