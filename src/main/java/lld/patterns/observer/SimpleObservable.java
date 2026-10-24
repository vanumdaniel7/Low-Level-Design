package lld.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class SimpleObservable<T> implements Observable<T> {

    private final List<Observer<T>> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(T t) {
        observers.forEach(observer -> observer.onValueUpdated(t));
    }

    public void setData(T t) {
        notifyObservers(t);
    }

    public static void main(String[] args) {
        SimpleObservable<FitnessData> fitnessDataNotifier = new SimpleObservable<>();
        LiveActivityDisplay liveActivityDisplay = new LiveActivityDisplay();

        fitnessDataNotifier.subscribe(liveActivityDisplay);
        fitnessDataNotifier.setData(new FitnessData(30, 40, 50));
    }
}
