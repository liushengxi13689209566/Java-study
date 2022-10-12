import tree.TreeNode;

/*

 * */
public class Temp {
    static class Solution {
        public int c(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            if (n == 3) return 4;

            int dp[] = new int[n + 1];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= n; i++) {
                dp[i] = ((dp[i - 3] + dp[i - 2]) % 1000000007 + dp[i - 1]) % 1000000007;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {

    }
}

