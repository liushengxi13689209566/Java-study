/*
package dp;

*/
/**
 * @Date: 2022-04-01 13:17
 * @Author: liushengxi
 * @Description: 01背包 和 完全背包
 *//*

public class Backpack_01 {
    //01 背包
    public void fun() {
        for (int i = 1; i <= n; i++) {
            // 必须逆向枚举!!!
            for (int j = m; j >= v[i]; j--) {
                dp[j] = Max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
    }

    //完全背包
    public void fun02() {
        for (int i = 1; i <= n; i++) {
            // 必须正向枚举!!!
            for (int j = v[i]; j <= m; j++) {
                dp[j] = Max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
    }
}



*/
