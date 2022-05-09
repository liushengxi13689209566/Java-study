package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 * <p>
 * https://leetcode.cn/problems/7p8L0Z/
 */
public class permuteUnique {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) {
                return null;
            }
            int len = nums.length;
            if (len <= 0) {
                return null;
            }
            dumpLen = len;
            // 需要标记数组
            visted = new boolean[len];
            dfs(new ArrayList<>(), nums);
            return new ArrayList<>(res);
        }

        private Set<List<Integer>> res = new HashSet<>();
        private int dumpLen = 0;
        private boolean[] visted;

        private void dfs(List<Integer> onePath, int[] nums) {
            if (onePath.size() == dumpLen) {
                res.add(new ArrayList<>(onePath));
                return;
            }
            for (int i = 0; i < dumpLen; i++) {
                if (visted[i] == false) {
                    onePath.add(nums[i]);
                    visted[i] = true;
                    dfs(onePath, nums);
                    onePath.remove(onePath.size() - 1);
                    visted[i] = false;
                }
            }
        }
    }
}
