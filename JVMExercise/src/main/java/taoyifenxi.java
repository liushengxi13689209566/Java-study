/**
 * @Date: 2022-02-28 11:38
 * @Author: liushengxi
 * @Description:
 */
public class taoyifenxi {
    public void fun01(Integer i) {

    }

    public void main(String[] args) {
        Integer a = 10;
        // 方法逃逸
        fun01(a);

        new Thread()->{
            a
        }
    }
}
