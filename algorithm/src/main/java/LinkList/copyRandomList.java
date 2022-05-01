package LinkList;

/**
 * @Date: 2022-04-04 18:06
 * @Author: liushengxi
 * @Description: 剑指 Offer 35. 复杂链表的复制
 */
public class copyRandomList {


    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            // 对于链表 A->B->C，我们可以将其拆分为 A -> A' -> B -> B' -> C -> C'
            // 最后整理即可
            for (Node node = head; node != null; node = node.next.next) {
                Node nodeNew = new Node(node.val);
                nodeNew.next = node.next;
                node.next = nodeNew;
            }
            // 设置 random 指针
            for (Node node = head; node != null; node = node.next.next) {
                Node nodeNew = node.next;
                nodeNew.random = (node.random != null) ? node.random.next : null;
            }
            // 设置 random 指针
            Node headNew = head.next;
            for (Node node = head; node != null; node = node.next) {
                Node nodeNew = node.next;
                node.next = node.next.next;
                nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
            }
            return headNew;
        }
    }

}

