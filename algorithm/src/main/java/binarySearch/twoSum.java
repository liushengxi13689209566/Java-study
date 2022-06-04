package binarySearch;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 */
public class twoSum {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if (numbers == null) {
                return new int[0];
            }
            int len = numbers.length;
            if (len <= 0) {
                return new int[0];
            }
            for (int i = 0; i < len; i++) {
                if (numbers[i] > target)
                    continue;
                // 一定是先找到小的，再找到大的数字，所以直接从 i+1 二分查找即可
                int ret = binSearch(numbers, i + 1, target - numbers[i]);
                if (ret != -1) {
                    return new int[]{i, ret};
                }
            }
            return new int[0];
        }

        private int binSearch(int[] numbers, int left, int target) {
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                if (numbers[mid] < target) {
                    left = mid + 1;
                } else if (numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
