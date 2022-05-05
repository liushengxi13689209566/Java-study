package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * （1）哈希表
 * （2）排序寻找
 */
public class singleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            if (nums == null) {
                return -1;
            }
            int len = nums.length;
            if (len <= 0) {
                return -1;
            }
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
}
