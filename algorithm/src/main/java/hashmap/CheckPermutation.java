package hashmap;

import java.util.HashMap;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class CheckPermutation {
    static class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return false;
            }
            char[] charS1 = s1.toCharArray();
            char[] charS2 = s2.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < charS1.length; i++) {
                map.put(charS1[i], map.getOrDefault(charS1[i], 0) + 1);
            }
            for (int i = 0; i < charS2.length; i++) {
                if (!map.containsKey(charS2[i])) {
                    return false;
                } else {
                    if ((map.get(charS2[i]) - 1) == 0) {
                        map.remove(charS2[i]);
                    } else {
                        map.put(charS2[i], map.get(charS2[i]) - 1);
                    }
                }
            }
            return map.isEmpty();
        }
    }
}
