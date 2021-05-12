package com.codes.DesignPattern;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class print_qq {
    public static void main(String[] args) {

/*        int a = 23;
        ImmutableList<Integer> list = ImmutableList.of(a, 12);
        System.out.println(list);
        a = 232;
        System.out.println(list);

        List<String> list02 = Lists.newArrayList("a", "b", "c", "d");

        //1、正常遍历
        list02.forEach(item -> System.out.println(item));
        //2、根据条件遍历
        list02.forEach(item -> {
            if ("b".equals(item)) {
                System.out.println(item);
            }
        });*/


        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.submit(() -> {
            try {
                String qq = pool.submit(() -> "QQ").get();
                System.out.println(qq);
            } catch (Exception e) {
            }
        });
    }
}
