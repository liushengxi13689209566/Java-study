package tree;

/*
https://leetcode.cn/problems/check-balance-lcci/

面试题 04.04. 检查平衡性
简单
94
相关企业
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。


示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
返回 false 。
通过次数
42.9K
提交次数
72K
通过率
59.6%
请问您在哪类招聘中遇到此题？
1/5
社招
校招
实习
未遇到
相关标签
* */
public class isBalanced {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        // https://leetcode.cn/problems/check-balance-lcci/solution/jian-cha-ping-heng-xing-by-leetcode-solu-c5yo/
        // 自顶向下的递归（根左右）时间：O(n^2) 空间：O(n)
        public boolean isBalanced01(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.abs(height(root.left) - height(root.right)) <= 1
                        && isBalanced01(root.left) && isBalanced01(root.right);
            }
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(height(root.left), height(root.right)) + 1;
            }
        }

        //最优：自底向上的递归（左右根）时间：O(n) 空间：O(n)
        public boolean isBalanced02(TreeNode root) {
            return height02(root) >= 0;
        }

        public int height02(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height02(root.left);
            int rightHeight = height02(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }

        /**
         * 同最大深度的问题
         * https://www.bilibili.com/video/BV1KP411L7VH?spm_id_from=333.788.player.switch&vd_source=15c95ececbffc4766ecf0c5baabd1e64&p=58
         */
//        class Solution {
//            public boolean isBalanced(TreeNode root) {
//                if (root == null) {
//                    return true;
//                }
//                return deep(root) > 0;
//            }
//
//            int deep(TreeNode root) {
//                if (root == null) {
//                    return 0;
//                }
//                int leftHigh = deep(root.left);
//                if (leftHigh == -1) {
//                    return -1;
//                }
//                int rightHigh = deep(root.right);
//                if (rightHigh == -1) {
//                    return -1;
//                }
//                if (Math.abs(leftHigh - rightHigh) > 1) {
//                    return -1;
//                }
//                return Math.max(leftHigh, rightHigh) + 1;
//            }
//        }
    }
}
