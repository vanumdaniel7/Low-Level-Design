package lld.patterns.command;

import java.util.Stack;

public class RemoteControl {
    Stack<Command> commandStack;

    public void executeCommand(Command command) {
        command.execute();
        commandStack.push(command);
    }

    public void undoLast() {
        if (!commandStack.isEmpty()) {
            Command lastCommand = commandStack.pop();
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    static void main() {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        Command thermostatSetTemperatureCommand = new ThermostatSetTemperatureCommand(thermostat);

        remoteControl.executeCommand(lightOnCommand);
        remoteControl.executeCommand(lightOffCommand);
        remoteControl.undoLast();
        remoteControl.executeCommand(thermostatSetTemperatureCommand);
    }
}
