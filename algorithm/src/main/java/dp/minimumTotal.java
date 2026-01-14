package dp;

import java.util.List;

/**
 * @Date: 2022-03-05 23:31
 * @Author: liushengxi
 * 题目链接：https://leetcode.cn/problems/IlPe0q/
 * @Description: 剑指 Offer II 100. 三角形中最小路径之和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * 进阶：
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * 注意：本题与主站 120 题相同： https://leetcode-cn.com/problems/triangle/¬
 */
public class minimumTotal {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            /**
             先下向上进行状态递推。
             对应的数值表示：到达该点的最小路径和
             从 倒数第二行 开始，因为倒数第一行就是它本身
             */
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    Integer current = triangle.get(i).get(j);
                    // 正下方
                    Integer xiaFang = triangle.get(i + 1).get(j);
                    // 斜下方
                    Integer xieXiafang = triangle.get(i + 1).get(j + 1);
                    // 状态转移方程
                    current = current + Math.min(xieXiafang, xiaFang);

                    List<Integer> tmp = triangle.get(i);
                    tmp.set(j, current);
                    triangle.set(i, tmp);
                }
            }
            return triangle.get(0).get(0);
        }
        // 不修改输入值 的 实现
/*状态定义：dp[j] = “从当前行第 j 列出发，到达底边的最小路径和”。

状态转移：dp[j] = 当前节点值 + min(下一层左子路径和, 下一层右子路径和)。

初始化：dp 初始化为三角形最后一行。

计算顺序：从下往上，从左往右。

最终答案：递推结束后，dp[0] 即为所求。 */
//        public int minimumTotal(List<List<Integer>> triangle) {
//            if (triangle == null || triangle.size() == 0) {
//                return 0;
//            }
//
//            int n = triangle.size();
//            // dp数组：表示从当前行的每个位置到底部的最小路径和
//            // 初始化为最后一行
//            int[] dp = new int[n];
//            for (int i = 0; i < n; i++) {
//                dp[i] = triangle.get(n - 1).get(i);
//            }
//
//            // 从倒数第二行开始向上递推
//            for (int i = n - 2; i >= 0; i--) {
//                // 遍历当前行的每个元素
//                for (int j = 0; j <= i; j++) {
//                    // 状态转移方程：
//                    // dp[j] = 当前值 + min(下一行同位置j, 下一行下一位置j+1)
//                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
//                }
//            }
//
//            return dp[0];
//        }
    }
}
