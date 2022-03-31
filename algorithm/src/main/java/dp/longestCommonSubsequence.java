package dp;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Date: 2022-03-28 21:13
 * @Author: liushengxi
 * @Description:
 */
public class longestCommonSubsequence {
    class Solution {
        public void fun(String str1) {
            if (str1 == null || "".equals(str1)) {
                System.out.println("");
            }
            String[] stringList = str1.split("_");
            TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.comparing());
            for (String s : stringList) {
                if (treeMap.containsKey(s)) {
                    Integer tmp = treeMap.get(s);
                    treeMap.put(s, tmp++);
                } else {
                    treeMap.put(s, 1);
                }
            }
            treeMap.forEach((k, v) -> {
                System.out.println("k:" + k + " v:" + v);
            });
        }
    }
}

class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        if (str1 == null || "".equals(str1) || str2 == null || "".equals(str2)) {
            return 0;
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) != str2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                } else {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                maxLen = Math.max(maxLen, dp[i + 1][j + 1]);
            }
        }
        return maxLen;
    }
}
