import java.util.TreeSet;

/**
 * @Date: 2022-03-21 23:16
 * @Author: liushengxi
 * @Description:
 */
public class nthUglyNumber {
    class Solution {
        public int nthUglyNumber(int n) {
            if (n <= 0) {
                return 0;
            }
            TreeSet<Long> set = new TreeSet<>();
            Long res = null;
            set.add(1L);
            for (int i = 1; i <= n; i++) {
                res = set.pollFirst();
                set.add(res * 2);
                set.add(res * 3);
                set.add(res * 5);
            }
            return res.intValue();
        }
    }
}


