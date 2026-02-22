package lld.patterns.observer.push

class WeatherDataNotifier : Subject {
    private var temperature: Int = 0
    private var pressure: Int = 0
    private var humidity: Int = 0
    private val observers: MutableList<Observer> = mutableListOf()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { observer ->
            observer.onValueUpdated(temperature, pressure, humidity)
        }
    }

    fun setMeasurements(temperature: Int, pressure: Int, humidity: Int) {
        this.temperature = temperature
        this.pressure = pressure
        this.humidity = humidity
        notifyObservers()
    }
}
