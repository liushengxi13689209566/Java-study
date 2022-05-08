package LinkList;

/**
 * 剑指 Offer II 022. 链表中环的入口节点
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：是否可以使用 O(1) 空间解决此题？
 * <p>
 * 思路：当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；
 * 随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
 */
public class detectCycle {
    public class Solution01 {
        // 判断链表中是否有环
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

    public class Solution {
        // 有环，并且找到入环的节点
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (slow == fast) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        slow = slow.next;
                        ptr = ptr.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }
}
