package lld.patterns.iterator;

public interface IterableCollection<T> {
    Iterator<T> createIterator();
}
