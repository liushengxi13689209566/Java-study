package com.tattoo.codes.fourteen;

import java.lang.annotation.Annotation;

public class getAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] annotations = Class.forName("com.tattoo.codes.fourteen.MyClass").getMethod("info").getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println("Annotation cdd");

        MyClass myClass = new MyClass();
        Annotation[] annotations1 = myClass.getClass().getMethod("info").getAnnotations();
        for (Annotation annotation : annotations1) {
            if (annotation instanceof MyTag) {
                System.out.println("MyTag");
                System.out.println("name ==" + ((MyTag) annotation).name());
                System.out.println("age == " + ((MyTag) annotation).age());
            }
        }
    }
}
