package lld.patterns.observer.pull

import java.util.Observable
import java.util.Observer

class CurrentConditionsDisplayDevice : Observer {
    private var currentTemperature: Int = 0
    private var currentPressure: Int = 0
    private var currentHumidity: Int = 0

    override fun update(o: Observable?, arg: Any?) {
        when (o) {
            is WeatherDataNotifier -> {
                currentTemperature = o.getTemperature()
                currentPressure = o.getPressure()
                currentHumidity = o.getHumidity()
                display()
            }
            else -> {}
        }
    }

    fun display() {
        print("CurrentTemperature = $currentTemperature, " +
                "currentPressure = $currentPressure, " +
                "currentHumidity = $currentHumidity\n"
        )
    }
}
