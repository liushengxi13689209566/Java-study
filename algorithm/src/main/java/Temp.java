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
 * "horse"
 * "ros"
 * "pale"
 * "ple"
 * "pales"
 * "pal"
 * "inten tion"
 * "execu tion"
 */
public class Temp {
    static class Solution {
        public boolean oneEditAway(String first, String second) {
            int len = first.length() - second.length();
            if (len > 1 || len < -1) {
                return false;
            }
            // 表示只能编辑一次
            int count = 1;
            for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
                if (first.charAt(i) != second.charAt(j)) {
                    // len 等于 1，说明 first 长于 second
                    // second要不要添加一个字符
                    if (len == 1) {
                        j--;
                        // len 等于 1，说明 first 短于 second
                        // second 要不要删除一个字符
                    } else if (len == -1) {
                        i--;
                    }
                    count--;
                }
                if (count < 0) {//最多编辑一次
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
//        solution.subSort(new int[]{1, 3, 9, 7, 5});
    }
}

