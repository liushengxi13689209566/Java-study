package bit;

/*
https://leetcode.cn/problems/insert-into-bits-lcci/

面试题 05.01. 插入
给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。

编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。

题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。

示例1:
 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 输出：N = 1100(10001001100)

示例2:
 输入： N = 0, M = 31(11111), i = 0, j = 4
 输出：N = 31(11111)
通过次数14,650提交次数28,521
* */
public class insertBits {
    /*
    1、思路
    先将 N 的第 i ~ j 位全部置零；

    在将M左移i位，使之对其上一步中N置零的位，直接相加即可。
    * */
    class Solution {
        public int insertBits(int N, int M, int i, int j) {
            for (int k = i; k <= j; k++) {
                N &= ~(1 << k);
            }
            return N + (M << i); // 注意需要加上 括号
        }
    }
}
