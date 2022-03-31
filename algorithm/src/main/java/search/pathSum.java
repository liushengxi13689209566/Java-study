package search;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022-03-30 23:05
 * @Author: liushengxi
 * @Description: 二叉树中和为某一值的路径
 */
public class pathSum {
    class Solution {
        // 一般是比较复杂的数据结构：会放在类的成员变量中
        private List<List<Integer>> result = new ArrayList<>();
        private List<Integer> onePath = new ArrayList<>();

        private void dfs(TreeNode root, int target) {
            // 这里面要处理 root
            if (root == null) {
                return;
            }
            onePath.add(root.val);
            target -= root.val;

            if (root.left == null && root.right == null && 0 == target) {
                result.add(new ArrayList<>(onePath));
            }
            dfs(root.left, target);
            dfs(root.right, target);
            // 回溯（target 因为是 不断压栈和进栈的，所以不需要回溯）
            onePath.remove(onePath.size() - 1);
        }

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return result;
            }
            dfs(root, target);
            return result;
        }
    }

}

