package dp;

/**
 * 剑指 Offer II 102. 加减的目标值
 * 给定一个正整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class findTargetSumWays {
    class Solution {
        // dfs() 搜索
        public int findTargetSumWays(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }
            int len = nums.length;
            if (len <= 0) {
                return -1;
            }
            goalLen = len;
            dfs(0, nums, nums[0], target);
            dfs(0, nums, -nums[0], target);
            return res;
        }

        private int res = 0;
        private int goalLen = 0;

        private void dfs(int index, int[] nums, int sum, int target) {
            if (index == (goalLen - 1)) {
                if (sum == target) {
                    res++;
                    return;
                }
            } else {
                dfs(index + 1, nums, sum + nums[index + 1], target);
                dfs(index + 1, nums, sum - nums[index + 1], target);
            }
        }
    }

    class Solution02 {
        // DP 动态规划（二维的动态规划问题！！！）
        class Solution {
            /**
             * 记数组的元素和为 sum，添加 - 号的元素之和为 neg，则其余添加 + 的元素之和为 sum−neg ，得到的表达式的结果为
             * (sum−neg)−neg = sum−2⋅neg =  target
             * neg = (sum-target) / 2
             */
            public int findTargetSumWays(int[] nums, int target) {
                int sum = 0;
                for (int num : nums) {
                    sum += num;
                }
                int diff = sum - target;
                if (diff < 0 || diff % 2 != 0) {
                    return 0;
                }
                int n = nums.length, neg = diff / 2;
                /**
                 dp[i][j] 表示在数组 nums 的前 i 个数中选取元素，使得这些元素之和等于 j 的方案数
                 假设数组 nums 的长度为 n，则最终答案为 dp[n][neg]
                 动态规划方程是：
                 */
                int[][] dp = new int[n + 1][neg + 1];
                dp[0][0] = 1;
                for (int i = 1; i <= n; i++) {
                    int num = nums[i - 1];
                    for (int j = 0; j <= neg; j++) {
                        dp[i][j] = dp[i - 1][j];
                        if (j >= num) {
                            dp[i][j] += dp[i - 1][j - num];
                        }
                    }
                }
                return dp[n][neg];
            }
        }
    }
}

