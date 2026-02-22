package lld

import lld.patterns.observer.pull.WeatherDataNotifier
import lld.patterns.observer.pull.CurrentConditionsDisplayDevice

fun main() {
     val weatherDataNotifier = WeatherDataNotifier()
     val currentConditionsDisplayDevice = CurrentConditionsDisplayDevice()
     weatherDataNotifier.addObserver(currentConditionsDisplayDevice)
     currentConditionsDisplayDevice.display()
     weatherDataNotifier.setMeasurements(20, 30, 40)
}
