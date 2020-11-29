package com.tattoo.codes.sixteen;

public class TestDraw {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("123456", 1000);
        new DrawThread("甲", account, 800).start();
//        Thread.sleep(200);
        new DrawThread("乙", account, 800).start();
    }
}
