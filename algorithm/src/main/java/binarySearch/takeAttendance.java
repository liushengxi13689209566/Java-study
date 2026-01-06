package binarySearch;

/*
 *
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 * 二分查找
 *
 * */
public class takeAttendance {
    class Solution {
        public int takeAttendance(int[] records) {
            if (records == null || records.length <= 0) {
                return -1;
            }
            int left = 0;
            int right = records.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (records[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
