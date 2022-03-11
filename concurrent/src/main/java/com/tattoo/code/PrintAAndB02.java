package com.tattoo.code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2022-03-09 20:43
 * @Author: liushengxi
 * @Description: 使用对象自身的监视锁 实现
 */
public class PrintAAndB02 {


    // 当前状态值：保证三个线程之间交替打印
    private int num;
    private Lock lock = new ReentrantLock();

    private void printABC(int aim) {
        for (int i = 0; i < 10; ) {
            lock.lock();
            if (num % 3 == aim) {
                i++;
                num++;
                System.out.println(Thread.currentThread().getName());
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintAAndB02 printABC_lock = new PrintAAndB02();
        new Thread(() -> {
            printABC_lock.printABC(0);
        }, "A").start();
        new Thread(() -> {
            printABC_lock.printABC(1);
        }, "B").start();
        new Thread(() -> {
            printABC_lock.printABC(2);
        }, "C").start();
    }
}
