package Instance;

/**
 * @Date: 2022-03-08 11:34
 * @Author: liushengxi
 * @Description: 懒加载
 */
public class LazyInstance {
    /**
     * 单例模式，懒汉式，线程不安全
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;

        private Singleton2() {
        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，线程安全，多线程环境下效率不高
     */
    public static class Singleton3 {
        private static Singleton3 instance = null;

        private Singleton3() {
        }
        // 这里直接串行化了
        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，变种，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;

        // static 过程保证线程安全
        static {
            instance = new Singleton4();
        }

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 静态内部类，使用双重校验锁 (DCL)，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;

        private Singleton7() {
        }

        public static Singleton7 getInstance() {
            if (instance == null) {
                // 类级别的 锁
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }
}
