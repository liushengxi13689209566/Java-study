package dp;

import java.util.Arrays;

/**
 * 剑指 Offer II 103. 最少的硬币数目
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * https://leetcode-cn.com/problems/gaM7Ch/
 */
public class coinChange {
    public class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            // dp[i] 表示：组成金额 i 所需最少的硬币数量
            // 那么 dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
