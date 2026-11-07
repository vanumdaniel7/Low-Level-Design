package lld.practice.loggingframework;

import lld.practice.loggingframework.logappender.LogAppender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class AsyncLogProcessor {

    private final ExecutorService executorService;

    private static final long DEFAULT_TIMEOUT_MS = 5_000L;

    public AsyncLogProcessor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void process(LogMessage logMessage, List<LogAppender> logAppenders) {
        executorService.execute(() -> {
            logAppenders.forEach(logAppender -> {
                logAppender.append(logMessage);
            });
        });
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(DEFAULT_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                System.err.println("Logger executor did not terminate in the specified time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
