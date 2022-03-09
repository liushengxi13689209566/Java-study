package com.tattoo.code;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Date: 2022-02-10 10:13
 * @Author: liushengxi
 * @Description:
 */
public class CglibProxyTest {
    public static void main(String[] args) {
//目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
    }
}

//需要被代理的类：不需要实现接口
class UserDao {
    public void save() {
        System.out.println("保存数据");
    }
}

/**
 * 拦截类完成类似于jdk动态代理中的 InvocationHandler 的功能, 不过是通过动态生成字节码技术实现!
 * 可以类比于jdk动态代理中的 InvocationHandler, 实际上被代理后重要的类!
 * <p>
 * 实际上后续执行的就是 intercep t里的方法;
 * <p>
 * 如果需要执行原来的方法，则调用 method.invoke(s, args);
 */
class ProxyFactory implements MethodInterceptor {
    private Object target;//维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }
}
