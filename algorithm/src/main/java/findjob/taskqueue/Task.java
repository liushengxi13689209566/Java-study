package findjob.taskqueue;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

@Data
class Task<T> implements Comparable<Task<T>> {
    private Callable<T> task;
    private CompletableFuture<T> future;
    private int priority;

    Task(Callable<T> task, int priority) {
        this.task = task;
        this.future = new CompletableFuture<T>();
        this.priority = priority;
    }


    @Override
    public int compareTo(@NotNull Task<T> o) {
        return Integer.compare(priority, o.priority);
    }
}
