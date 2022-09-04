package mianshixianchang;

import lombok.SneakyThrows;
import lombok.Synchronized;

/**
 * （1）循环打印 奇偶数
 * 线程1 偶数: 10
 * 线程2 奇数: 9
 * 线程1 偶数: 8
 * 线程2 奇数: 7
 * 线程1 偶数: 6
 * 线程2 奇数: 5
 * 线程1 偶数: 4
 * 线程2 奇数: 3
 * 线程1 偶数: 2
 * 线程2 奇数: 1
 * 线程1 偶数: 0
 */
public class TestBigo {
    private static boolean flag = false;
    private static int i = 10;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread A = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (i > 0) {
                    synchronized (lock) {
                        if (flag) {
                            lock.wait();
                        } else {
                            System.out.println("线程 1：偶数：" + i);
                            i--;
                            flag = !flag;
                            lock.notify();
                        }
                    }
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (i > 0) {
                    synchronized (lock) {
                        if (!flag) {
                            lock.wait();
                        } else {
                            System.out.println("线程 2：奇数：" + i);
                            i--;
                            flag = !flag;
                            lock.notify();
                        }
                    }
                }
            }
        });
        A.start();
        B.start();
    }
}
