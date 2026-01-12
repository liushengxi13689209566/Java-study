package other;


/*
https://leetcode.cn/problems/qiu-12n-lcof/
* */
public class mechanicalAccumulator {
    class Solution {
        public int mechanicalAccumulator(int target) {
//以逻辑运算符 && 为例，对于 A && B 这个表达式，如果 A 表达式返回 False ，
// 那么 A && B 已经确定为 False ，此时不会去执行表达式 B。同理，
// 对于逻辑运算符 ||， 对于 A || B 这个表达式，如果 A 表达式返回 True ，那么 A || B 已经确定为 True ，此时不会去执行表达式 B。
            boolean flag = target > 0 && (target += mechanicalAccumulator(target - 1)) > 0;
            return target;
        }
    }
}
