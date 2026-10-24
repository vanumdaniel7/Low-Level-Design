package lld.patterns.observer;

public interface Observer<T> {
    void onValueUpdated(T updatedValue);
}
