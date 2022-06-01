package leftRight;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * <p>
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class search {
    class Solution {
        private int getFirstIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] < target) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }

        private int getLastIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                // 二分查找的主要修改地点
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid + 1] > target) {
                        return mid;
                    } else {
                        // 注意这里需要折半才行
                        left = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }

        public int search(int[] nums, int target) {
            int first = getFirstIndex(nums, target);
            int last = getLastIndex(nums, target);
            // System.out.println(first);
            // System.out.println(last);
            if (last == -1 && first == -1) {
                return 0;
            } else {
                return last - first + 1;
            }
        }
    }
}
