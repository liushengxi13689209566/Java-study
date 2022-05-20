package leftRight;

import java.util.Arrays;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * https://leetcode.cn/problems/tvdfij/
 * ————————————————
 * 版权声明：本文为CSDN博主「Tattoo_Welkin」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/liushengxi_root/article/details/124208521
 */
public class pivotIndex {
    /**
     * class Solution01 {
     * public int pivotIndex(int[] nums) {
     * // 中心扩散？O(n^2)
     * // 单调栈（和）思路
     * // 1, 7,  3, 6, 5, 6
     * // 1. 8.   11  17 22 28
     * // 28. 27  20 17 11 6
     * <p>
     * // 下标是 -3, 3
     * // 6, -3,  3, 3, 0, 0
     * // 6.  3.  6  9  9. 9
     * // 9.  3   6  3  0  0
     * if (nums == null) {
     * return -1;
     * }
     * int len = nums.length;
     * if (len <= 0) {
     * return -1;
     * }
     * // 前缀和
     * int[] leftSum = new int[len];
     * // 后缀和
     * int[] rightSum = new int[len];
     * leftSum[0] = nums[0];
     * rightSum[len - 1] = nums[len - 1];
     * for (int i = 1; i < len; i++) {
     * leftSum[i] = leftSum[i - 1] + nums[i];
     * }
     * for (int i = len - 2; i >= 0; i--) {
     * rightSum[i] = rightSum[i + 1] + nums[i];
     * }
     * for (int i = 0; i < len; i++) {
     * if (leftSum[i] == rightSum[i]) {
     * return i;
     * }
     * }
     * return -1;
     * }
     * }
     */

    class Solution {
        public int pivotIndex(int[] nums) {
            int total = Arrays.stream(nums).sum();
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (2 * sum + nums[i] == total) {
                    return i;
                }
                sum += nums[i];
            }
            return -1;
        }
    }
}
