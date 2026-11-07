package lld.practice.loggingframework.logformatter;

import lld.practice.loggingframework.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
