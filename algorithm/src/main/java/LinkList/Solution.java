package LinkList;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //1.优先队列(大顶堆)
        //2.dequeue
        if (nums == null || k <= 0 || nums.length <= 0) {
            return null;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //数组下标：放到双端队列最后
            deque.offerLast(i);
        }
        int[] result = new int[nums.length - k + 1];
        // 取队列的最大首元素
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}
