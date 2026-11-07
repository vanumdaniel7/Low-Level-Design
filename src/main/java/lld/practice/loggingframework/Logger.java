package lld.practice.loggingframework;

import lld.practice.loggingframework.logappender.LogAppender;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private final String name;
    private final List<LogAppender> logAppenders;
    private LogLevel logLevel;

    public Logger(String name) {
        this.name = name;
        this.logAppenders = new ArrayList<>();
        this.logLevel = LogLevel.INFO;
    }

    public void log(LogLevel logLevel, String message) {
        if (logLevel.isGreaterThanEqualTo(this.logLevel)) {
            LogMessage logMessage = new LogMessage(logLevel, message, this.name);
            LogManager.getInstance().getProcessor().process(logMessage, this.logAppenders);
        }
    }

    public void addLogAppender(LogAppender logAppender) {
        this.logAppenders.add(logAppender);
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void shutdown() {
        this.logAppenders.forEach(LogAppender::close);
    }

    public void debug(String message) {
        this.log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        this.log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        this.log(LogLevel.WARN, message);
    }

    public void error(String message) {
        this.log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        this.log(LogLevel.FATAL, message);
    }
}
