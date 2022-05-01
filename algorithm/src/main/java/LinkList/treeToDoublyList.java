package LinkList;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * @Date: 2022-04-05 10:43
 * @Author: liushengxi
 * @Description: 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class treeToDoublyList {

    public static void main(String[] args) {
        List<String> ids = Splitter.on(",").splitToList("123,456");

        System.out.println(ids.contains(123));
        System.out.println(ids.contains("123"));
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        void dfs(Node cur) {
            if (cur == null) return;

            dfs(cur.left);

            // 核心代码
            if (pre != null) {
                pre.right = cur;
            } else {
                head = cur;
            }
            cur.left = pre;
            pre = cur;

            dfs(cur.right);
        }
    }

    class Solution2 {
        Node helper(Node root) {
            if (root.left == null && root.right == null) {
                return root;
            }
            root.left = helper(root.left);
            root.right = helper(root.right);
            return root;
        }

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            Node head = root.left;
            while (head != null) {
                head = head.left;
            }

            System.out.println(head.val);

            Node tail = root.right;
            while (tail != null) {
                tail = tail.right;
            }

            System.out.println(tail.val);

            helper(root);

            head.left = tail;
            tail.right = head;

            return head;

        }


    }


}
