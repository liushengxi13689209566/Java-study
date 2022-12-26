package dp;

/*
面试题 17.06. 2出现的次数
编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
示例:
输入: 25
输出: 9
解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
提示：
n <= 10^9

TODO: 数位 DP
* */
public class numberOf2sInRange {
    class Solution {
        public int numberOf2sInRange(int n) {
            //判断几位数 && 第一位数字是多少
            int digits = 0;
            int firstNumber = 0;
            int dump = n;
            // 123
            while (dump != 0) {
                firstNumber = dump;
                digits++;
                dump = dump / 10;
            }
            // 有问题代码
            return firstNumber < 2 ? (digits - 1) * 10 + 1 : (digits - 1) * 10;
        }
    }
}
