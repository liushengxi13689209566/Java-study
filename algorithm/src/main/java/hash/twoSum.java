package hash;

import java.util.HashMap;

/**
 * @Date: 2022-02-15 23:07
 * @Author: liushengxi
 * @Description:
 */
public class twoSum {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        //<num数值，index> 结果需要返回 index
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }
}
