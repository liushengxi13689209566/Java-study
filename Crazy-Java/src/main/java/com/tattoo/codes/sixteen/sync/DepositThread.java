package com.tattoo.codes.sixteen.sync;


public class DepositThread extends Thread {
    // 当前账户
    private Account account;
    //想要取的钱数
    private double depositAmount;

    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
