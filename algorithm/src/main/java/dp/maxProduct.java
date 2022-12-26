package dp;

/**
 * @Date: 2022-03-06 17:48
 * @Author: liushengxi
 * @Description:
 */
public class maxProduct {
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int maxRes = nums[0];
            // 二维数组：因为可能存在 -2 ,3,3,3,3,-9  的情况
            // col1 : 正数
            // col2 : 负数
            int[][] dp = new int[nums.length][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    dp[i][0] = dp[i - 1][0] * nums[i];
                } else {
                    dp[i][1] = dp[i - 1][1] * nums[i];
                }
                System.out.println("maxRes == " + maxRes);
                System.out.println("dp[i] == " + dp[i]);
                System.out.println("dp[i-1] == " + dp[i - 1]);

                maxRes = dp[i][0] > dp[i][1] ? dp[i][0] : dp[i][1];
            }
            return maxRes;
        }
    }
}
