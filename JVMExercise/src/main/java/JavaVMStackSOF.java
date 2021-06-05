/**
 * VM Args:-Xss128k * @author zzm
 * ·使用-Xss参数减少栈内存容量。
 * 结 果 : 抛 出 St a c k O v e r f l o w E r r o r 异 常 ， 异 常 出 现 时 输 出 的 堆 栈 深 度 相 应 缩 小 。
 */

public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
