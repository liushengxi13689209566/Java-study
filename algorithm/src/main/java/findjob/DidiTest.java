package findjob;

import java.util.List;

/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
示例 1：

输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：

输入：triangle = [[-10]]
输出：-10
* */
public class DidiTest {
    int minPath = Integer.MAX_VALUE;

    public int test(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int n = triangle.size();
        // 最小路径
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        // 初始化第一列（只能从上一行的第一列下来）
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        // 初始化对角线（只能从上一行的左上角下来）
        for (int i = 1; i < n; i++) {
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        // 填充 dp 表
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        // 找到最后一行的最小值
        for (int i = 0; i < n; i++) {
            minPath = Math.min(minPath, dp[n - 1][i]);
        }
        return minPath;
    }
}
