package com.tattoo.codes.sixteen.sync;


public class DrawThread extends Thread {
    // 当前账户
    private Account account;
    //想要取的钱数
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }
}
