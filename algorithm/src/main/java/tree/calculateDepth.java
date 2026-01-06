package tree;

public class calculateDepth {
    /**
     * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/description/
     * <p>
     * LCR 175. 计算二叉树的深度
     * 已解答
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 某公司架构以二叉树形式记录，请返回该公司的层级数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1, 2, 2, 3, null, null, 5, 4, null, null, 4]
     * 输出: 4
     * 解释: 上面示例中的二叉树的最大深度是 4，沿着路径 1 -> 2 -> 3 -> 4 或 1 -> 2 -> 5 -> 4 到达叶节点的最长路径上有 4 个节点。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 节点总数 <= 10000
     * 注意：本题与主站 104 题相同：https://leetcode.cn/problems/maximum-depth-of-binary-tree/
     * }
     * }
     */
    class Solution {
        public int calculateDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHigh = calculateDepth(root.left);
            int rightHigh = calculateDepth(root.right);
            return Math.max(leftHigh, rightHigh) + 1;
        }
    }
}
