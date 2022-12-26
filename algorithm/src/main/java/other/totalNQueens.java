package other;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Date: 2022-02-22 13:18
 * @Author: liushengxi
 * @Description:
 */
public class totalNQueens {

}

class Solution88 {
    //撇 的特点是：x+y =c
    //捺 的特点是：x-y =c
    private void dfs(int n, int row, Set<Integer> colSet, Set<Integer> pieSet, Set<Integer> naSet) {
        // 找到其中一种解法
        if (row >= n) {
            result++;
            return;
        }
        //搜索 列 即可
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || pieSet.contains(row + col) || naSet.contains(row - col)) {
                continue;
            }
            //标记
            colSet.add(col);
            pieSet.add(row + col);
            naSet.add(row - col);
            dfs(n, row + 1, colSet, pieSet, naSet);
            //恢复
            colSet.remove(col);
            pieSet.remove(row + col);
            naSet.remove(row - col);
        }
    }

    int result = 0;

    public int totalNQueens(int n) {
        if (Objects.equals(null, n) || n <= 0) {
            return result;
        }
        Set<Integer> colSet = new HashSet<Integer>();
        Set<Integer> pieSet = new HashSet<Integer>();
        Set<Integer> naSet = new HashSet<Integer>();
        dfs(n, 0, colSet, pieSet, naSet);
        return result;
    }
}
