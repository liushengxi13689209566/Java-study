package leftRight;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * <p>
 * 题目链接：
 * https://leetcode.cn/problems/container-with-most-water/
 * 思路：
 * 用 left 和 right 两个指针从两端向中心收缩，一边收缩一边计算 [left, right] 之间的矩形面积，取最大的面积值即是答案。
 * <p>
 * 其实也好理解，因为矩形的高度是由 min(height[left], height[right]) 即较低的一边决定的：
 * <p>
 * 你如果移动较低的那一边，那条边可能会变高，使得矩形的高度变大，进而就「有可能」使得矩形的面积变大；相反，
 * 如果你去移动较高的那一边，矩形的高度是无论如何都不会变大的，所以不可能使矩形的面积变得更大。
 */
public class maxArea {
    class Solution {
        public int maxArea(int[] height) {
            if (height == null || height.length <= 1) {
                return 0;
            }
            int left = 0;
            int right = height.length - 1;
            int res = 0;
            while (left <= right) {
                int minHeight = Math.min(height[left], height[right]);
                res = Math.max(res, minHeight * (right - left));

                // 双指针技巧，移动较低的一边
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return res;
        }
    }
}
