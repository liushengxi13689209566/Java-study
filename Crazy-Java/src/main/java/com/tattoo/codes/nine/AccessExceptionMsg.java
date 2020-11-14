package com.tattoo.codes.nine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;

public class AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("a.txxt");

        } catch (IOError | FileNotFoundException ioError) {
            System.out.println("vfjnfdvn");
            System.out.println(ioError.getMessage());
            ioError.printStackTrace();
        }
    }
}
