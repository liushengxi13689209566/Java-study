package com.tattoo.codes.sixteen;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TT implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  i ==  " + i);
        }
        return i;
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        pool.submit(new TT());
        pool.submit(new TT());
        pool.shutdown();
    }
}
