package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Date: 2022-03-31 20:28
 * @Author: liushengxi
 * @Description: 222. 完全二叉树的节点个数
 */
public class countNodes {
    public int countNodes01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes01(root.left) + countNodes01(root.right) + 1;
    }

    class Solution {
        private int bfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            int res = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                res += 2;
            }
            return res;
        }

        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}





