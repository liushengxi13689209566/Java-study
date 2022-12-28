package other;

import java.util.*;

public class Temp {
    static class Solution {
        public String longestWord(String[] words) {
            // 降序排序:先按照长度排序，长度相同时，按照字典序排序
            Arrays.sort(words, ((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length()));

            Set<String> set = new HashSet<>();
            for (String word : words) {
                set.add(word);
            }

            for (String word : words) {
                //防止整个字符串与自身匹配返回true，且后续不会用到直接删除
                set.remove(word);

                // 递归判断是由那些单词组成
                if (check(word, set)) {
                    return word;
                }
            }
            return "";
        }

        private boolean check(String word, Set<String> set) {
            if (word.length() == 0) {
                return true;
            }
            for (int i = 1; i <= word.length(); i++) {
                // 0 ~ i-1
                if (set.contains(word.substring(0, i))) {
                    // i ~ word.length()-1
                    if (check(word.substring(i), set)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};

        int[] B = new int[]{4, 2, 1};
//        String[] subarray = solution.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
//        for (String s : subarray) {
//            System.out.print(s);
//        }
        solution.longestWord(new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"});
        System.out.println();
    }
}

