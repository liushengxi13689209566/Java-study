package findjob.taskqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class GenericPriorityTaskQueue<T> {
    private PriorityBlockingQueue<Task<T>> taskQueue;
    private ExecutorService executor;
    private int maxSize;
    private AtomicInteger runCount;

    public GenericPriorityTaskQueue(int maxSize) {
        this.maxSize = maxSize;
        this.runCount = new AtomicInteger(0);
        this.taskQueue = new PriorityBlockingQueue<Task<T>>();
        this.executor = Executors.newFixedThreadPool(maxSize);

        this.processStart();
    }

    private void processStart() {
        while (runCount.get() < maxSize && !taskQueue.isEmpty()) {
            Task<T> task = taskQueue.poll();
            if(task != null){
            }
        }

}
