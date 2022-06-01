import com.google.common.collect.Lists;

import java.util.*;


public class Temp {
    class Solution {
        private int getFirstIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] < target) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }

        private int getLastIndex(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid + 1] > target) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }

        public int[] searchRange(int[] nums, int target) {
            return new int[]{getFirstIndex(nums, target), getLastIndex(nums, target)};
        }
    }
}

