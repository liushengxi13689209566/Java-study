package leftRight;

import java.util.Objects;

/*
https://leetcode.cn/problems/find-closest-lcci/
* 面试题 17.11. 单词距离
有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?


示例：

输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
输出：1
提示：

words.length <= 100000

# TODO 思路 本质上就是两个数字的互相转换，之后的 abs 操作结果
从左到右遍历数组 \words，当遍历到 word 1 时，如果已经遍历的单词中存在 word 2，为了计算最短距离，应该取最后一个已经遍历到的 word2
所在的下标，计算和当前下标的距离。同理，当遍历到 word2   时，应该取最后一个已经遍历到的 word1   所在的下标，计算和当前下标的距离。
作者：LeetCode-Solution
链接：https://leetcode.cn/problems/find-closest-lcci/solution/dan-ci-ju-chi-by-leetcode-solution-u96o/

进阶问题
如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，则可以维护一个哈希表记录每个单词的下标列表。
遍历一次文件，按照下标递增顺序得到每个单词在文件中出现的所有下标。在寻找单词时，只要得到两个单词的下标列表，
使用双指针遍历两个下标链表，即可得到两个单词的最短距离。


//0   1   2      3        4       5     6       7    8
["a","w","w","student","student","a","student","a","city"]
"a"         ==== index1 = 0 5 7
"student"   ==== index2 = 3 4 6

* */
public class findClosest {
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            //
            int leftIndex = -1;
            int rightIndex = -1;
            int res = Integer.MAX_VALUE;

            for (int i = 0; i < words.length; i++) {
                if (Objects.equals(words[i], word1)) {
                    leftIndex = i;
                } else if (Objects.equals(words[i], word2)) {
                    rightIndex = i;
                }
                if (leftIndex >= 0 && rightIndex >= 0) {
                    res = Math.min(res, Math.abs(rightIndex - leftIndex));
                }
            }
            return res;
        }
    }
}
