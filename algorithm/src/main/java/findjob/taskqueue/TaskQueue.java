package findjob.taskqueue;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class TaskQueue {
    private BlockingQueue<Runnable> queue;
    private ExecutorService executor;
    private int maxConcurrentTasks;
    private AtomicInteger runCount;


    public TaskQueue(int maxConcurrentTasks, int queueCapacity) {
        this.queue = new ArrayBlockingQueue<Runnable>(queueCapacity);
        this.maxConcurrentTasks = maxConcurrentTasks;
        this.executor = Executors.newCachedThreadPool();
        this.maxConcurrentTasks = maxConcurrentTasks;
        this.runCount = new AtomicInteger(0);
        new Thread(this::processStart).start();
    }

    public CompletableFuture<Void> addTask(Runnable task) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        try {
            queue.put(() -> {
                try {
                    task.run();
                    future.complete(null);
                } catch (Exception e) {
                    future.completeExceptionally(e);
                } finally {
                    runCount.incrementAndGet();
                }
            });
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }

    private void processStart() {
        while (true) {
            try {
                if (maxConcurrentTasks <= runCount.get()) {
                    continue;
                }
                Runnable runnable = queue.take();
                executor.execute(runnable);
            } catch (Exception e) {
                System.out.println("发生异常，请关注！！");
                break;
            }
        }
    }

    private void shutdown() {
        executor.shutdown();
    }


    public int getQueueSize() {
        return queue.size();
    }

    public int getRunSize() {
        return runCount.get();
    }

}
