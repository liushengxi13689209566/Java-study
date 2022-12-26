package other;

/*
给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。

返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。

示例 1:

输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]

示例 2:

输入: ["A","A"]

输出: []

举例：
[3,4,2,3]   false
[5,7,1,8]   5778

 * */
public class Temp {
    static class Solution {
        // 1，3，5，7，9，15，21,25,27,35,45
        public int getKthMagicNumber(int k) {
            int[] dp = new int[k + 4];
            dp[0] = 1;
            dp[1] = 3;
            dp[2] = 5;
            dp[3] = 7;
            if (k <= 3) {
                return dp[k - 1];
            }
            for (int i = 4; i < k; i++) {
                dp[i] = dp[i - 3] * 3;
                dp[i] = dp[i - 3] * 5;
                dp[i] = dp[i - 3] * 7;
            }
            return dp[k - 1];
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
        solution.getKthMagicNumber(9);
        System.out.println();
    }
}

