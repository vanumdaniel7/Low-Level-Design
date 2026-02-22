package lld.patterns.observer.push

class CurrentConditionsDisplayDevice : DisplayDevice, Observer {
    private var currentTemperature: Int = 0
    private var currentPressure: Int = 0
    private var currentHumidity: Int = 0

    override fun onValueUpdated(temperature: Int, pressure: Int, humidity: Int) {
        this.currentTemperature = temperature
        this.currentPressure = pressure
        this.currentHumidity = humidity
        display()
    }

    override fun display() {
        print("CurrentTemperature = $currentTemperature, " +
                "currentPressure = $currentPressure, " +
                "currentHumidity = $currentHumidity\n"
        )
    }
}
