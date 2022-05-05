package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 079. 所有子集
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class subsets {
    // 解法一：按照子集的长度进行 dfs 搜索。
    class Solution {
        private List<Integer> path = new ArrayList<>();
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null) {
                return null;
            }
            int n = nums.length;
            for (int k = 0; k <= n; k++) {
                // 每一个长度 k 的子集都从 index = 0 开始
                dfs(0, k, nums.length, nums);
            }
            return res;
        }

        private void dfs(int start, int k, int n, int[] nums) {
            if (k == 0) {
                res.add(new ArrayList<Integer>(path));
                return;
            }
            for (int i = start; i < n; i++) {
                path.add(nums[i]);
                dfs(i + 1, k - 1, n, nums);
                path.remove(path.size() - 1);
            }
        }
    }

    // 解法二：递归法实现子集枚举
    class Solution02 {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            // 考虑选择当前位置
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            // 考虑不选择当前位置
            dfs(cur + 1, nums);
        }
        // 解法三：实现所有三位数 01 字符串生成，0 表示不存在，1 表示存在。代码略
    }
}


