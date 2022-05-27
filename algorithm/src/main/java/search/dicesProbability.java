package search;


import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * <p>
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 限制：
 * 1 <= n <= 11
 * 思路：
 * （1）DFS 直接搜索，相当于是一个 n 行的 1~6 的二位数组
 * （2）动态规划：
 *   https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
 */
public class dicesProbability {
    class Solution01 {
        private static final double PROBABILITY = 1.0 / 6.0;
        private int dump_n = 0;

        public double[] dicesProbability(int n) {
            dump_n = n;
            // dfs
            // 1~6 1~6 1~6 1~6 ------ 1~6  n 个
            // 最小值 n 、最大值 6n
            // 排列组合数一共有：5n+1
            double res[] = new double[5 * n + 1];
            dfs(0, n, res);
            return res;
        }

        private void dfs(int sum, int n, double[] res) {
            if (n == 0) {
                res[sum - dump_n] += Math.pow(PROBABILITY, dump_n);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                dfs(sum + i, n - 1, res);
            }
        }
    }

    /**
     * 设输入 n  个骰子的解（即概率列表）为 f(n)  ，其中「点数和」 x 的概率为 f(n, x) 。
     * 那么 f(n,x) = f(n-1,x-1)*1/6
     *            + f(n-1,x-2)*1/6
     *            + f(n-1,x-3)*1/6
     *            + f(n-1,x-4)*1/6
     *            + f(n-1,x-5)*1/6
     *            + f(n-1,x-6)*1/6
     * 所以可看出：可以根据 n-1 找到 n
     * 根据等式变化可得：
     * 那么 f(n-1,x) 可向如下项贡献自己的概率
     *             f(n,x+1)
     *             f(n,x+2)
     *             f(n,x+3)
     *             f(n,x+4)
     *             f(n,x+5)
     *             f(n,x+6)
     */
    class Solution {
        public double[] dicesProbability(int n) {
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0 / 6.0);

            for (int i = 2; i <= n; i++) {
                // 最小值 n 、最大值 6n
                // 排列组合数一共有：5n+1
                double[] tmp = new double[5 * i + 1];

                for (int j = 0; j < dp.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        //这里记得是加上dp数组值与1/6的乘积，1/6是第i个骰子投出某个值的概率
                        tmp[j + k] += dp[j] / 6.0;
                    }
                }
                // 关键点
                dp = tmp;
            }
            return dp;
        }
    }
}
