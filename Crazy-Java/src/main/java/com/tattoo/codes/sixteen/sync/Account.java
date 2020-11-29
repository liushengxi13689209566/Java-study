package com.tattoo.codes.sixteen.sync;

import lombok.Data;

@Data
public class Account {
    //账户编号
    private String accountNo;
    //账户余额
    private double balance;

    //true : 表示有人存钱进去
    private boolean tag = false;


    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    //取钱
    public synchronized void draw(double drawAmount) {
        try {
            if (!tag) {
                wait();
            }
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "成功取钱 " + drawAmount);
                balance -= drawAmount;
                System.out.println("剩余的余额为" + balance);
                tag = false;
                notifyAll();
            } else {
                System.out.println("余额不够，取不出来！！");
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    //存款
    public synchronized void deposit(double depositAmount) {
        try {
            if (tag) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + "成功存款 " + depositAmount);
            balance += depositAmount;
            System.out.println("剩余的余额为" + balance);
            tag = true;
            notifyAll();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;
        return account.getAccountNo().equals(accountNo);
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
