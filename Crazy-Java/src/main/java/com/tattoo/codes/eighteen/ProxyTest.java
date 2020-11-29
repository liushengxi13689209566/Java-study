package com.tattoo.codes.eighteen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface PP {
    void walk();

    void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法是 :" + method);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("参数为空！！");
        }
        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        PP p = (PP) Proxy.newProxyInstance(PP.class.getClassLoader()
                , new Class[]{PP.class}, handler);
        p.sayHello("hahaha");
        p.walk();
    }
}
