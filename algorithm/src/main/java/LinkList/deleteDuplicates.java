package LinkList;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class deleteDuplicates {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;

            // 比较的是： cur.next.val 和 cur.next.next.val 的值
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int x = cur.next.val;
                    while (cur.next != null && cur.next.val == x) {
                        // 跳过重复的元素
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
}

