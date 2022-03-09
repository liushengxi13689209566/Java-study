package Instance;

/**
 * @Date: 2022-03-08 10:13
 * @Author: liushengxi
 * @Description:
 */
public class HungryInstance {
    /**
     * 单例模式，饿汉式，线程安全 【推荐】
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例模式，使用静态内部类，线程安全【推荐】
     * <p>
     * 可以做到：延迟加载
     * <p>
     * 原因：
     * SingletonHolder 是一个静态内部类，
     * 当 外部类 IdGenerator 被加载的时候，并不会创建 SingletonHolder 实例对象。只有当调用 getInstance() 方法时，SingletonHolder 才会被加载，
     * 这个时候才会创建 instance。instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载。
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {
        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用 枚举 方式，线程安全【推荐】
     */
    public enum Singleton6 {
        INSTANCE;

        public void whateverMethod() {
        }
    }


    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
    }
}
