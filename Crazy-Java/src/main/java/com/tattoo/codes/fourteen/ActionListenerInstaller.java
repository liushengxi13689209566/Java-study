package com.tattoo.codes.fourteen;

import javax.swing.AbstractButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class ActionListenerInstaller {
    // 处理Annotation的方法，其中obj是包含Annotation的对象
    public static void processAnnotations(Object obj) {
        try {
            // 获取obj对象的类
            Class cl = obj.getClass();
            // 获取指定obj对象的所有Field，并遍历每个Field
            for (Field f : cl.getDeclaredFields()) {
                // 将指定Field设置成可自由访问。
                f.setAccessible(true);
                // 获取指定Field上ActionListenerFor类型的Annotation
                ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
                // 获取f Field实际对应的对象
                Object fObj = f.get(obj);
                // 如果f是AbstractButton的实例，且a不为null
                if (a != null && fObj != null
                        && fObj instanceof AbstractButton) {
                    // 获取a注释里的元数据listner（它是一个监听器类）
                    Class<? extends ActionListener> listenerClazz = a.listener();
                    // 使用反射来创建listner类的对象
                    ActionListener al = listenerClazz.getDeclaredConstructor().newInstance();
                    AbstractButton ab = (AbstractButton) fObj;
                    // 为ab按钮添加事件监听器
                    ab.addActionListener(al);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
