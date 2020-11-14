package com.tattoo.codes.sixteen;

public class FristThread extends Thread {
    private int i;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new FristThread().start();
                new FristThread().start();
            }
        }
    }
}
