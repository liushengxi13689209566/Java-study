package com.tattoo.code;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Date: 2022-03-09 20:43
 * @Author: liushengxi
 * @Description: 使用对象自身的监视锁 实现
 */
public class PrintAAndB01 {

    public static Boolean flag = true;
    // 控制循环次数
    public static int i = 0;
    public static Object lock = new Object();


    public static void main(String[] args) {
        FutureTask<Object> futureTaskA = new FutureTask<>(new PrintA());
        FutureTask<Object> futureTaskB = new FutureTask<>(new PrintB());
        new Thread(futureTaskA, "线程A").start();
        new Thread(futureTaskB, "线程B").start();
    }


    static class PrintA implements Callable {
        @Override
        public Object call() throws Exception {
            while (i < 10) {
                synchronized (lock) {
                    if (flag) {
                        // 调用 wait后 释放 lock 的对象监视器锁,然后阻塞等待被 notify 唤醒
                        lock.wait();
                    } else {
                        System.out.println(Thread.currentThread().getName() + "------ A");
                        flag = !flag;
                        i++;
                        lock.notify();
                    }
                }
            }
            return null;
        }
    }

    static class PrintB implements Callable {
        @Override
        public Object call() throws Exception {
            while (i < 10) {
                synchronized (lock) {
                    if (!flag) {
                        lock.wait();
                    } else {
                        flag = !flag;
                        System.out.println(Thread.currentThread().getName() + "------ B");
                        i++;
                        lock.notify();
                    }
                }
            }
            return null;
        }
    }
}
