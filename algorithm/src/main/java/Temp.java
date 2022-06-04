import com.google.common.collect.Lists;

import java.util.*;


public class Temp {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.CheckPermutation("asvnpzurz", "urzsapzvn");
    }
}

