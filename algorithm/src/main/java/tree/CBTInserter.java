package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 043. 往完全二叉树添加节点
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 * <p>
 * 题解：https://leetcode.cn/problems/NaqhDT/solution/jian-zhi-offer-2-mian-shi-ti-43-shu-zhon-hy4v/
 */
class CBTInserter {
    // 保存 树中第一个到最后一个缺 左或右节点的 队列
    private Queue<TreeNode> que = new LinkedList<>();
    //保存 root 节点
    private TreeNode root;

    CBTInserter(TreeNode root) {
        this.root = root;
        que.offer(root);

        while (que.peek().left != null && que.peek().right != null) {
            que.offer(que.peek().left);
            que.offer(que.peek().right);
            que.poll();
        }
    }

    int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode father = que.peek();
        if (father.left == null) {
            father.left = node;
        } else {
            father.right = node;
            que.offer(father.left);
            que.offer(father.right);
            que.poll();
        }
        return father.val;
    }

    TreeNode get_root() {
        return this.root;
    }
}