package dp;

/* https://leetcode.cn/problems/the-masseuse-lcci/
* 面试题 17.16. 按摩师

一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

注意：本题相对原题稍作改动



示例 1：

输入： [1,2,3,1]
输出： 4
解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。

示例 2：

输入： [2,7,9,3,1]
输出： 12
解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。

示例 3：

输入： [2,1,4,5,3,1,1,3]
输出： 12
解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
* */
public class massage {
    class Solution {
        public int massage(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            int len = nums.length;
            // dp[i][2] i 表示到 i 处所获得的最优, i的范围是: 0->n
            // 另外两个维度表示：0：接  || 1：不接
            int[][] maxPro = new int[len][2];
            maxPro[0][0] = nums[0];
            maxPro[0][1] = 0;
            for (int i = 1; i < len; i++) {
                // 当天接受预约 = 前一天 不接受预约 的最大值（因为其前一天一定没有被预约）
                maxPro[i][0] = maxPro[i - 1][1] + nums[i];
                // 当天不接受预约 = 前一天接受/不接受 的最大值
                maxPro[i][1] = Math.max(maxPro[i - 1][0], maxPro[i - 1][1]);
            }
            return Math.max(maxPro[len - 1][0], maxPro[len - 1][1]);
        }
    }

    class Solution03 {
        public int massage(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            int len = nums.length;
            int maxPro_i_0 = nums[0];
            int maxPro_i_1 = 0;
            for (int i = 1; i < len; i++) {
                // 当天接受预约 = 前一天 不接受预约 的最大值（因为其前一天一定没有被预约）
                int tpMaxPro_i_0 = maxPro_i_1 + nums[i];
                // 当天不接受预约 = 前一天接受/不接受 的最大值
                int tpMaxPro_i_1 = Math.max(maxPro_i_0, maxPro_i_1);
                maxPro_i_0 = tpMaxPro_i_0;
                maxPro_i_1 = tpMaxPro_i_1;
            }
            return Math.max(maxPro_i_0, maxPro_i_1);
        }
    }

    class Solution02 {
        public int massage(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            /*
    直接定义dp[i}表示考虑前i个预约的最长预约时间，dp[i]包含两种情况:

    .接受第i个预约，则不能接受第i-1个预约，即预约时间为考虑第i-2个预约的最长时间dp[i-2] + 第i个预约的时间nums[i]

    有序列表不接受第i个预约，则可以接受第i-1个预约，即预约时间为考虑第i-1个预约的最长时间dp[i-1]

    所以dp[i]只可能是这两种情况的最大值，即状态转移方程

    dp[i] = max( dp[i-2] + nums[i], dp[i-1])

            * */
            // dp[i] i 表示预约请求的最大时长
            int[] maxPro = new int[len];
            maxPro[0] = nums[0];
            maxPro[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                maxPro[i] = Math.max(maxPro[i - 1], maxPro[i - 2] + nums[i]); // 不接受 ｜｜ 接受
            }
            return maxPro[len - 1];
        }
    }
}
