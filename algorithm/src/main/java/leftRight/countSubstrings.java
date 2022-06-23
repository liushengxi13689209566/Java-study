package leftRight;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/
 * <p>
 * 思路：中心扩散思想 ，时间 复杂度 O(n^2)
 */
class Solution {
    public int countSubstrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArray.length; i++) {
            res += countPalindrome(charArray, i, i);
            res += countPalindrome(charArray, i, i + 1);
        }
        return res;
    }

    private int countPalindrome(char[] charArray, int start, int end) {
        int count = 0;
        while (start >= 0 && end < charArray.length && charArray[start] == charArray[end]) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
