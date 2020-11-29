package com.tattoo.codes.eighteen;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassTest {
    private ClassTest() {
    }

    public ClassTest(String var1) {
        System.out.println("执行有参数的构造器");
    }

    public void info() {
        System.out.println("执行无参数的info方法");
    }

    public void info(String var1) {
        System.out.println("执行有参数的info方法，其str参数值：" + var1);
    }

    public static void main(String[] var0) throws Exception {
        Class var1 = ClassTest.class;
        Constructor[] var2 = var1.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造器如下：");
        Constructor[] var3 = var2;
        int var4 = var2.length;

        int var5;
        for (var5 = 0; var5 < var4; ++var5) {
            Constructor var6 = var3[var5];
            System.out.println(var6);
        }

        var3 = var1.getConstructors();
        System.out.println("ClassTest的全部public构造器如下：");
        Constructor[] var11 = var3;
        var5 = var3.length;

        int var14;
        for (var14 = 0; var14 < var5; ++var14) {
            Constructor var7 = var11[var14];
            System.out.println(var7);
        }

        Method[] var12 = var1.getMethods();
        System.out.println("ClassTest的全部public方法如下：");
        Method[] var13 = var12;
        var14 = var12.length;

        int var16;
        for (var16 = 0; var16 < var14; ++var16) {
            Method var8 = var13[var16];
            System.out.println(var8);
        }

        System.out.println("ClassTest里带一个字符串参数的info方法为：" + var1.getMethod("info", String.class));
        Annotation[] var15 = var1.getAnnotations();
        System.out.println("ClassTest的全部Annotation如下：");
        Annotation[] var17 = var15;
        var16 = var15.length;

        int var19;
        for (var19 = 0; var19 < var16; ++var19) {
            Annotation var9 = var17[var19];
            System.out.println(var9);
        }

        System.out.println("该Class元素上的@SuppressWarnings注释为：" + var1.getAnnotation(SuppressWarnings.class));
        Class[] var18 = var1.getDeclaredClasses();
        System.out.println("ClassTest的全部内部类如下：");
        Class[] var20 = var18;
        var19 = var18.length;

        for (int var22 = 0; var22 < var19; ++var22) {
            Class var10 = var20[var22];
            System.out.println(var10);
        }

        Class var21 = Class.forName("ClassTest$Inner");
        System.out.println("inClazz对应类的外部类为：" + var21.getDeclaringClass());
        System.out.println("ClassTest的包为：" + var1.getPackage());
        System.out.println("ClassTest的父类为：" + var1.getSuperclass());
    }

}
