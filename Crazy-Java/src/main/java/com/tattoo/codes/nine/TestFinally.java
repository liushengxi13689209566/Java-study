package com.tattoo.codes.nine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestFinally {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {

            fis = new FileInputStream("ncdfnj");

        } catch (FileNotFoundException e) {
            System.out.println("lishengxi jvfdnkvf");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
//            System.exit(1);
        } finally {
            System.out.println("fin fjbvhfdbvbfdjkbvkjdfbv");
        }
    }
}
