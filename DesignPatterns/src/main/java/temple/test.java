package temple;


/**
 * @Date: 2022-03-13 23:01
 * @Author: liushengxi
 * @Description:
 */
public class test {

}

public abstract class AbstractClass {
    // 1. 有些方法又严禁子类实现
    public final void templateMethod() {
        //...
        method1();
        //...
        method2();
        //...
    }

    // 2. 有些逻辑父类做不了主，就交给子类，强迫子类去实现。
    protected abstract void method1();

    //3. 父类实现一些公用的逻辑
    private void parentFun() {
        System.out.println("parent function");
        System.out.println("step 1 ");
        System.out.println("step 2 ");
        System.out.println("step 3 ");
        //4. 有些逻辑再直接交给子类去做，父类直接定义逻辑模板
        method1();
    }

    protected abstract void method2();

    // 5. 有些逻辑父类可以做一部分，最做的就做，但是最好是由子类实现。
    protected void setUp() throws Exception {
        // 父类设置
    }
}

public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void method1() {
        //...
    }

    @Override
    protected void method2() {
        //...
    }
}

public class ConcreteClass2 extends AbstractClass {
    @Override
    protected void method1() {
        //...
    }

    @Override
    protected void method2() {
        //...
    }
}

    AbstractClass demo = ConcreteClass1();
    demo.templateMethod();
