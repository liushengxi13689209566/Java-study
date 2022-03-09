/**
 * @Date: 2022-03-05 14:00
 * @Author: liushengxi
 * @Description:
 */
public class hammingWeight {

}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            // 剔除最后一位 0
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
