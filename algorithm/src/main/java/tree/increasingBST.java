package tree;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 示例 1：

 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * 提示：
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 * <p>
 * 思路：保存一个 preNode 指针，将 preNode.right == 当前节点，当前节点.left == null
 * <p>
 * 链接：https://leetcode.cn/problems/NYBBNL/
 */
public class increasingBST {
    class Solution {
        private TreeNode preNode;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummyNode = new TreeNode(-1);
            preNode = dummyNode;
            inorder(root);
            return dummyNode.right;
        }

        public void inorder(TreeNode node) {
            if (node == null) {
                return;
            }
            inorder(node.left);

            // 在中序遍历的过程中修改节点指向
            preNode.right = node;
            node.left = null;
            preNode = node;

            inorder(node.right);
        }
    }
}
