package lld.patterns.command;

public interface Command {
    void execute();
    void undo();
}
