package com.tattoo.codes.testTmp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class TestImmutableClass {
    private final int id;
    private final String type;
    private final Date date;

    public TestImmutableClass(int id, String type, Date date) {
        this.id = id;
        this.type = type;
        this.date = new Date(date.getTime()); // 深拷贝！！！防御性拷贝
    }
}

class test {
    @Test
    private void Test01() {
        List<TestImmutableClass> testImmutableClassList = new ArrayList<>();

    }
}
