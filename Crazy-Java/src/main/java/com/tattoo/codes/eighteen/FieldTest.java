package com.tattoo.codes.eighteen;

import java.lang.reflect.Field;

public class FieldTest {
    public FieldTest() {
    }

    public static void main(String[] var0) throws Exception {
        Person var1 = new Person();
        Class var2 = Person.class;
        Field var3 = var2.getDeclaredField("name");
        var3.setAccessible(true);
        var3.set(var1, "bfgbfgbgf");
        Field var4 = var2.getDeclaredField("age");
        var4.setAccessible(true);
        var4.setInt(var1, 666);
        System.out.println(var1);
    }
}
