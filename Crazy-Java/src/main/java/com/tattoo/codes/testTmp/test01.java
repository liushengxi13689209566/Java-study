package com.tattoo.codes.testTmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test01 {
    /**
     * @param args
     */

    public static void main(String[] args) {

//        Map<String, Object> context = new HashMap();
//
//        context.put("a", "aaa");
//
//        System.out.println(context.containsKey("a")); //输出true 既如果这个map集
//
//        System.out.println(context.containsKey("b")); //输出false 既没有就返回
//
//        System.out.println(context.containsKey(null)); //输出false 既没有就返回
        
        final List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("world");
        List<String> unmodifiableStrList = List.of("hello", "world");
        unmodifiableStrList.add("again");
    }
}
