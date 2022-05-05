package leftRight;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class numSubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (nums == null) {
                return -1;
            }
            int len = nums.length;
            if (len <= 0) {
                return 0;
            }
            int left = 0;
            int res = 0;
            int product = 1;
            //滑动窗口表示含义：滑动窗口表示以当前元素为结尾，且乘积 < k 的子数组
            for (int right = 0; right < len; right++) {
                // 如果当前元素大于 k，那么在其滑动窗口内就不存在子数组满足条件
                if (nums[right] >= k) {
                    product = 1;
                    left = right + 1;
                } else {
                    product *= nums[right];
                    while (product >= k) {
                        product /= nums[left];
                        left++;
                    }
                    // 见：https://leetcode-cn.com/problems/ZVAVXX/solution/c-jie-shi-xia-yuan-shu-mei-you-jie-shi-d-26kx/
                    res += right - left + 1;
                }
            }
            return res;
        }
    }
}

