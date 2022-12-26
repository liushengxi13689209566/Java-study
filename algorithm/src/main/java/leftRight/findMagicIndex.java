package leftRight;

/**
 * https://leetcode.cn/problems/magic-index-lcci/
 * <p>
 * c
 * 简单
 * 118
 * 相关企业
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个 **有序整数数组** ，编写一种方法找出魔术索引，
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 */
public class findMagicIndex {
    static class Solution {
        public int findMagicIndex(int[] nums) {
            if (nums == null) {
                return -1;
            }
            int res = 0;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < mid) {
                    right = mid - 1;
                } else if (nums[mid] > mid) {
                    left = mid + 1;
                } else {
                    if (nums[mid] == (mid - 1)) {
                        right = mid - 1;
                    } else {
                        return nums[mid];
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-96, -87, -76, -66, -64, -57, -8, 4, 8, 27, 39, 48, 52, 62, 63, 69, 84, 85, 85, 90};
        solution.findMagicIndex(nums);
    }
}
