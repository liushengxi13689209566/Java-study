package other;

import java.util.TreeSet;

/**
 * @Date: 2022-03-21 23:16
 * @Author: liushengxi
 * @Description:
 */
public class nthUglyNumber {
//    class Solution {
//        public int nthUglyNumber(int n) {
//            if (n <= 0) {
//                return 0;
//            }
//            TreeSet<Long> set = new TreeSet<>();
//            Long res = null;
//            set.add(1L);
//            for (int i = 1; i <= n; i++) {
//                res = set.pollFirst();
//                set.add(res * 2);
//                set.add(res * 3);
//                set.add(res * 5);
//            }
//            return res.intValue();
//        }
//    }

    class Solution {
        public int nthUglyNumber(int n) {
            int a = 1;
            int b = 1;
            int c = 1;
            // 表示 第 i 个丑数
            int dp[] = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(dp[a] * 2, Math.min(dp[b] * 3, dp[c] * 5));
                if (dp[i] == dp[a] * 2) a++;
                if (dp[i] == dp[b] * 3) b++;
                if (dp[i] == dp[c] * 5) c++;
            }
            return dp[n];
        }
    }
}


