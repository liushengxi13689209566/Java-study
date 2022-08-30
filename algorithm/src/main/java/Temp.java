import LinkList.ListNode;
import com.google.common.collect.Lists;

import java.util.*;

/*
面试题 02.01. 移除重复节点

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
* */
public class Temp {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode tail = null;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry != 0) {
                tail.next = new ListNode(carry);
                tail.next.next = null;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        ListNode head1 = l1;
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(5);
        ListNode head2 = l2;
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = null;
        solution.addTwoNumbers(head1, head2);
    }
}

