package com.tattoo.codes.eight;

import java.util.ArrayList;
import java.util.List;

public class Apple<T> {
    private T info;

    public Apple() {
    }

    public Apple(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "info=" + info +
                '}';
    }

    public static void main(String[] args) {
//        Apple<String> a1 = new Apple<>("kcfbdhvcds");
//        System.out.println(a1);
//        Apple<Double> d1 = new Apple<>(77878.8756567);
//        System.out.println(d1);

        List<String> str1 = new ArrayList<>();
        List<Integer> int1 = new ArrayList<>();
        System.out.println(str1.getClass() == int1.getClass());

        return;
    }
}
