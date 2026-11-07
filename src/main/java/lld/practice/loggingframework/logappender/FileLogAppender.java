package lld.practice.loggingframework.logappender;

import lld.practice.loggingframework.logformatter.LogFormatter;
import lld.practice.loggingframework.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogAppender implements LogAppender {

    private final FileWriter fileWriter;
    private final LogFormatter logFormatter;

    public FileLogAppender(FileWriter fileWriter, LogFormatter logFormatter) {
        this.fileWriter = fileWriter;
        this.logFormatter = logFormatter;
    }

    @Override
    public void append(LogMessage logMessage) {
        try {
            fileWriter.write(logFormatter.format(logMessage));
        } catch (IOException e) {
            System.out.println("Failed to write logs to file");
        }
    }

    @Override
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to close file writter");
        }
    }
}
