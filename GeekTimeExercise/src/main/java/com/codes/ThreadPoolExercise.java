package com.codes;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadPoolExercise<futureTask> {

    /*将 FutureTask 对象提交给 ThreadPoolExecutor 去执行*/
    @Test
    public void testFutureTask() throws ExecutionException, InterruptedException {
        // 创建FutureTask
        FutureTask<Integer> futureTask
                = new FutureTask<>(() -> 1 + 2);
        // 创建线程池
        ExecutorService es =
                Executors.newCachedThreadPool();
        // 提交FutureTask
        es.submit(futureTask);
        // 获取计算结果
        Integer result = futureTask.get();
        System.out.println(result);
    }

    @Test
    public void testFutureTaskThread() throws ExecutionException, InterruptedException {
        // 创建FutureTask
        FutureTask<Integer> futureTask
                = new FutureTask<>(() -> 1 + 2);
        // 创建并启动线程
        Thread T1 = new Thread(futureTask);
        T1.start();
        // 获取计算结果
        Integer result = futureTask.get();
    }
}
