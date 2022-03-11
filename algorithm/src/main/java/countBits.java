/**
 * @Date: 2022-03-05 14:24
 * @Author: liushengxi
 * @Description:
 */
public class countBits {
    class Solution {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            result[0] = 0;
            // 注意下标别越界了
            for (int i = 1; i <= n; i++) {
                // x 的二进制数量 就是 x&x-1 的二进制数量+1
                result[i] = result[i & i - 1] + 1;
            }
            return result;
        }
    }
}


