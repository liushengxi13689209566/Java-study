package leftRight;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * <p>
 * 题目链接：https://leetcode.cn/problems/trapping-rain-water/
 * 相似题目：11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 * <p>
 * 思路：
 * 只考虑位置 i，发现
 * 位置 i 能达到的水柱高度和其左边的最高柱子、右边的最高柱子有关，
 * 我们分别称这两个柱子高度为 l_max 和 r_max；
 * 位置 i 最大的水柱高度就是 min(l_max, r_max)。
 */
public class trap {
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length <= 1) {
                return 0;
            }
            int left = 0;
            int right = height.length - 1;
            int res = 0;
            int l_max = 0;
            int r_max = 0;
            while (left <= right) {
                l_max = Math.max(l_max, height[left]);
                r_max = Math.max(r_max, height[right]);
                if (l_max < r_max) {
                    res += l_max - height[left];
                    left++;
                } else {
                    res += r_max - height[right];
                    right--;
                }
            }
            return res;
        }
    }
}
