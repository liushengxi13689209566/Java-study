package dp;



/*

* */
public class minPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[] dp = new int[n];
            dp[0] = grid[0][0];

            // 初始化第一行：只能从左向右走
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + grid[0][j];
            }

            // 计算后续行
            for (int i = 1; i < m; i++) {
                dp[0] += grid[i][0]; // 每行的第一列只能从上向下走

                for (int j = 1; j < n; j++) {
                    // 取上方和左方的最小值
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }

            return dp[n - 1];
        }
    }
}
