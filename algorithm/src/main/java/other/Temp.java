package other;

import java.util.Arrays;
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
        public String[] findLongestSubarray(String[] array) {
            int len = array.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                char ch = array[i].charAt(0);
                if (ch >= 'A' && ch <= 'z') {
                    arr[i] = 1;
                } else {
                    arr[i] = -1;
                }
            }

            int left = 0;
            int right = -1;
            // 前缀和：下标
            Map<Integer, Integer> map = new HashMap<>();
            map.put(arr[0], 0);

            for (int i = 1; i < arr.length; i++) {
                arr[i] += arr[i - 1];
                int size = right - left;
                if (arr[i] == 0) {
                    if (i > size) {
                        left = 0;
                        right = i;
                    }
                } else if (map.containsKey(arr[i])) {
                    int temp = i - map.get(arr[i]) - 1;
                    if (temp > size) {
                        left = map.get(arr[i]) + 1;
                        right = i;
                    }
                } else {
                    map.put(arr[i], i);
                }
            }
            return Arrays.copyOfRange(array, left, right + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{4, 5, 6};
        String[] subarray = solution.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
        for (String s : subarray) {
            System.out.print(s);
        }
        System.out.println();
    }
}

