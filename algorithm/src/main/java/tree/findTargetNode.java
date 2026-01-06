package tree;

public class findTargetNode {
    /**
     * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/
     * <p>
     * LCR 174. 寻找二叉搜索树中的目标节点
     * 已解答
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 某公司组织架构以二叉搜索树形式记录，节点值为处于该职位的员工编号。请返回第 cnt 大的员工编号。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [7, 3, 9, 1, 5], cnt = 2
     * 7
     * / \
     * 3   9
     * / \
     * 1   5
     * 输出：7
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入: root = [10, 5, 15, 2, 7, null, 20, 1, null, 6, 8], cnt = 4
     * 10
     * / \
     * 5   15
     * / \    \
     * 2   7    20
     * /   / \
     * 1   6   8
     * 输出: 8
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 ≤ cnt ≤ 二叉搜索树元素个数
     */
    class Solution {
        int k = 0;
        int target = 0;

        public int findTargetNode(TreeNode root, int cnt) {
            if (root == null) {
                return -1;
            }
            this.k = cnt;
            // 中序遍历 右 根 左
            inOrder(root);
            return this.target;
        }

        void inOrder(TreeNode root) {
            if (root != null) {
                inOrder(root.right);
                k--;
                if (k == 0) {
                    this.target = root.val;
                    return;
                }
                inOrder(root.left);
            }
        }
    }
}
