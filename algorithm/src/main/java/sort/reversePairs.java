package sort;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 思路：
 * （1）暴力解法肯定会超时
 * （2）归并排序：https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
 */
public class reversePairs {
    class Solution {
        int res = 0;

        public int reversePairs(int[] nums) {
            int len = nums.length;
            this.res = 0;
            if (len <= 0) {
                return res;
            }
            merge(nums, 0, len - 1);
            return res;
        }

        // 归并排序
        public void merge(int[] nums, int left, int right) {
            int mid = left + ((right - left) >> 1);
            if (left < right) {
                merge(nums, left, mid);
                merge(nums, mid + 1, right);
                mergeSort(nums, left, mid, right);
            }
        }

        // 核心实现
        public void mergeSort(int[] nums, int left, int mid, int right) {
            int[] temparr = new int[right - left + 1];
            int index = 0; //临时数组下标
            int temp1 = left; //左边数组的起始
            int temp2 = mid + 1; //右边数组的起始

            while (temp1 <= mid && temp2 <= right) {
                if (nums[temp1] <= nums[temp2]) {
                    temparr[index++] = nums[temp1++];
                } else {
                    //用来统计逆序对的个数
                    res += (mid - temp1 + 1);
                    temparr[index++] = nums[temp2++];
                }
            }
            //把左边剩余的数移入数组
            while (temp1 <= mid) {
                temparr[index++] = nums[temp1++];
            }
            //把右边剩余的数移入数组
            while (temp2 <= right) {
                temparr[index++] = nums[temp2++];
            }
            //把新数组中的数覆盖nums数组
            for (int k = 0; k < temparr.length; k++) {
                nums[k + left] = temparr[k];
            }
        }
    }
}
