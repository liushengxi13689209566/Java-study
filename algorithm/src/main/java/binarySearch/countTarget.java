package binarySearch;

public class countTarget {
    class Solution {
        public int countTarget(int[] scores, int target) {
            if (scores == null || scores.length <= 0) {
                return 0;
            }
            int frist = searchFrist(scores, target);
            int last = searchLast(scores, target);
            if (frist == -1 || last == -1) {
                return 0;
            }
            return last - frist + 1;
        }

        public int searchFrist(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int res = -1;

            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    res = mid;
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return res;
        }

        public int searchLast(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int res = -1;

            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    res = mid;
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
}
