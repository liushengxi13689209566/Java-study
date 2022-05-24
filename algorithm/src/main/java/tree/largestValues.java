package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 *  
 * <p>
 * 示例1：
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 * 1
 * / \
 * 2   3
 * 示例3：
 * <p>
 * 输入: root = [1]
 * 输出: [1]
 * 示例4：
 * <p>
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:
 *            1
 *             \
 *              2
 * 示例5：
 * <p>
 * 输入: root = []
 * 输出: []
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 */
public class largestValues {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            // 层序遍历
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null)
                queue.offer(root);
            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                Integer max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                    max = Math.max(node.val, max);
                }
                result.add(max);
            }
            return result;
        }
    }
}
