package com.tattoo.codes.sixteen;

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
        synchronized (account) {
            if (account.getBalance() >= this.drawAmount) {
                System.out.println(getName() + "成功取钱 " + this.drawAmount);
         /*   try {
                Thread.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }*/
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("剩余的余额为" + account.getBalance());
            } else {
                System.out.println("余额不够，取不出来！！");
            }
        }
    }
}
