package tree;

import java.util.Stack;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * <p>
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 * 示例 1：
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 * 思路：
 * 链接：https://leetcode.cn/problems/P5rCT8/
 * https://leetcode.cn/problems/P5rCT8/solution/er-cha-sou-suo-shu-zhong-de-zhong-xu-hou-5nrz/
 */
public class inorderSuccessor {
    // 方法一：中序遍历
    // 时间:O(n) 空间:O(n)
    class Solution01 {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode currNode = root;
            TreeNode prevNode = null;
            while (currNode != null || !stack.isEmpty()) {
                while (currNode != null) {
                    stack.push(currNode);
                    currNode = currNode.left;
                }
                currNode = stack.pop();
                if (prevNode == p) {
                    return currNode;
                }
                prevNode = currNode;
                currNode = currNode.right;
            }

            TreeNode result = null;
            return result;
        }
    }

    // 方法二：利用二叉搜索树的性质
    // 时间:O(logN) 空间:O(1)
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode result = null;
            // 如果 右边不为空，那么直接找右子树中最小的数值
            if (p.right != null) {
                result = p.right;
                while (result.left != null) {
                    result = result.left;
                }
                return result;
            }
            // 如果 右边为空, 那么就 二分查找（重点）
            TreeNode node = root;
            while (node != null) {
                if (node.val > p.val) {
                    result = node;
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return result;
        }
    }
}
