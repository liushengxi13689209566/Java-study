package tree;

import LinkList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题 04.03. 特定深度节点链表
 *
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * 思路：就是 层序输出 即可 ！！！
 */
public class listOfDepth {
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return new ListNode[0];
            }
            List<ListNode> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ListNode cur = null;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    ListNode temp = new ListNode(node.val);
                    // 这种构造 链表 的方式还挺有意思的～
                    temp.next = cur;
                    cur = temp;
                    // 始终注意判断空吧！！！
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                result.add(cur);
            }
            return result.toArray(new ListNode[result.size()]);
        }
    }
}
