package lld.practice.loggingframework;

import java.time.LocalDateTime;

public record LogMessage(LogLevel logLevel, String message, String name, String threadName, LocalDateTime localdateTime) {
    public LogMessage(LogLevel logLevel, String message, String name) {
        this(logLevel, message, name, Thread.currentThread().getName(), LocalDateTime.now());
    }
}
