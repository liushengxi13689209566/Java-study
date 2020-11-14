package com.tattoo.codes.exception;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class TestTryCatch {
    public void throwException() throws Exception {
        throw new Exception("cfdc");
    }

    @Test
    public String test() throws Exception {
        String str = "111";
        try {
            throwException();
            return str;
        } catch (Exception e) {
            System.out.println("fdnjv dfk v");
            throw new Exception("吃的地方你能d");
        }
    }

    @Test
    public void cdsbchbdsc() throws Exception {
        try {
            System.out.println(test());
        } catch (Exception e) {
            System.out.println("fdbvhdf");
        }

    }
}
