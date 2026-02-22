package lld.patterns.observer.push

interface Observer {
    fun onValueUpdated(temperature: Int, pressure: Int, humidity: Int)
}
