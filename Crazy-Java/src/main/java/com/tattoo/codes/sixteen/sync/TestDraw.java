package com.tattoo.codes.sixteen.sync;


public class TestDraw {
    public static void main(String[] args) throws InterruptedException {

        Account account = new Account("123456", 0);

        new DepositThread("存钱者", account, 800).start();
        new DrawThread("甲", account, 800).start();
        new DrawThread("乙", account, 800).start();
    }
}
