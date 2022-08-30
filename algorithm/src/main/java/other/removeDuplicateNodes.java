package other;

import LinkList.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
* 面试题 02.01. 移除重复节点

编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]

示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]

提示：

    链表长度在[0, 20000]范围内。
    链表元素在[0, 20000]范围内。

进阶：

如果不得使用临时缓冲区，该怎么解决？
*
* 时间：O(n)
* 空间：O(n)
*/
public class removeDuplicateNodes {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) return null;
            // 使用一个 Set 保存出现过的元素
            Set<Integer> valueSet = new HashSet<>();
            ListNode curr = head;

            ListNode newHead = new ListNode(-1);
            ListNode insert = newHead;

            while (curr != null) {
                if (!valueSet.contains(curr.val)) {
                    insert.next = curr;
                    insert = curr;
                    valueSet.add(curr.val);
                }
                curr = curr.next;
            }
            insert.next = null;

            return newHead.next;
        }
    }
}
