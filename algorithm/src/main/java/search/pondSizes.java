package search;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/pond-sizes-lcci/

面试题 16.19. 水域大小
你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。

示例：

输入：
[
  [0,2,1,0],
  [0,1,0,1],
  [1,1,0,1],
  [0,1,0,1]
]
输出： [1,2,4]
提示：

0 < len(land) <= 1000
0 < len(land[i]) <= 1000
# TODO：思路 dfs
* */
public class pondSizes {
    class Solution {
        private int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1},
                {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};


        boolean check(int x, int y, int[][] land) {
            if (x < 0 || x > land.length - 1) return false;
            if (y < 0 || y > land[0].length - 1) return false;
            if (land[x][y] != 0) return false;
            return true;
        }

        public int[] pondSizes(int[][] land) {
            List<Integer> res = new ArrayList<>();
            int size = 0;
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[i].length; j++) {
                    if (land[i][j] == 0) {
                        size = dfs(i, j, land);
                        if (size > 0) res.add(size);
                    }
                }
            }
            //排序，但不去重
            res.sort(Integer::compareTo);
            // ArrayList 转 int数组
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

        private int dfs(int x, int y, int[][] land) {
            // 特别注意下面两点
            // 进入dfs，必然意味着通过了 check()
            int num = 1;
            //标记该点已经被搜过
            land[x][y] = -1;
            for (int i = 0; i < 8; i++) {
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if (check(xx, yy, land)) {
                    num += dfs(xx, yy, land);
                }
            }
            return num;
        }
    }
}
