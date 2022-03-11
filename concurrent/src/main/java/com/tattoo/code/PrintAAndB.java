package com.tattoo.code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Date: 2022-03-09 19:29
 * @Author: liushengxi
 * @Description: 两个线程交替打印AB
 */

class PrintA extends Thread {
    @Override
    public void run() {
        System.out.println("A");
    }
}

class PrintB extends Thread {
    @Override
    public void run() {
        System.out.println("B");
    }
}

public class PrintAAndB {
    private void printA() {

    }

    private void printB() {

    }

    private static final Object lock = new Object();
    public static Boolean flag = false;


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Object> futureTaskA = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws InterruptedException {
                while (true) {
                    synchronized (lock) {
                        if (!flag) {
                            // 调用后释放 lock 的对象监视器锁,然后阻塞等待被唤醒
                            lock.wait();
                        } else {
                            System.out.println("A");
                            flag = !flag;
                            lock.notify();
                        }
                    }
                }
            }
        });

        FutureTask<Object> futureTaskB = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws InterruptedException {
                while (true) {
                    synchronized (lock) {
                        if (flag) {
                            // 调用后释放 lock 的对象监视器锁,然后阻塞等待被唤醒
                            lock.wait();
                        } else {
                            System.out.println("B");
                            flag = !flag;
                            /**
                             * 该方法任意从 WAITTING 状态的线程中挑选一个进行通知，使得调用 wait()方法的线程从等待队列移入到同步队列中，
                             等待有机会再一次获取到锁，从而使得调用 wait()方法 的线程能够从 wait()方法处 退出。
                             调用 notify 后，当前线程不会马上释放该对象锁，要等到程序退出同步块后，当前线程才会释放锁。
                             */
                            lock.notify();
                        }
                    }
                }
            }
        });

        futureTaskA.run();
        futureTaskB.run();


//        // 1. 继承 Thread
//        FutureTask<Object> futureTask = new FutureTask<>(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                System.out.println("A");
//            }
//        }
//        );

        // 2. 继承 Thread
        // 2. 继承 Thread
    }
}
