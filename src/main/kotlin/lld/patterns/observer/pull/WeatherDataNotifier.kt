package lld.patterns.observer.pull

import java.util.Observable

class WeatherDataNotifier : Observable() {

    private var temperature = 0
    private var pressure = 0
    private var humidity = 0

    fun getTemperature() = temperature

    fun getPressure() = pressure

    fun getHumidity() = humidity

    fun setMeasurements(temperature: Int, pressure: Int, humidity: Int) {
        this.temperature = temperature
        this.pressure = pressure
        this.humidity = humidity
        setChanged()
        notifyObservers()
    }
}
