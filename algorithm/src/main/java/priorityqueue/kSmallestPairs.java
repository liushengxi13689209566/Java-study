package priorityqueue;

import java.util.*;

/**
 * https://leetcode.cn/problems/qn8gGX/
 * <p>
 * 剑指 Offer II 061. 和最小的 k 个数对
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums1.length, nums2.length <= 104
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 373 题相同：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * <p>
 * 思想：针对(ai，bi) 的下一个节点一定是 (ai+1，bi)(ai，bi+1)，其中 ai 与 bi 都表示下边索引值。
 * 然后使用一个 容量为k的优先队列即可。
 */
public class kSmallestPairs {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0) {
                return res;
            }
            // 小顶堆
            PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
            int m = nums1.length;
            int n = nums2.length;
            for (int i = 0; i < Math.min(m, k); i++) {
                pq.offer(new int[]{i, 0});
            }
            while (k-- > 0 && !pq.isEmpty()) {
                int[] idxPair = pq.poll();
                List<Integer> list = new ArrayList<>();
                list.add(nums1[idxPair[0]]);
                list.add(nums2[idxPair[1]]);
                res.add(list);
                if (idxPair[1] + 1 < n) {
                    pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
                }
            }
            return res;
        }
    }
}
