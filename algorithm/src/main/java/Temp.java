import LinkList.ListNode;
import com.google.common.collect.Lists;

import java.util.*;

/*

 * */
public class Temp {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int s = 0;
            for (int num : nums) {
                if (s < 0) {
                    s = num;
                } else {
                    s += num;
                }
                max =  Math.max(s,max);
            }
            return max;
        }
    }

    public static void main(String[] args) {

    }
}

