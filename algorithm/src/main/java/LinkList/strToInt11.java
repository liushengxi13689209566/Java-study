package LinkList;

/**
 * 求链表的 倒数第 N 个节点
* */
public class strToInt11 {
    class Node {
        int val;
        Node next;
    }

    class Solution {
        public Node getN(Node head, int n) {
            if (head == null) {
                return null;
            }
            Node fast = head;
            Node slow = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
                // 如果不够 n，返回 null;
                if(fast == null){
                    return null;
                }
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}










