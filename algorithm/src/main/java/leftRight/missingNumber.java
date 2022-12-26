package leftRight;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/description/
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
 * <p>
 * <p>
 * https://leetcode.cn/problems/missing-number-lcci/
 * 面试题 17.04. 消失的数字
 * 简单
 * 84
 * 相关企业
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,0,1]
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
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

    class Solution2 {
        public int missingNumber(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return -1;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i <= nums.length; i++) {
                set.add(i);
            }
            for (int num : nums) {
                set.remove(num);
            }
            return new ArrayList<>(set).get(0);
        }
    }
    // 使用：高斯公式 sum = n(n+1)/2
    class Solution3 {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int total = n * (n + 1) / 2;
            int arrSum = 0;
            for (int i = 0; i < n; i++) {
                arrSum += nums[i];
            }
            return total - arrSum;
        }
    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/missing-number-lcci/solutions/1503157/xiao-shi-de-shu-zi-by-leetcode-solution-8fjd/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
