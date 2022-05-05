package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/SsGoHC/
 * <p>
 * 剑指 Offer II 074. 合并区间
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class merge {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null) {
                return null;
            }
            int lens = intervals.length;
            if (lens <= 0) {
                return new int[0][0];
            }
            List<int[]> resList = new ArrayList<>();
            // (1) 先按照左端点排好序
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            resList.add(intervals[0]);
            for (int i = 1; i < lens; i++) {
                int L = intervals[i][0];
                int R = intervals[i][1];
                // (2) 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，
                // 我们可以直接将这个区间加入数组 merged 的末尾；

                // (3) 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
                if (L > resList.get(resList.size() - 1)[1]) {
                    resList.add(intervals[i]);
                } else {
                    resList.get(resList.size() - 1)[1] = Math.max(resList.get(resList.size() - 1)[1], R);
                }
            }
            return resList.toArray(new int[resList.size()][]);
        }
    }
}

