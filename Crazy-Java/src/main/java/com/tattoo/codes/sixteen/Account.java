package com.tattoo.codes.sixteen;

import lombok.Data;

@Data
public class Account {
    //账户编号
    private String accountNo;
    //账户余额
    private double balance;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    //同步方法
    public synchronized void draw(double drawAmount) {
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName() + "成功取钱 " + drawAmount);
            balance -= drawAmount;
            System.out.println("剩余的余额为" + balance);
        } else {
            System.out.println("余额不够，取不出来！！");
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
