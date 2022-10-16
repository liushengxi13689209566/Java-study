import tree.TreeNode;

import java.util.Arrays;
import java.util.Objects;

/*
面试题 17.06. 2出现的次数
编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
示例:
输入: 25
输出: 9
解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
提示：
n <= 10^9
 * */
public class Temp {
    static //输入：words =
//["I","am","a","student","from","a","university","in","a","student"],
// word1 = "student", word2 = "a"
//输出：1
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            //
            int leftIndex = -1;
            int rightIndex = -1;
            int res = Integer.MAX_VALUE;

            for (int i = 0; i < words.length; i++) {
                if (Objects.equals(words[i], word1)) {
                    leftIndex = i;
                } else if (Objects.equals(words[i], word2)) {
                    rightIndex = i;
                }
                if (leftIndex >= 0 && rightIndex >= 0) {
                    res = Math.min(res, Math.abs(rightIndex - leftIndex));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{-2147483648, 1};
        int[] b = new int[]{2147483647, 0};
//        solution.numberOf2sInRange(25);
    }
}

