package tree;


/**
 * @Date: 2022-02-27 10:47
 * @Author: liushengxi
 * @Description:
 */
public class isValidBST {
    class Solution {
        private boolean helper(TreeNode root, Integer min, Integer max) {
            if (root == null) {
                return true;
            }
            if (min != null && min >= root.val) return false;
            if (max != null && max <= root.val) return false;
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val >= root.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
