package dp;

/*
面试题 16.17. 连续数列
给定一个整数数组，找出总和最大的连续数列，并返回总和。

示例：

输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶：

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

# 思路：
用一个变量记录连续数组的和,如果这个和小于0的时候(负数相加越加越小)取最大的数字
这个变量记录和的过程中判断输出连续数组的最大和

* */
public class maxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int s = 0;
            for (int num : nums) {
                if (s < 0) {
                    s = num;
                } else {
                    s += num;
                }
                max = Math.max(s, max);
            }
            return max;
        }
    }

}
