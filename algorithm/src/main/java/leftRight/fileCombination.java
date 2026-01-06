package leftRight;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 180. 文件组合
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。
 * 传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
 * 注意，返回时需遵循以下规则：
 * 每种组合按照文件编号 升序 排列；
 * 不同组合按照第一个文件编号 升序 排列。
 * 示例 1：
 * 输入：target = 12
 * 输出：[[3, 4, 5]]
 * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
 * 示例 2：
 * 输入：target = 18
 * 输出：[[3,4,5,6],[5,6,7]]
 * 解释：在上述示例中，存在两个连续正整数序列的和分别为 18，分别为 [3, 4, 5, 6] 和 [5, 6, 7]。
 * <p>
 * 提示：
 * 1 <= target <= 10^5
 *
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/description/
 * https://www.bilibili.com/video/BV1KP411L7VH?spm_id_from=333.788.player.switch&vd_source=15c95ececbffc4766ecf0c5baabd1e64&p=62
 *
 */
public class fileCombination {
    class Solution {
        public int[][] fileCombination(int target) {
            List<int[]> result = new ArrayList<>();
            int sum = 3;
            for (int i = 1, j = 2; i <= target / 2; ) {
                if (sum == target) {
                    // 接入结果
                    int[] temp = new int[j - i + 1];
                    int index = 0;
                    for (int k = i; k <= j; k++) {
                        temp[index++] = k;
                    }
                    result.add(temp);
                    // 需要移动游标
                    sum = sum - i;
                    i++;
                } else if (sum < target) {
                    j++;
                    sum = sum + j;
                } else if (sum > target) {
                    sum = sum - i;
                    i++;
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }
}
