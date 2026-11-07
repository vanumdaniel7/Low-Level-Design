package lld.practice.urlshortener;

import java.util.ArrayList;
import java.util.List;

public class DefaultObservable<T> implements Observable<T> {

    private final List<Observer<T>> observers;

    public DefaultObservable() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer<T> observer) {
        this.observers.add(observer);
    }

    @Override
    public void onValueChanged(T t) {
        this.observers.forEach(observer -> observer.onValueChanged(t));
    }
}
