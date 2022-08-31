package priorityqueue;

import java.util.PriorityQueue;

/*
https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
* 剑指 Offer 41. 数据流中的中位数

如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。

示例 1：

输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]

示例 2：

输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]



限制：

    最多会对 addNum、findMedian 进行 50000 次调用。

注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/

思路：使用两个堆进行处理，
时间：O(logN)
空间：0(n)
* */
class MedianFinder {

    PriorityQueue<Integer> A;
    PriorityQueue<Integer> B;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        A = new PriorityQueue<>(); //  小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    /*当 两方为 偶数）：需向 A 添加一个元素。实现方法：将新元素 num 插入至 B ，再将 BBB 堆顶元素插入至 A ；
      当 两方为 奇数）：需向 B 添加一个元素。实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 B ；
    * */
    public void addNum(int num) {
        if (A.size() != B.size()) {
            // B 加元素了，A 没变
            A.add(num);
            B.add(A.poll());
        } else {
            // A 加元素了，B 没变
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */