package math;

/**
 * @Date: 2022-04-10 21:51
 * @Author: liushengxi
 * @Description: 剑指 Offer 44. 数字序列中某一位的数字
 */
public class findNthDigit {
    class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            long start = 1;
            long count = 9;
            while (n > count) {
                n -= count;
                digit += 1;
                start *= 10;
                count = digit * start * 9;
            }
            long num = start + (n - 1) / digit;
            return Long.toString(num).charAt((n - 1) % digit) - '0';
        }
    }
}
