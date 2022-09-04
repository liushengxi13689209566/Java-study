package leftRight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2022-03-17 12:54
 * @Author: liushengxi
 * @Description:
 */
public class Window {
    // 3. 优化后的滑动窗口
// 时间复杂度：O(n)
// 空间复杂度：O(n)
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if (n <= 1) return n;
            int maxLen = 1;

            // l 表示最左 r 表示最右，实现一个滑动窗口
            int left = 0, right = 0;
            // 字符：下标位置
            Map<Character, Integer> window = new HashMap<>();
            while (right < n) {
                char rightChar = s.charAt(right);
                // 想想 abba 的情况。 left 必须取大值
                if (window.containsKey(Character.valueOf(rightChar))) {
                    left = Math.max(window.get(rightChar) + 1, left);
                }
                maxLen = Math.max(maxLen, right - left + 1);
                window.put(rightChar, right);
                right++;
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abba");
    }
}


