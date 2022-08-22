import com.google.common.collect.Lists;

import java.util.*;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 思路：
 * （1）暴力解法肯定会超时
 * "horse"
 * "ros"
 * "pale"
 * "ple"
 * "pales"
 * "pal"
 * "inten tion"
 * "execu tion"
 */
public class Temp {
    static class Solution {
        public int massage(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }
            int len = nums.length;
            // dp[i][2] i 表示到 i 处所获得的最优, i的范围是: 0->n
            // 另外两个维度表示：0：接  || 1：不接
            int[][] maxPro = new int[len][2];
            int result = nums[0];
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

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
//        solution.subSort(new int[]{1, 3, 9, 7, 5});
    }
}

