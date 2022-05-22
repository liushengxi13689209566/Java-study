package greedy;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * https://leetcode.cn/problems/RQku0D
 * <p>
 * 思路：首先考虑如果不允许删除字符，如何判断一个字符串是否是回文串。常见的做法是使用双指针。定义左右指针，
 * 初始时分别指向字符串的第一个字符和最后一个字符，每次判断左右指针指向的字符是否相同，如果不相同，则不是回文串；
 * 如果相同，则将左右指针都往中间移动一位，直到左右指针相遇，则字符串是回文串。
 * <p>
 * 在允许最多删除一个字符的情况下，同样可以使用双指针，通过贪心实现。
 * 初始化两个指针 \textit{low}low 和 \textit{high}high 分别指向字符串的第一个字符和最后一个字符。
 * 每次判断两个指针指向的字符是否相同，如果相同，则更新指针，将 \textit{low}low 加 11，\textit{high}high 减 11，
 * 然后判断更新后的指针范围内的子串是否是回文字符串。如果两个指针指向的字符不同，则两个字符中必须有一个被删除，
 * 此时我们就分成两种情况：即删除左指针对应的字符，留下子串 s[\textit{low} + 1 : \textit{high}]s[low+1:high]，
 * 或者删除右指针对应的字符，留下子串 s[\textit{low} : \textit{high} - 1]s[low:high−1]。
 * 当这两个子串中至少有一个是回文串时，就说明原始字符串删除一个字符之后就以成为回文串。
 * <p>
 * 链接：https://leetcode.cn/problems/RQku0D/solution/zui-duo-shan-chu-yi-ge-zi-fu-de-dao-hui-30b55/
 */
public class validPalindrome {
    class Solution {
        public boolean validPalindrome(String s) {
            int len = s.length();
            if (len <= 1) {
                return true;
            }
            int left = 0;
            int right = len - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return isPalindrome(s, left + 1, right)
                            || isPalindrome(s, left, right - 1);
                }
            }
            return true;
        }

        private boolean isPalindrome(String s, int low, int high) {
            for (int i = low, j = high; i < j; ++i, --j) {
                char c1 = s.charAt(i), c2 = s.charAt(j);
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }
    }
}

