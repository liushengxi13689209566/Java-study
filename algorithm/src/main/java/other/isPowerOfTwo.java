package other;

/**
 * @Date: 2022-03-05 14:19
 * @Author: liushengxi
 * @Description:
 */
public class isPowerOfTwo {
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // 所有的2的幂都是 0000000x000000，所以剔除最后一位后都是等于0
        return (n & (n - 1)) == 0;
    }
}
