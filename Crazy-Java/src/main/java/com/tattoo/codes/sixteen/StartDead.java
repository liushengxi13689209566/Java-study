package com.tattoo.codes.sixteen;

public class StartDead extends Thread {
    private int i;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        StartDead sd = new StartDead();
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 20) {
                sd.start();
                System.out.println(sd.isAlive());
            }
            if (i > 20 && !sd.isAlive()) {
                sd.start();
            }
        }
    }
}
