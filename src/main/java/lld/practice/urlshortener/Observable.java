package lld.practice.urlshortener;

public interface Observable<T> {
    void addObserver(Observer<T> observer);
    void onValueChanged(T t);
}
