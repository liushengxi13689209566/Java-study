package leftRight;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 定义 cnt[i] 表示 nums 数组中小于等于 i 的数有多少个，
 * 假设我们重复的数是 target，那么 [1,target−1]里的所有数满足 cnt[i]≤i，
 * [target,n] 里的所有数满足 ccnt[i]>i，具有单调性。
 * 示例一：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>
 * 统计结果则如下：
 * nums	1	2	3	4
 * cnt	1	3	4	5
 *
 * <p>
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
 */
public class findDuplicate {
    class Solution {
        public int findDuplicate(int[] nums) {
            if (nums == null) {
                return -1;
            }
            int len = nums.length;
            if (len <= 0) {
                return -1;
            }
            int left = 0, right = len - 1;
            int res = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                int count = 0;
                for (int i = 0; i < len; i++) {
                    if (nums[i] <= mid) {
                        count++;
                    }
                }
                // 与 mid 比较，这里的二分 分的是数组的下标，所以可以使用二分
                if (count <= mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    // 直接记录 mid 就可以了
                    res = mid;
                }
            }
            return res;
        }
    }
}

