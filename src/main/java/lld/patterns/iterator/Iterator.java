package lld.patterns.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T getNext();
}
