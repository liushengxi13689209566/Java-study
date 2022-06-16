package leftRight;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * 限制：
 * 1 <= 数组长度 <= 10000
 */
public class missingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            if (nums == null) {
                return -1;
            }
            // 数值等于下标（这里也可以直接）
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return len;
        }
    }
}
