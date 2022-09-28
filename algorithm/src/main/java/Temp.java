import LinkList.ListNode;
import com.google.common.collect.Lists;

import java.util.*;

/*
 * */
public class Temp {
    static class Solution {
        private int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        /*
            行数 = matrix.length;
            列数 = matrix[0].length;
        */

        private boolean check(int xx, int yy, int[][] image) {
            int row = image.length;
            int col = image[0].length;
            if (xx < 0 || xx > row - 1) {
                return false;
            }
            if (yy < 0 || yy > col - 1) {
                return false;
            }
            return true;
        }

        private void dfs(int x, int y, int[][] image, int currColor, int newColor) {
            // 如果该节点 与 上一个 节点颜色相同才染色
            if (image[x][y] == currColor) {
                image[x][y] = newColor;
                for (int i = 0; i < 4; i++) {
                    int xx = x + dir[i][0];
                    int yy = y + dir[i][1];
                    if (check(xx, yy, image)) {
                        dfs(xx, yy, image, currColor, newColor);
                    }
                }
            }
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int currColor = image[sr][sc];
            // 如果 初始坐标点 与 新颜色 不同才染色，否则不染色。
            if (currColor != newColor) {
                dfs(sr, sc, image, currColor, newColor);
            }
            return image;
        }
    }

    public static void main(String[] args) {

    }
}

