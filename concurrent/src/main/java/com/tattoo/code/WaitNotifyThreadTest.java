package com.tattoo.code;

import lombok.SneakyThrows;

/**
 * @Date: 2022-03-09 20:43
 * @Author: liushengxi
 * @Description:
 */
public class WaitNotifyThreadTest {

    public static Boolean flag = true;
    public static int i = 0;
    public static Object lock = new Object();


    public static void main(String[] args) {
        Thread wait = new Thread(new WaitNotifyThreadTest.Wait());
        Thread notify = new Thread(new WaitNotifyThreadTest.Notify());
        wait.start();
        notify.start();
    }


    static class Wait implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            while (i < 10) {
                synchronized (lock) {
                    if (flag) {
                        lock.wait();
                    } else {
                        System.out.println("B");
                        flag = !flag;
                        i++;
                        lock.notify();
                    }
                }
            }
        }
    }


    static class Notify implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            while (i < 10) {
                synchronized (lock) {
                    if (!flag) {
                        lock.wait();
                    } else {
                        flag = !flag;
                        System.out.println("A");
                        i++;
                        lock.notify();
                    }
                }
            }
        }
    }
}
