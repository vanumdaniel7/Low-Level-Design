package lld.practice.loggingframework;

public enum LogLevel {
    DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);

    private int severity;

    LogLevel(int severity) {
        this.severity = severity;
    }

    public boolean isGreaterThanEqualTo(LogLevel logLevel) {
        return this.severity >= logLevel.severity;
    }
}
