package str;

/**
 * @Date: 2022-04-09 09:47
 * @Author: liushengxi
 * @Description: 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class minWindow {
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null) {
                return "";
            }
            int sLen = s.length();
            int tLen = t.length();
            if (sLen == 0 || tLen == 0 || sLen < tLen) {
                return "";
            }
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            // 词频数组
            int[] winFreq = new int[128];
            int[] tFreq = new int[128];
            for (char ch : tChars) {
                tFreq[ch]++;
            }

            int left = 0;
            int right = 0;
            // 表示：滑动窗口内部包含了 T 中字符的个数，而不是滑动窗口的长度。
            // 窗口中单个字符个数等于 T 中对应的字符个数的时候就不再增加。
            int distance = 0;
            int begin = 0;
            int minLen = sLen + 1;

            while (right < sLen) {
                //如果右边的字符在 t 中没有出现
                if (tFreq[sChars[right]] == 0) {
                    right++;
                    continue;
                }
                // @TODO 核心
                if (winFreq[sChars[right]] < tFreq[sChars[right]]) {
                    distance++;
                }
                // 第一次在 t 中出现
                winFreq[sChars[right]]++;
                right++;

                //已经包含了 t 中所有的字符了
                while (distance == tLen) {
                    if (right - left < minLen) {
                        minLen = right - left;
                        begin = left;
                    }
                    //如果左边的字符在 t 中没有出现
                    if (tFreq[sChars[left]] == 0) {
                        left++;
                        continue;
                    }
                    // @TODO 核心
                    if (winFreq[sChars[left]] == tFreq[sChars[left]]) {
                        distance--;
                    }
                    // 词频数组减少
                    winFreq[sChars[left]]--;
                    left++;
                }
            }
            if (minLen == sLen + 1) {
                return "";
            }
            return s.substring(begin, begin + minLen);
        }
    }
}


