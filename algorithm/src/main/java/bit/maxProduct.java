package bit;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积 https://leetcode.cn/problems/aseY1I/
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2:
 * <p>
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * <p>
 * <p>
 * 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 */
public class maxProduct {
    class Solution {
        public int maxProduct(String[] words) {
            // 比较复杂的 位运算，面试用不到，忽略
            return 0;
        }
    }
}
