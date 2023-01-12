package other;

import java.util.*;

public class Temp {
    static class Solution {
        public int[] shortestSeq(int[] big, int[] small) {
            int bigLen = big.length;
            if (big == null || bigLen <= 0) {
                return new int[0];
            }
            Set<Integer> smallSet = new HashSet<>();
            for (int i = 0; i < small.length; i++) {
                smallSet.add(small[i]);
            }
            int left = 0;
            int right = 0;
            int[] retIndex = new int[2];
            retIndex[0] = -1;
            retIndex[1] = -1;

            int minLen = Integer.MAX_VALUE;

            Set<Integer> bigSet = new HashSet<>();

            while (left <= right) {
                if (bigSet.containsAll(smallSet)) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        retIndex[0] = left;
                        retIndex[1] = right - 1;
                    }
                    bigSet.remove(big[left]);
                    left++;
                } else {
                    if (right < bigLen) {
                        bigSet.add(big[right]);
                        right++;
                    } else {
                        left++;
                    }
                }
            }
            if (retIndex[0] == -1  && retIndex[1] == -1 )
                return new int[0];
            else
                return retIndex;
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
//        solution.shortestSeq(new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"});
        System.out.println(solution.shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9}));
        System.out.println(solution.shortestSeq(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println();
    }
}

