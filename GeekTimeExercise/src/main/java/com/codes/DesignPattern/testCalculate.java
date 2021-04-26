package com.codes.DesignPattern;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testCalculate {
    public static void main(String[] args) throws InterruptedException {
        //L1、L2阶段共用的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        CountDownLatch l1 = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            System.out.println("L1");
            es.execute(() -> {
                CountDownLatch l2 = new CountDownLatch(2);
                for (int j = 0; j < 2; j++) {
                    es.execute(() -> {
                        System.out.println("L2");
                        l2.countDown();
                    });
                }
                try {
                    l2.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                l1.countDown();
            });
        }
        l1.await();
        System.out.println("end.......");
    }
}
