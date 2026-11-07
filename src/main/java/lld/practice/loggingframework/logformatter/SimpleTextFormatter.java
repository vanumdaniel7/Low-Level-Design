package lld.practice.loggingframework.logformatter;

import lld.practice.loggingframework.LogMessage;

import java.time.format.DateTimeFormatter;

class SimpleTextFormatter implements LogFormatter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String format(LogMessage logMessage) {
        return String.format("%s [%s] %s - %s: %s\n",
                logMessage.localdateTime().format(DATE_TIME_FORMATTER),
                logMessage.threadName(),
                logMessage.logLevel(),
                logMessage.name(),
                logMessage.message());
    }
}
