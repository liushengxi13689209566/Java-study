package leftRight;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * 给定一个含有 len 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 方法一：双指针解法 时间 O(n) 空间O(1)
 */
public class minSubArrayLen {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int left = 0, right = 0;
            int sum = 0;
            while (right < len) {
                sum += nums[right];
                while (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
                right++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}



