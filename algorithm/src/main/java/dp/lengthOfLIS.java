package dp;

/**
 * @Date: 2022-03-27 23:48
 * @Author: liushengxi
 * @Description:
 */
public class lengthOfLIS {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.lengthOfLIS(new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5});
//        solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    }
}

class Solution {
    int search(int[] res, int left, int right, int target) {
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (res[mid] == target) {
                //找到真正的想等值，那就直接返回。否则就返回 left 的值
                return mid;
            } else if (res[mid] < target) {
                left = mid + 1;
            } else if (res[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 最大的值永远在：最后一个数字
        int[] res = new int[nums.length];
        // 两个初始化 还蛮重要的 ！
        res[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res[len]) {
                len++;
                res[len] = nums[i];
            } else {
                //std::lower_bound() 的实现
                int index = search(res, 0, len, nums[i]);
                res[index] = nums[i];
            }
        }
        return len + 1;
    }
}











