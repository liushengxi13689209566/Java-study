package com.tattoo.codes.eighteen.DynaProxy;

public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("我是一只狗");
    }

    @Override
    public void run() {
        System.out.println("我在奔跑");
    }
}
