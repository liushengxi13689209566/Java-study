/**
 * @Date: 2022-03-01 22:38
 * @Author: liushengxi
 * @Description:
 */
public class majorityElement {
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            //注意这里：如果写为 == 1 的话，是不对的，因为判断的不一定是最后一位，而是某一位
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}

