package com.tattoo.codes.sixteen;

public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被Join的线程");
                jt.start();
                jt.join();
                System.out.println("kcdvljnsd");
            }
//            System.out.println("44444444444");
        }
    }
}
