package com.tattoo.codes.sixteen;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class Account_Lock {
    private final ReentrantLock lock = new ReentrantLock();
    //账户编号
    private String accountNo;
    //账户余额
    private double balance;

    public Account_Lock(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    //同步方法
    public synchronized void draw(double drawAmount) {
        lock.lock();

        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "成功取钱 " + drawAmount);
                balance -= drawAmount;
                System.out.println("剩余的余额为" + balance);
            } else {
                System.out.println("余额不够，取不出来！！");
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account_Lock account = (Account_Lock) o;
        return account.getAccountNo().equals(accountNo);
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
