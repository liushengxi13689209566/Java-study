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


    class Solution {
        private int threeMax(int a, int b, int c) {
            int tmp = Math.max(a, b);
            return tmp > c ? tmp : c;
        }

        private int threeMin(int a, int b, int c) {
            int tmp = Math.min(a, b);
            return tmp < c ? tmp : c;
        }

        public int maxProduct(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int maxRes = nums[0];
            // 二维数组：因为可能存在 -2 ,3,3,3,3,-9  的情况
            //正的最大值
            int[] positiveMax = new int[nums.length];
            //负的最大值
            int[] negativeMax = new int[nums.length];

            positiveMax[0] = nums[0];
            negativeMax[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int x = positiveMax[i - 1] * nums[i];
                int y = negativeMax[i - 1] * nums[i];
                positiveMax[i] = this.threeMax(x, y, nums[i]);
                negativeMax[i] = this.threeMin(x, y, nums[i]);
                maxRes = positiveMax[i] > maxRes ? positiveMax[i] : maxRes;
            }
            return maxRes;
        }
    }


}
