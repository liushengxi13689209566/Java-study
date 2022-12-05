import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/*
面试题 17.06. 2出现的次数
编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
示例:
输入: 25
输出: 9
解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
提示：
n <= 10^9
 * */
public class Temp {
    static //输入：words =
//["I","am","a","student","from","a","university","in","a","student"],
// word1 = "student", word2 = "a"
//输出：1
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{-2147483648, 1};
        int[] b = new int[]{2147483647, 0};
//        solution.numberOf2sInRange(25);
    }
}

