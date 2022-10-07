import LinkList.ListNode;
import com.google.common.collect.Lists;

import java.util.*;

/*

 * */
public class Temp {
    static class Solution {
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
    }

    public static void main(String[] args) {

    }
}

