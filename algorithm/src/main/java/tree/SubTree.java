package tree;


/**
 * @Date: 2022-03-17 23:04
 * @Author: liushengxi
 * @Description: 树的子结构
 */
public class SubTree {
    class Solution {
        boolean sameTree(TreeNode A, TreeNode B) {
            // 要注意先判断 B，不然会运行不通过
            if (B == null)
                return true;
            if (A == null)
                return false;
            if (A.val == B.val) {
                return sameTree(A.left, B.left) && sameTree(A.right, B.right);
            } else {
                return false;
            }
        }

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null)
                return false;
            // 先判断当前
            if (A.val == B.val) {
                boolean ret = sameTree(A.left, B.left) && sameTree(A.right, B.right);
                if (ret) {
                    return true;
                }
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }
}

