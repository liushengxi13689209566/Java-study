package com.tattoo.codes.fourteen;

import java.lang.reflect.Method;

public class TestProcessor {
    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        for (Method m : Class.forName(clazz).getMethods()) {
            if (m.isAnnotationPresent(Testable.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Exception exception) {
                    System.out.println("方法：" + m + "运行异常 ：" + exception.getMessage());
                    failed++;
                }
            }
        }
        System.out.println("psss: " + passed);
        System.out.println("failed: " + failed);
    }
}
