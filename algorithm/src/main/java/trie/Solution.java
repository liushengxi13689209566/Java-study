package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2022-03-13 14:17
 * @Author: liushengxi
 * @Description:
 */

class Trie {
    Map<Character, Trie> children;
    boolean isEnd;

    public boolean isEnd() {
        return isEnd;
    }

    public Trie() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public void insert(String word) {
        // node 刚开始指向的是 trie 的 树根，以后依次向下指向，所以最后其 isEnd = true
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                // 注意 isEnd 都是 false
                node.children.put(ch, new Trie());
            }
            // 如果还是空，先创建，再移动 node 指针
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }

    public Trie helperSearchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.children.containsKey(ch)) {
                return null;
            }
            node = node.children.get(ch);
        }
        return node;
    }
}

class Solution {
    private static int rowDump;
    private static int colDump;

    private char[][] boardDump;

    private List<String> result;

    //上下左右 四个方向
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean isValid(int x, int y) {
        if (x < 0 || x > rowDump - 1) {
            return false;
        }
        if (y < 0 || y > colDump - 1) {
            return false;
        }
        return true;
    }

    private void dfs(Trie node, int row, int col, String value) {
        // 在 trie 树中找它
        node = node.helperSearchPrefix(String.valueOf(boardDump[row][col]));
        if (node == null) {
            return;
        }
        if (node != null && !node.isEnd()) {
            value += boardDump[row][col];
            node = node.children.get(boardDump[row][col]);
        }
        if (node != null && node.isEnd()) {
            result.add(value);
            return;
        }
        // 找 上下左右 四个方向
        for (int k = 0; k < 4; k++) {
            int xx = row + dir[k][0];
            int yy = col + dir[k][1];
            if (isValid(xx, yy)) {
                dfs(node, xx, yy, value + boardDump[row][col]);
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        if (board == null || words == null) {
            return result;
        }
        // 构造 trie 🌲
        Trie trieTree = new Trie();
        for (String word : words) {
            trieTree.insert(word);
        }
        // 遍历整个 board，搜索单词
        rowDump = board.length;
        colDump = board[0].length;
        boardDump = board;
        for (int i = 0; i < rowDump; i++) {
            for (int j = 0; j < colDump; j++) {
                dfs(trieTree, i, j, String.valueOf(board[i][j]));
            }
        }
        return result;
    }
}
