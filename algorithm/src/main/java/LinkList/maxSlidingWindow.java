package LinkList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 思路：
 *
 */
class maxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            //1.优先队列(大顶堆)
            //2.dequeue
            if (nums == null || k <= 0 || nums.length <= 0) {
                return new int[0];
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
}