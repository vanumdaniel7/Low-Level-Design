package lld.patterns.command;

public class Thermostat {
    private int temperature;

    public void setTemperature(int temperature) {
        System.out.println("Setting temperature to " + temperature);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return this.temperature;
    }
}
