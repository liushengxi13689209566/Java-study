package com.tattoo.codes.nine;

import java.util.Arrays;
import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("rand.nextBoolean():" + rand.nextBoolean());

        byte[] buffer = new byte[16];
        rand.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));

        System.out.println("rand.nextDouble() : " + rand.nextDouble());
        System.out.println("rand.() : " + rand.nextFloat());
        System.out.println("rand.() : " + rand.nextInt(26));
        System.out.println("rand.() : " + rand.nextLong());
    }
}
