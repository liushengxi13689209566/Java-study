/**
 * @Date: 2022-02-27 16:48
 * @Author: liushengxi
 * @Description:
 */
public class GenericTypes {
//    public static String method(List<String> list) {
//        System.out.println("invoke method(List<String> list)");
//        return "";
//    }
//
//    public static int method(List<Integer> list) {
//        System.out.println("invoke method(List<Integer> list)");
//        return 1;
//    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); //true
        System.out.println(e == f); //false
        //原因：321没有被缓存，==比较的是内存地址，所以为false，拓展出去：每一个new的对象使用==都是false
        System.out.println(c == (a + b)); //true
        System.out.println(c.equals(a + b)); //true

        System.out.println(g == (a + b)); //true
        System.out.println(g.equals(a + b)); //false
        //原因：equal 方法不处理数据转型
    }
}
