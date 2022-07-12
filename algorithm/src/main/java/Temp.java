import com.google.common.collect.Lists;

import java.util.*;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 思路：
 * （1）暴力解法肯定会超时
 */
public class Temp {
    static class Solution {
        public int[] subSort(int[] array) {
            if (array == null || array.length <= 1) {
                return new int[]{-1, -1};
            }
            int n = array.length;
            int maxx = Integer.MIN_VALUE;
            int minn = Integer.MAX_VALUE;

            int l = -1, r = -1;
            // 找
            for (int i = 0; i < n; ++i) {
                if (array[i] < maxx) r = i;
                else maxx = array[i];
            }
            for (int i = n - 1; i >= 0; --i) {
                if (array[i] > minn) l = i;
                else minn = array[i];
            }
            return new int[]{l, r};
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
//        solution.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
            solution.subSort(new int[]{1, 3, 9, 7, 5});
        }
    }
}

