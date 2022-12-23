package moni;

/*
https://leetcode.cn/problems/non-decreasing-array/description/

665. 非递减数列
中等
714
相关企业

给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

 

示例 1:

输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。

示例 2:

输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。

 

提示：

    n == nums.length
    1 <= n <= 104
    -105 <= nums[i] <= 105


举例：
[3,4,2,3]   false
[5,7,1,8]   5778

# 思路：
https://leetcode.cn/problems/non-decreasing-array/solutions/594975/3-zhang-dong-tu-bang-zhu-ni-li-jie-zhe-d-06gi/

* */
public class checkPossibility {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums == null) return false;
            if (nums.length <= 1) return true;
            int limit = 1;
            if (nums[0] > nums[1]) limit = 0;

            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int before = nums[i - 1];
                    int after = nums[i + 1];
                    //解决这种情况：[5,7,1,8]   5778
                    if (before > after) {
                        nums[i + 1] = nums[i];
                    }
                    //[3,4,2,3]   false
                    if (limit <= 0) {
                        return false;
                    }
                    limit--;
                }
            }
            return true;
        }
    }
}
