package com.tattoo.codes.eighteen;

import java.util.Date;

public class YeeKuObjectFactor2 {
    public static <T> T getInstance(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Date date = YeeKuObjectFactor2.getInstance(Date.class);

    }
}
