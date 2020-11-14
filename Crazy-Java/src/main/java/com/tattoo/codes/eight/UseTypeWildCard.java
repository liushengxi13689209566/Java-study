package com.tattoo.codes.eight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UseTypeWildCard {
    public void test(List<?> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }

    @Test
    public void main() {
        List<String> stringList = new ArrayList<>();
        stringList.add("cfencln");
        stringList.add("fnjnvfv");
        stringList.add("111111");
        test(stringList);
    }
}
