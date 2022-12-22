package prefixAdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 面试题 17.05. 字母与数字
中等
57
相关企业

给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。

返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。

示例 1:

输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]

示例 2:

输入: ["A","A"]

输出: []

提示：

    array.length <= 100000

# 思路：前缀和
*
*https://leetcode.cn/problems/find-longest-subarray-lcci/solutions/267471/mian-shi-ti-1705-zi-mu-yu-shu-zi-by-beecaffe/
*
*
* */
public class findLongestSubarray {
    class Solution {
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
                // 计算此时最长的长度
                int size = right - left;
                if (arr[i] == 0) {
                    // 表示：0～i 加起来是 0
                    if (i > size) {
                        left = 0;
                        right = i;
                    }
                } else if (map.containsKey(arr[i])) {
                    // 表示：0～i 和 0～map.get(arr[i]) 加起来相等。
                    // 因此 map.get(arr[i])～i 一定加起来为零（左开右闭）
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
}
