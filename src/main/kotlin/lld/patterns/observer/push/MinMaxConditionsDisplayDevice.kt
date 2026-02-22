package lld.patterns.observer.push

import java.lang.Integer.min
import kotlin.math.max

class MinMaxConditionsDisplayDevice : Observer, DisplayDevice {
    private var minTemperature = Int.MAX_VALUE
    private var maxTemperature = Int.MIN_VALUE
    private var maxPressure = Int.MIN_VALUE
    private var minPressure = Int.MIN_VALUE
    private var maxHumidity = Int.MIN_VALUE
    private var minHumidity = Int.MIN_VALUE

    override fun onValueUpdated(temperature: Int, pressure: Int, humidity: Int) {
        minTemperature = min(temperature, minTemperature)
        maxTemperature = max(temperature, maxTemperature)
        minPressure = min(pressure, minPressure)
        maxPressure = max(pressure, maxPressure)
        minHumidity = min(humidity, minHumidity)
        maxHumidity = max(humidity, maxHumidity)
        display()
    }

    override fun display() {
        print("minTemperature = $minTemperature, maxTemperature = $maxTemperature, " +
                "minPressure = $minPressure, maxPressure = $maxPressure" +
                "minHumidity = $minHumidity, maxHumidity = $maxHumidity"
        )
    }
}
