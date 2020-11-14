package com.tattoo.codes.eight;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestGenericMethod {
    static <T> List<T> formArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
        return (List<T>) c;
    }

    public static void main(String[] args) {
        String[] oa = new String[10];
        Collection<String> co = new ArrayList<>();
        co.add("cdfcdc");
        co.add("33333");
        System.out.println(formArrayToCollection(oa, co));

        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
