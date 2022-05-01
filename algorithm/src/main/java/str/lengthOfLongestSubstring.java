package str;

import java.util.HashMap;
import java.util.Map;

/**
 * pwwkew
 */
public class lengthOfLongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            // l 表示最左 r 表示最右，实现一个滑动窗口
            int left = 0;
            int right = left;
            int maxLen = 0;
            // 字符：下标位置
            Map<Character, Integer> strMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!strMap.containsKey(s.charAt(i))) {
                    strMap.put(s.charAt(i), i);
                    right++;
                } else {
                    maxLen = maxLen < right - left ? right - left : maxLen;
                    left = i;
                    right++;
                }
            }
            return maxLen;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.lengthOfLongestSubstring("pwwkew");
        }
    }
}
