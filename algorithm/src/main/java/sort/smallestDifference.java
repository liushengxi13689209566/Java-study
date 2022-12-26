package sort;

import java.util.Arrays;

/*
https://leetcode.cn/problems/smallest-difference-lcci/

面试题 16.06. 最小差
给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差



示例：

输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
输出：3，即数值对(11, 8)


提示：

1 <= a.length, b.length <= 100000
-2147483648 <= a[i], b[i] <= 2147483647
正确结果在区间 [0, 2147483647] 内
通过次数19,687提交次数45,773
# TODO 思路：
1.先排序：
1，2，3，11，15
8，19，23，127，235

然后找最小差
* */
public class smallestDifference {
    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            long res = Long.MAX_VALUE;
            for (int i = 0, j = 0; i < a.length && j < b.length; ) {
                if (a[i] == b[j]) return 0;
                long dif = a[i] - b[j];
                res = Math.min(Math.abs(dif), res);
                // a[i] <  b[j] 时
                if (dif < 0) {
                    i++;
                } else {
                    j++;
                }
            }
            return (int) res;
        }
    }
}
