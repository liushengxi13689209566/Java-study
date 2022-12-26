package dp;

/*
https://leetcode.cn/problems/burst-balloons/

312. 戳气球
有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。戳破第 l 个气球，你可以获得 nums[l - 1] * nums[l] * nums[l + 1] 枚硬币。 这里的 l - 1 和 l + 1 代表和 l 相邻的两个气球的序号。如果 l - 1或 l + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。

求所能获得硬币的最大数量。

示例 1：
输入：nums = [3,1,5,8]
输出：167
解释：
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
示例 2：

输入：nums = [1,5]
输出：10


提示：

n == nums.length
1 <= n <= 300
0 <= nums[l] <= 100
通过次数89,295提交次数128,011


题解：https://leetcode.cn/problems/burst-balloons/solution/zhe-ge-cai-pu-zi-ji-zai-jia-ye-neng-zuo-guan-jian-/
* */
public class maxCoins {
    class Solution {
        public int maxCoins(int[] nums) {
            int length = nums.length;
            if (length <= 0) {
                return 0;
            }
            int[] val = new int[length + 2];
            val[0] = val[length + 1] = 1;
            for (int l = 0; l < length; l++) {
                val[l + 1] = nums[l];
            }
            int[][] dp = new int[length + 2][length + 2];
            // len 表示开区间长度（对每一个区间长度进行循环）
            for (int len = 3; len <= length + 2; len++) {
                // l 表示开区间左端点 , l + len - 1 则表示开区间右端点
                for (int l = 0; l <= length + 2 - len; l++) {
                    // k 为开区间内的索引（代表区间最后一个被戳破的气球）
                    for (int k = l + 1; k < l + len - 1; k++) {
                        int left = dp[l][k];
                        int right = dp[k][l + len - 1];
                        int sum = left + right + val[l] * val[k] * val[l + len - 1];
                        dp[l][l + len - 1] = Math.max(dp[l][l + len - 1], sum);
                    }
                }
            }
            return dp[0][length + 1];
        }
    }
}
