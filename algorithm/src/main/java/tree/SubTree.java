//package tree;
//
//
//import org.junit.Ignore;
//
//import javax.swing.tree.TreeNode;
//
///**
// * @Date: 2022-03-17 23:04
// * @Author: liushengxi
// * @Description:
// */
//@Ignore
//public class SubTree {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     * int val;
//     * TreeNode left;
//     * TreeNode right;
//     * TreeNode(int x) { val = x; }
//     * }
//     */
//    class Solution {
//        boolean sameTree(TreeNode A, TreeNode B) {
//            // 要注意先判断 B，不然会运行不通过
//            if (B == null)
//                return true;
//            if (A == null)
//                return false;
//            if (A.val == B.val) {
//                return sameTree(A.left, B.left) && sameTree(A.right, B.right);
//            } else {
//                return false;
//            }
//        }
//
//        public boolean isSubStructure(TreeNode A, TreeNode B) {
//            if (A == null || B == null)
//                return false;
//            // 先判断当前
//            if (A.val == B.val) {
//                boolean ret = sameTree(A.left, B.left) && sameTree(A.right, B.right);
//                if (ret) {
//                    return true;
//                }
//            }
//            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
//        }
//    }
//
//    static class Solution {
//        private int result = 0;
//        private int[] InOrderResult = new int[];
//
//        int InOrder(TreeNode root, int i) {
//            int res = 0;
//            // 中序: 左 根 右
//            if (root.left != null)
//                res = InOrder(root.left, i);
//            if (root != null) {
//                InOrderResult
//            }
//            if (i == result) {
//                res = root.val;
//            }
//            i++;
//            if (root.right != null)
//                res = InOrder(root.right, i);
//            return res;
//        }
//
//        public int kthLargest(TreeNode root, int k) {
//            result = k;
//            return InOrder(root, 0);
//        }
//    }
//}
//
