package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Date: 2022-03-13 22:01
 * @Author: liushengxi
 * @Description:
 */
public class Test {
    class Solution {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            Set<String> ans = new HashSet<String>();
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    dfs(board, trie, i, j, ans);
                }
            }
            return new ArrayList<String>(ans);
        }

        public void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
            if (!now.children.containsKey(board[i][j])) {
                return;
            }
            char ch = board[i][j];
            now = now.children.get(ch);
            if (!"".equals(now.word)) {
                ans.add(now.word);
            }
            // 表示已访问过
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int xx = i + dir[0], yy = j + dir[1];
                if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length) {
                    dfs(board, now, xx, yy, ans);
                }
            }
            // 回溯时，恢复状态
            board[i][j] = ch;
        }
    }

    class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap<Character, Trie>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new Trie());
                }
                cur = cur.children.get(ch);
            }
            // word 保存最终的单词,其余 trie树 上面为空
            cur.word = word;
        }
    }
}
