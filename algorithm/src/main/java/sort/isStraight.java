package sort;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * (搞不明白为啥 1，2，5 还是顺子呐？因为 大小王可以是 任意数字，在这里就代表 3，,4)
 * <p>
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13]
 */
public class isStraight {
    class Solution {
        public boolean isStraight(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return true;
            }
            Arrays.sort(nums);
            //如果有大小王，那么它们一定在最前面
            int kings = 0;
            for (int i = 0; i < 4; i++) {
                if (nums[i] == 0) {
                    kings++;
                    continue;
                }
                // 有重复的牌，提前返回。
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
            }
            // 重点：最大的牌 - 最小的牌 < 5
            return nums[4] - nums[kings] < 5 ? true : false;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            System.out.println(solution.isStraight(new int[]{1, 2, 12, 0, 3}));
//        }
    }
}
