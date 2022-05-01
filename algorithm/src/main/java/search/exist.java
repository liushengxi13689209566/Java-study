package search;

/**
 * @Date: 2022-04-04 08:33
 * @Author: liushengxi
 * @Description: 剑指 Offer 12. 矩阵中的路径
 */
public class exist {


    class Solution {
        private char[][] globalBoard;
        private int m = 0;
        private int n = 0;
        private char[] wordChar;
        private int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


        private boolean check(int xx, int yy, int index) {
            if (xx < 0 || xx > m - 1) {
                return false;
            }
            if (yy < 0 || yy > n - 1) {
                return false;
            }
            if (globalBoard[xx][yy] != wordChar[index]) {
                return false;
            }
            return true;
        }

        private boolean dfs(int x, int y, int index) {
            if (index == wordChar.length - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if (this.check(xx, yy, index + 1)) {
                    globalBoard[xx][yy] = '0';
                    if (dfs(xx, yy, index + 1)) {
                        return true;
                    }
                    // 回溯回去
                    globalBoard[xx][yy] = wordChar[index + 1];
                }
            }
            return false;
        }

        public boolean exist(char[][] board, String word) {
            if (board == null || word == null) {
                return false;
            }
            m = board.length;
            if (m > 0) {
                n = board[0].length;
            }
            globalBoard = board;
            wordChar = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (this.check(i, j, 0)) {
                        globalBoard[i][j] = '0';
                        if (dfs(i, j, 0))
                            return true;
                        globalBoard[i][j] = wordChar[0];
                    }
                }
            }
            return false;
        }
    }


}


