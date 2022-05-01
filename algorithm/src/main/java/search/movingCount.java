package search;

/**
 * @Date: 2022-04-11 10:00
 * @Author: liushengxi
 * @Description: 剑指 Offer 13. 机器人的运动范围
 */
public class movingCount {
    class Solution {

        private int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        private int result;
        private int m_dump;
        private int n_dump;
        private int k_dump;

        private boolean check(int xx, int yy, int[][] visted) {
            if (xx < 0 || xx > m_dump) {
                return false;
            }
            if (yy < 0 || yy > n_dump) {
                return false;
            }
            if (visted[xx][yy] != 0) {
                return false;
            }
            return true;

        }

        void dfs(int x, int y, int[][] visted) {
            if (fun(x) + fun(y) <= k_dump) {
                result++;
            }
            for (int i = 0; i < 4; i++) {
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if (check(xx, yy, visted)) {
                    visted[xx][yy] = 1;
                    dfs(xx, yy, visted);
                }
            }
        }

        public int movingCount(int m, int n, int k) {
            if (m == 0 && n == 0) {
                return 0;
            }
            m_dump = m;
            n_dump = n;
            k_dump = k;
            result = 1;

            int visted[][] = new int[m][n];
            visted[0][0] = 1;
            dfs(0, 0, visted);
            return result;
        }

        private int fun(int num) {
            int res = 0;
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }
            return res;
        }

        public void main(String[] args) {
            System.out.println(fun(139));
        }
    }
}
