package moni;

import java.util.TreeSet;

/*
https://leetcode.cn/problems/diving-board-lcci/
* 面试题 16.11. 跳水板
你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

示例 1

输入：
shorter = 1
longer = 2
k = 3
输出： [3,4,5,6]
解释：
可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
提示：

0 < shorter <= longer
0 <= k <= 100000
通过次数57,015提交次数129,777
*/
public class divingBoard {
    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k <= 0) {
                return new int[0];
            }
            TreeSet<Integer> resSet = new TreeSet<>();
            int min = shorter * k;
            resSet.add(min);
            for (int i = 0; i <= k; i++) {
                resSet.add(min - i * shorter + i * longer);
            }
            return resSet.stream().mapToInt(Integer::intValue).toArray();
        }
        // DFS 解题方法
        private TreeSet<Integer> intSet = new TreeSet<>();

        private void dfs(int res, int shorter, int longer, int k) {
            if (k <= 0) {
                if (res != 0) intSet.add(res);
                return;
            }
            dfs(res + shorter, shorter, longer, k - 1);
            dfs(res + longer, shorter, longer, k - 1);
        }

        public int[] divingBoardDFS(int shorter, int longer, int k) {
            dfs(0, shorter, longer, k);
            return intSet.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
