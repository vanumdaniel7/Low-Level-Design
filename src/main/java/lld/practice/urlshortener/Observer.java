package lld.practice.urlshortener;

public interface Observer<T> {
    void onValueChanged(T t);
}
