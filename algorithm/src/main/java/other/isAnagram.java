package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2022-02-22 23:27
 * @Author: liushengxi
 * @Description:
 */
public class isAnagram {
}


class Solution02 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            if (!countMap.containsKey(String.valueOf(s.charAt(i)))) {
                countMap.put(key, 1);
            } else {
                countMap.put(key, countMap.get(String.valueOf(s.charAt(i))) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            String key = String.valueOf(t.charAt(i));
            if (!countMap.containsKey(key)) {
                return false;
            }
            countMap.put(key, countMap.get(key) - 1);
            if (countMap.get(key) == 0) {
                countMap.remove(key);
            }
        }
        return countMap.isEmpty();
    }
}

