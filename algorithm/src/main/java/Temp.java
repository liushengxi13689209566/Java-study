import com.google.common.collect.Lists;

import java.util.*;

public class Temp {
    static class Solution {
        // 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
        // 若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。最后再判断它是否符合条件。
        public int majorityElement(int[] nums) {
            if (nums == null) return -1;

            int value = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                // 若当前无人生还，跟踪下一位士兵的势力
                if (count == 0) {
                    value = nums[i];
                }
                // 下一位士兵是自己人，那么幸存人数++
                if (value == nums[i]) count++;
                // 来了个敌人，同归于尽，幸存人数--
                else count--;
            }
            count = 0;
            for (int num : nums) {
                if (num == value) {
                    count++;
                }
            }
            return count > nums.length / 2 ? value : -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.majorityElement(new int[]{3, 3, 4});
//        solution.subSort(new int[]{1, 3, 9, 7, 5});
    }
}

