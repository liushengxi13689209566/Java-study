package dp;

/**
 * @Date: 2022-03-07 23:25
 * @Author: liushengxi
 * @Description:
 */
public class maxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null) {
                return 0;
            }
            // dp[i][2] i 表示到 i 处所获得的最大利润, i的范围是: 0->n
            // 另外两个维度表示：0：持股 1：不持股
            int[][] maxPro = new int[prices.length][2];

            // 持股话利润就是 负的 prices[0]
            maxPro[0][0] = -prices[0];
            // 不持股的话利润就是 0
            maxPro[0][1] = 0;

            int maxRes = 0;
            for (int i = 1; i < prices.length; i++) {
                // 求今天 需持股时的最大利润（两种选择：买入 或 等待）
                maxPro[i][0] = Math.max(maxPro[i - 1][1] - prices[i], maxPro[i - 1][0]);
                // 求今天 不持股时的最大利润（两种选择：卖出 或 等待）
                maxPro[i][1] = Math.max(maxPro[i - 1][0] + prices[i], maxPro[i - 1][1]);
                maxRes = maxPro[i][0] > maxPro[i][1] ? maxPro[i][0] : maxPro[i][1];
            }
            return maxRes;
        }
    }


}
