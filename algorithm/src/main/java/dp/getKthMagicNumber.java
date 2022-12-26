package dp;

import java.util.TreeSet;

/*
https://leetcode.cn/problems/get-kth-magic-number-lcci/description/
https://leetcode.cn/problems/chou-shu-lcof/
剑指 offer: 丑数
面试题 17.09. 第 k 个数
中等
230
相关企业
有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

示例 1:

输入: k = 5

输出: 9
通过次数
45.1K
提交次数
79.9K
通过率
56.5%
请问您在哪类招聘中遇到此题？
1/5
思路：
一种直接使用 TreeSet
一种是：DP（）
* */
public class getKthMagicNumber {
    class Solution {
        // 1，3，5，7，9，15，21,25,27,35,45
        public int getKthMagicNumber01(int k) {
            if (k <= 0) {
                return 0;
            }
            TreeSet<Long> set = new TreeSet<>();
            Long res = null;
            set.add(1L);
            for (int i = 1; i <= k; i++) {
                res = set.pollFirst();
                set.add(res * 3);
                set.add(res * 5);
                set.add(res * 7);
            }
            return res.intValue();
        }

        // 1，3，5，7，9，15，21,25,27,35,45
        public int getKthMagicNumber(int k) {
            if (k <= 0) {
                return 0;
            }
            int[] dp = new int[k + 1];
            dp[1] = 1;
            int p3 = 1;
            int p5 = 1;
            int p7 = 1;
            // 从第二个数字开始
            for (int i = 2; i <= k; i++) {
                int num3 = dp[p3] * 3;
                int num5 = dp[p5] * 5;
                int num7 = dp[p7] * 7;
                //  三者中最小的一个就是：dp[i],无关具体数值
                dp[i] = Math.min(Math.min(num3, num5), num7);
                if (dp[i] == num3) {
                    p3++;
                }
                if (dp[i] == num5) {
                    p5++;
                }
                if (dp[i] == num7) {
                    p7++;
                }
            }
            return dp[k];
        }
    }
}
