package dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Date: 2022-04-01 23:42
 * @Author: liushengxi
 * @Description: 823. 带因子的二叉树
 */
public class numFactoredBinaryTrees {


    class Solution {
        public int numFactoredBinaryTrees(int[] arr) {
            if (arr == null) {
                return 0;
            }
            // 设 dp(v) 是以 v 为根节点的树种类数。
            // 其子节点就是 x*y = v
            // dp[v] =  dp(x) * dp(y)
            // 为了快速的计算，我们使用 index 数组快速查找：如果 A[k] = A[i] / A[j]，那么 index[A[i] / A[j]] = k
            long[] dp = new long[arr.length];
            Arrays.fill(dp, 1);

            //在上面的例子中我们知道 x < v 和 y < v，我们可以用动态规划的方法按照升序值计算 dp[i] 的值
            Arrays.sort(arr);

            // arr 数值：index
            HashMap<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                index.put(arr[i], i);
            }

            int MOD = 1_000_000_007;

            for (int i = 0; i < arr.length; i++) {
                // 在数组中 找 i 的所有因子
                for (int j = 0; j < i; j++) {
                    if (arr[i] % arr[j] == 0) {
                        int right = arr[i] / arr[j];
                        if (index.containsKey(right)) {
                            dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                        }
                    }
                }
            }
            long res = 0;
            for (long l : dp) {
                res += l;
            }
            return (int) (res % MOD);
        }
    }


}

