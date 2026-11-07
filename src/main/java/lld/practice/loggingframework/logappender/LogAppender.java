package lld.practice.loggingframework.logappender;

import lld.practice.loggingframework.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
    void close();
}
