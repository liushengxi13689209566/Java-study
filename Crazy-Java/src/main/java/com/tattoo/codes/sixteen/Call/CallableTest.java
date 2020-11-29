package com.tattoo.codes.sixteen.Call;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class TT implements Callable {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  i ==  " + i);
        }
        return i;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        TT tt = new TT();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(tt);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "  i ==  " + i);
            if (i == 9) {
                new Thread(futureTask, " have return ").start();
            }
        }
        try {

            System.out.println(futureTask.get());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
