package tree;

/*
https://leetcode.cn/problems/minimum-height-tree-lcci/

面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
通过次数44,571提交次数56,561

# TODO: 思路，每次以中心点为根构造二叉树
* */
public class sortedArrayToBST {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null) {
                return null;
            }
            // 以 中心点 为树根
            return contract(nums, 0, nums.length - 1);
        }

        private TreeNode contract(int[] nums, int l, int r) {
            // 退出条件
            if (l > r) {
                return null;
            }
            int rootIndex = (l + r) / 2;
            TreeNode root = new TreeNode(nums[rootIndex]);
            root.left = contract(nums, l, rootIndex - 1);
            root.right = contract(nums, rootIndex + 1, r);
            return root;
        }
    }
}
