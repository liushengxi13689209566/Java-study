package com.tattoo.code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2022-02-02 11:20
 * @Author: liushengxi
 * @Description:
 */
public class CreateThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //第一种方式
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("第1种方式:new Thread 1");
            }
        };
        t1.start();

        TimeUnit.SECONDS.sleep(1);

        //第二种方式
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第2种方式:new Thread 2");
            }
        });
        t2.start();

        TimeUnit.SECONDS.sleep(1);


        //第三种方式
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String result = "第3种方式:new Thread 3";
                return result;
            }
        });
        Thread t3 = new Thread(ft);
        t3.start();

        // 线程执行完，才会执行get()，所以FutureTask也可以用于闭锁
        String result = ft.get();
        System.out.println(result);

        TimeUnit.SECONDS.sleep(1);

        //第四种方式
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String result = "第4种方式:new Thread 4";
                return result;
            }
        });

        pool.shutdown();
        System.out.println(future.get());
    }
}
