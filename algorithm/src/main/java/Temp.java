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
        public int[] swapNumbers(int[] numbers) {
            numbers[0]=numbers[0]^numbers[1];
            numbers[1]=numbers[0]^numbers[1];
            numbers[0]=numbers[0]^numbers[1];
            return numbers;
        }
    }

        public static void main(String[] args) {
            Solution solution = new Solution();
        }
    }
}

