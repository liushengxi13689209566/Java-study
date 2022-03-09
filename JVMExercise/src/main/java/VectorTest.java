import java.util.Vector;

// 绝对线程安全 之 Vector

/**
 * 尽管 这 里 使 用 到 的 Ve c t o r 的 g e t ( ) 、 r e m o v e ( ) 和 s i z e ( ) 方 法 都 是 同 步 的 ，
 * 但 是 在 多 线 程 的 环 境 中，如果不在方法调用端做额外的同步措施，使用这段代码仍然是不安全的。
 * 因为如果另一个线程恰 好在错误的时间里删除了一个元素，导致序号i已经不再可用，再用i访问数组就会抛出一个 ArrayIndexOutOfBoundsException异常。
 * 如果要保证这段代码能正确执行下去，我们不得不把
 * removeT hread和p rint T hread的定义改成代码清单13-3所示的这样
 * Thread removeThread = new Thread(new Runnable() { @Override
 * public void run() { synchronized (vector) {
 * } });
 * for (int i = 0; i < vector.size(); i++) { vector.remove(i);
 * } }
 * Thread printThread = new Thread(new Runnable() { @Override
 * public void run() { synchronized (vector) {
 * } });
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println((vector.get(i)));
                    }
                }
            });
            removeThread.start();
            printThread.start();
            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20) ;
        }
    }
}
