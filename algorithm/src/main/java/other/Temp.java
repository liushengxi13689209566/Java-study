package other;

/*
给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。

返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。

示例 1:

输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]

输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]

示例 2:

输入: ["A","A"]

输出: []

举例：
[3,4,2,3]   false
[5,7,1,8]   5778

 * */
public class Temp {
    static class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums == null) return false;
            if (nums.length <= 1) return true;
            int limit = 1;
            if (nums[0] > nums[1]) limit = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int before = nums[i - 1];
                    int after = nums[i + 1];
                    //解决这种情况：[5,7,1,8]   5778
                    if (before > after) {
                        nums[i + 1] = nums[i];
                    }
                    if (limit <= 0) {
                        return false;
                    }
                    limit--;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};

        int[] B = new int[]{4, 2, 1};
//        String[] subarray = solution.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
//        for (String s : subarray) {
//            System.out.print(s);
//        }
        solution.checkPossibility(B);
        System.out.println();
    }
}

