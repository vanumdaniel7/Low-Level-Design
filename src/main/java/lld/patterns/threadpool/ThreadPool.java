package lld.patterns.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {

    private BlockingDeque<Runnable> taskQueue;
    private List<Worker> workers;
    private volatile boolean isShutDown;

    public ThreadPool(int workerCount) {
        this.taskQueue = new LinkedBlockingDeque<>();
        this.workers = new ArrayList<>();
        this.isShutDown = false;

        for (int i = 0; i < workerCount; i++) {
            Worker worker = new Worker();

            this.workers.add(worker);
            worker.start();
        }
    }

    public void submit(Runnable task) {
        if (this.isShutDown) {
            throw new IllegalStateException("Threadpool is shutdown");
        }
        this.taskQueue.offer(task);
    }

    public void shutdown() {
        this.isShutDown = true;
        for (Worker worker : this.workers) {
            worker.interrupt();
        }
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            while (!isShutDown) {
                try {
                    Runnable currentTask = taskQueue.take();
                    currentTask.run();
                } catch (InterruptedException interruptedException) {
                    break;
                }
            }
        }
    }
}
