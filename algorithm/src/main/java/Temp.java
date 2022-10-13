import tree.TreeNode;

import java.util.Arrays;

/*
输入：{1, 3, 15, 11, 2},
{23, 127, 235, 19, 8}
输出：3，即数值对(11, 8)

 * */
public class Temp {
    static class Solution {
        public int smallestDifference(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            long res = Long.MAX_VALUE;
            for (int i = 0, j = 0; i < a.length && j < b.length; ) {
                if (a[i] == b[j]) return 0;
                long dif = a[i] - b[j];
                res = Math.min(Math.abs(dif), res);
                if (dif < 0) {
                    i++;
                } else {
                    j++;
                }
            }
            return (int) res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{-2147483648, 1};
        int[] b = new int[]{2147483647, 0};
        solution.smallestDifference(a, b);
    }
}

