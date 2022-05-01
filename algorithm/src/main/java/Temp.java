import org.mockito.internal.matchers.GreaterThan;

public class Temp {
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
