package com.tattoo.codes.eighteen;

public class YeeKuObjectFactor {
    public static Object getInstance(String clsName) {
        try {
            Class cls = Class.forName(clsName);

            return cls.getDeclaredConstructor().newInstance();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
