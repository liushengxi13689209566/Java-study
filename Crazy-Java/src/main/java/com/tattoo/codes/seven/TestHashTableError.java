package com.tattoo.codes.seven;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

class A {
    public int count;

    public A(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return count == a.count;
    }

    @Override
    public int hashCode() {
        return this.count;
    }

    @Override
    public String toString() {
        return "A{" +
                "count=" + count +
                '}';
    }
}

public class TestHashTableError {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put(new A(60000), "structs权威指南");
        ht.put(new A(87563), "轻量级 J2EE实战");

//        for (Object entry : ht.entrySet()) {
//
//        }
        Iterator it = ht.keySet().iterator();
        A frist = (A) it.next();
        frist.count = 87563;
        System.out.println(ht);

        ht.remove(new A(87563));
        System.out.println(ht);
        
        System.out.println(ht.get(new A(87563)));
        System.out.println(ht.get(new A(60000)));
    }
}
