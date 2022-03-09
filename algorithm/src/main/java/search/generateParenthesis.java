package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2022-03-08 23:34
 * @Author: liushengxi
 * @Description:
 */


public class generateParenthesis {


    class Solution {
        private List<String> result = new ArrayList<>();
        private int count;

        private void dfs(int left, int right, String path) {
            if (left == count && right == count) {
                result.add(path);
                return;
            }
            // 左括号没用完，就加 “(” 括号
            if (left < count) {
                dfs(left + 1, right, path + "(");
            }
            // 右括号没用完，就加 “)” 括号
            // 剪枝：
            // right < left 是因为 左括号数量一定要大于右括号，否则就是霸王硬上弓，直接上了右括号
            if (right < count && right < left) {
                dfs(left, right + 1, path + ")");
            }
        }

        public List<String> generateParenthesis(int n) {
            result.clear();
            count = n;
            if (n <= 0) {
                return result;
            }
            dfs(0, 0, "");
            return result;
        }
    }


}
