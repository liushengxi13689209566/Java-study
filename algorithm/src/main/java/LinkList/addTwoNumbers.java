package LinkList;


import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.cn/problems/sum-lists-lcci/

面试题 02.05. 链表求和

给定两个用链表表示的整数，每个节点包含一个数位。

这些数位是反向存放的，也就是个位排在链表首部。

编写函数对这两个整数求和，并用链表形式返回结果。

示例：

输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912

进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?

示例：

输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912
* */
public class addTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode tail = null;
            int carry = 0;

            while (l1 != null || l2 != null) {
                // 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 0 。
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

    class Solution02 {
        // 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new ArrayDeque<Integer>();
            Deque<Integer> stack2 = new ArrayDeque<Integer>();
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode ans = null;
            // 注意判断条件
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
                int a = stack1.isEmpty() ? 0 : stack1.pop();
                int b = stack2.isEmpty() ? 0 : stack2.pop();
                int cur = a + b + carry;
                carry = cur / 10;
                cur %= 10;
                // 注意这里链表指针的转移，是一种逆时针的转移办法
                ListNode curnode = new ListNode(cur);
                curnode.next = ans;
                ans = curnode;
            }
            return ans;
        }
    }
}
