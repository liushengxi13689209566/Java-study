//import javax.swing.tree.TreeNode;
//
///**
// * @Date: 2022-02-28 22:39
// * @Author: liushengxi
// * @Description:
// */
//public class LCA {
//}
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left;
// * TreeNode right;
// * TreeNode(int x) { val = x; }
// * }
// */
//
//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || p == root || q == root) {
//            return root;
//        }
//        TreeNode left_lca = lowestCommonAncestor(root.left, p, q);
//        TreeNode right_lca = lowestCommonAncestor(root.right, p, q);
//        if (left_lca != null && right_lca != null) {
//            return root;
//        }
//        return left_lca != null ? left_lca : right_lca;
//    }
//}
