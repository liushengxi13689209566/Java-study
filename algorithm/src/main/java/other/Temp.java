package other;

import java.util.HashMap;
import java.util.Map;

/*
给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。

返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。

示例 1:

输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]

示例 2:

输入: ["A","A"]

输出: []

 * */
public class Temp {
    static class Solution {
        public int[] arrayChange(int[] nums, int[][] operations) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            // 转换
            for (int[] operation : operations) {
                int index = map.get(operation[0]);
                map.remove(operation[0]);
                map.put(operation[1], index);
            }

            for (Integer key : map.keySet()) {
                nums[map.get(key)] = key;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{4, 5, 6};
//        String[] subarray = solution.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
//        for (String s : subarray) {
//            System.out.print(s);
//        }
        System.out.println();
    }
}

