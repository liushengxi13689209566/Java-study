package leftRight;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class findContinuousSequence {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            // 左右指针
            int left = 1;
            int right = 1;
            List<int[]> result = new ArrayList<>();
            int sum = 1;
            while (left <= right && right <= (target / 2 + 1)) {
                while (sum < target) {
                    right++;
                    sum += right;
                }
                //出循环后情况是：sum >= target
                if (sum == target) {
                    // 保存结果
                    int[] res = new int[right - left + 1];
                    for (int i = left; i <= right; i++) {
                        res[i - left] = i;
                    }
                    result.add(res);
                }
                // 慢慢 去掉左边的数值
                sum -= left;
                left++;
            }
            return result.toArray(new int[result.size()][]);
        }
    }
}
