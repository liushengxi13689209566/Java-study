import com.google.common.collect.Lists;

import java.util.*;


public class Temp {
    static class Solution {
        private static  int res = 0;
        public int countSubstrings(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                countPalindrome(res, charArray, i, i);
                countPalindrome(res, charArray, i, i + 1);
            }
            return res;
        }

        private void countPalindrome(int res, char[] charArray, int start, int end) {
            while (start >= 0 && end < charArray.length && charArray[start] == charArray[end]) {
                res++;
                start--;
                end++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countSubstrings("abc");
    }
}

