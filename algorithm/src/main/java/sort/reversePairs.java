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
 * (3) 视频讲解：https://www.bilibili.com/video/BV1KP411L7VH?spm_id_from=333.788.player.switch&vd_source=15c95ececbffc4766ecf0c5baabd1e64&p=52
 */
public class reversePairs {
    class Solution {
        public int reversePairs(int[] record) {
            if (record == null || record.length <= 0) {
                return 0;
            }
            return mergeSort(record, 0, record.length - 1);
        }

        public int mergeSort(int[] record, int left, int right) {
            if (left >= right) {
                return 0;
            }
            int mid = (right - left) / 2 + left;
            int x1 = mergeSort(record, left, mid);
            int x2 = mergeSort(record, mid + 1, right);
            int x3 = merge(record, left, mid, mid + 1, right);
            return x1 + x2 + x3;
        }

        public int merge(int[] record, int l1, int r1, int l2, int r2) {
            int[] temp = new int[r2 - l1 + 1];
            int i = l1, j = l2, k = 0;
            int count = 0;
            while (i <= r1 && j <= r2) {
                if (record[j] < record[i]) {
                    count = count + (l2 - i);
                    temp[k++] = record[j++];
                } else {
                    temp[k++] = record[i++];
                }
            }
            while (i <= r1) {
                temp[k++] = record[i++];
            }
            while (j <= r2) {
                temp[k++] = record[j++];
            }
            k = 0;
            for (i = l1; i <= r2; i++) {
                record[i] = temp[k++];
            }
            return count;
        }

    }
//    class Solution {
//        int res = 0;
//
//        public int reversePairs(int[] nums) {
//            int len = nums.length;
//            this.res = 0;
//            if (len <= 0) {
//                return res;
//            }
//            merge(nums, 0, len - 1);
//            return res;
//        }
//
//        // 归并排序
//        public void merge(int[] nums, int left, int right) {
//            int mid = left + ((right - left) >> 1);
//            if (left < right) {
//                merge(nums, left, mid);
//                merge(nums, mid + 1, right);
//                mergeSort(nums, left, mid, right);
//            }
//        }
//
//        // 核心实现
//        public void mergeSort(int[] nums, int left, int mid, int right) {
//            int[] temparr = new int[right - left + 1];
//            int index = 0; //临时数组下标
//            int temp1 = left; //左边数组的起始
//            int temp2 = mid + 1; //右边数组的起始
//
//            while (temp1 <= mid && temp2 <= right) {
//                if (nums[temp1] <= nums[temp2]) {
//                    temparr[index++] = nums[temp1++];
//                } else {
//                    //用来统计逆序对的个数
//                    res += (mid - temp1 + 1);
//                    temparr[index++] = nums[temp2++];
//                }
//            }
//            //把左边剩余的数移入数组
//            while (temp1 <= mid) {
//                temparr[index++] = nums[temp1++];
//            }
//            //把右边剩余的数移入数组
//            while (temp2 <= right) {
//                temparr[index++] = nums[temp2++];
//            }
//            //把新数组中的数覆盖nums数组
//            for (int k = 0; k < temparr.length; k++) {
//                nums[k + left] = temparr[k];
//            }
//        }
//    }
}
