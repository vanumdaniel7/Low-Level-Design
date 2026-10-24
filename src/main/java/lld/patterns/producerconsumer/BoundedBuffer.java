package lld.patterns.producerconsumer;

import java.util.Queue;

public class BoundedBuffer<T> {
    private final Queue<T> queue;
    private final int capacity;

    public BoundedBuffer(Queue<T> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }

        queue.add(item);
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }

        T item = queue.poll();
        notifyAll();
        return item;
    }
}
