package com.tattoo.codes.eighteen;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class GenericTest {
    private Map<String, Integer> score;

    public GenericTest() {
    }

    public static void main(String[] var0) throws Exception {
        Class var1 = GenericTest.class;
        Field var2 = var1.getDeclaredField("score");
        Class var3 = var2.getType();
        System.out.println("score的类型是:" + var3);
        Type var4 = var2.getGenericType();
        if (var4 instanceof ParameterizedType) {
            ParameterizedType var5 = (ParameterizedType) var4;
            Type var6 = var5.getRawType();
            System.out.println("原始类型是：" + var6);
            Type[] var7 = var5.getActualTypeArguments();
            System.out.println("泛型类型是:");

            for (int var8 = 0; var8 < var7.length; ++var8) {
                System.out.println("第" + var8 + "个泛型类型是：" + var7[var8]);
            }
        } else {
            System.out.println("获取泛型类型出错！");
        }

    }
}
