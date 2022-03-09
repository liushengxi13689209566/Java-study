/**
 * @Date: 2022-02-09 10:40
 * @Author: liushengxi
 * @Description:
 */
public class EscapeAnalysisDemo {
    private void fun() {
        TestObject testObject = new TestObject();
        outSideFun(testObject);
        System.out.println(testObject.toString());
    }

    private void outSideFun(TestObject testObject) {

    }
}
