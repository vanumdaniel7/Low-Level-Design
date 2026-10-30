package lld.patterns.command;

public class ThermostatSetTemperatureCommand implements Command {
    private final Thermostat thermostat;
    private int currentTemperature;
    private int previousTemperature;

    public ThermostatSetTemperatureCommand(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    public void setTemperature(int temperature) {
        this.currentTemperature = temperature;
    }

    @Override
    public void execute() {
        previousTemperature = thermostat.getTemperature();
        thermostat.setTemperature(this.currentTemperature);
    }

    @Override
    public void undo() {
        thermostat.setTemperature(this.previousTemperature);
    }
}
