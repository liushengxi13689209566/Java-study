package com.tattoo.codes.fourteen;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注释可以保留多久
@Retention(RetentionPolicy.RUNTIME)
//注释能够修饰的目标
@Target(ElementType.FIELD)
public @interface ActionListenerFor {
    Class<? extends ActionListener> listener();
//    String listener();
}
