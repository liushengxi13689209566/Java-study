package hashmap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1331. 数组序号转换
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * 示例 2：
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * 示例 3：
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 * <p>
 * <p>
 * https://leetcode.cn/problems/rank-transform-of-an-array/
 * <p>
 * 思路：首先用一个数组保存排序完的原数组，然后用一个哈希表保存各元素的序号，最后将原属组的元素替换为序号后返回。
 */
public class arrayRankTransform {
    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            if (arr == null) {
                return null;
            }
            int n = arr.length;
            int[] res = new int[arr.length];
            HashMap<Integer, Integer> temp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                res[i] = arr[i];
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                if (!temp.containsKey(arr[i])) {
                    temp.put(arr[i], temp.size() + 1);
                }
            }

            for (int i = 0; i < n; i++) {
                res[i] = temp.get(res[i]);
            }
            return res;
        }
    }
}
