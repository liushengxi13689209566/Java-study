package tree;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * <p>
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class diameterOfBinaryTree {
    class Solution {
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        public int depth(TreeNode node) {
            if (node == null) {
                return 0; // 访问到空节点了，返回0
            }
            int L = depth(node.left); // 左儿子为根 的 子树的深度
            int R = depth(node.right); // 右儿子为根 的 子树的深度
            ans = Math.max(ans, L + R + 1); // 计算 d_node 即 L+R+1 并更新ans
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }

    /*  这是我写的通过 的代码
    class Solution01 {
        // 求出 从 root 出发的 树的最大深度
        private int depth(TreeNode root) {
            if (root != null) {
                if (root.left == null && root.right == null) {
                    return 1;
                }
                return Math.max(depth(root.left), depth(root.right)) + 1;
            }
            return 0;
        }

        // 针对所有节点 都求一遍，返回最大值即可。
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = depth(root.left) + depth(root.right);
            int temp = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
            return Math.max(res, temp);
        }
    }
    */
}
