package tree;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date: 2022-04-10 22:00
 * @Author: liushengxi
 * @Description: 剑指 Offer 32 - I. 从上到下打印二叉树
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
@Ignore
@jdk.nashorn.internal.ir.annotations.Ignore
public class levelOrder {
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<Integer> res = new ArrayList<Integer>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp.left != null) queue.offer(tmp.left);
                    if (tmp.right != null) queue.offer(tmp.right);
                    res.add(tmp.val);
                }
            }
            int[] result = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                result[i] = res.get(i);
            }
            return result;
        }
    }
}
