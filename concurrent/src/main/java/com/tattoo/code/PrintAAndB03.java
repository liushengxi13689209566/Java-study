package com.tattoo.code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date: 2022-03-09 20:43
 * @Author: liushengxi
 * @Description: 使用 lock+Condition 实现
 */
public class PrintAAndB03 {
    private int num = 0;
    private ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();

    private void printABC(int aim, Condition curThread, Condition nextThread) {
        for (int i = 0; i < 3; ) {
            lock.lock();
            try {
                while (num % 2 != aim) {
                    //阻塞当前线程
                    curThread.await();
                }
                System.out.println(Thread.currentThread().getName());
                num++;
                i++;
                //唤醒下一个线程，而不是唤醒所有线程
                nextThread.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintAAndB03 printABC_lock = new PrintAAndB03();
        new Thread(() -> {
            printABC_lock.printABC(0, printABC_lock.conditionA, printABC_lock.conditionB);
        }, "A").start();
        new Thread(() -> {
            printABC_lock.printABC(1, printABC_lock.conditionB, printABC_lock.conditionA);
        }, "B").start();
    }
}
