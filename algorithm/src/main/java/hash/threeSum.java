package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2022-02-15 23:27
 * @Author: liushengxi
 * @Description: 注意：答案中不可以包含重复的三元组。
 */
public class threeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null) {
                return null;
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                // 剪枝:如果已经大于0，那绝对就是找不到其余两个数字了
                if (nums[i] > 0) return result;
                //对 num[i] 直接进行去重
                if (i > 0 && nums[i - 1] == nums[i]) continue;
                //左右进行夹逼，left 往右移动，之和变大，right 往左移动，之和变小
                int left = i + 1;
                int right = nums.length - 1;
                //记住三个循环的一个结构
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] < 0) {
                        left++;
                    } else if (nums[left] + nums[right] + nums[i] > 0) {
                        right--;
                    } else {
                        // 三数之和为 0 了
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //对 left 和 right 进行去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        // 修改指针：因为可能存在这种不止一种情况。如： -10 -9  -8        18 19
                        left++;
                        right--;
                    }
                }
            }
            return result;
        }
    }
}




