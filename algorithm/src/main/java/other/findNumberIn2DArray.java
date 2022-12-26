package other;

/**
 * @Date: 2022-03-22 19:33
 * @Author: liushengxi
 * @Description:
 */
public class findNumberIn2DArray {
    class Solution {
        boolean search(int[] nums, int target) {
            if (nums.length <= 0)
                return false;

            int left = 0;
            int right = nums.length - 1; //right一定要指向最后一个有效的数字
            int mid = 0;

            while (left <= right) {
                mid = left + ((right - left) >> 1); //这里一定要加括号才行
                if (nums[mid] == target)
                    return true;
                else if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return false;
        }

        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            // 二分查找
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            for (int i = 0; i < row; i++) {
                if (search(matrix[i], target)) {
                    return true;
                }
            }
            return false;
        }
    }
}
