package leftRight;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 题目链接；https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 思路：
 * （1）
 * （2）二分查找¬
 * （3）双指针，左右指针即可
 */
public class twoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // 双指针方法
            if (nums == null || nums.length <= 1) {
                return new int[0];
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return new int[]{nums[left], nums[right]};
                }
            }
            return new int[0];
        }
    }
}
