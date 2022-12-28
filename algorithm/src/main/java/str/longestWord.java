package str;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.cn/problems/longest-word-lcci/description/?languageTags=java

面试题 17.15. 最长单词
中等
45
相关企业
给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。

示例：

输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
输出： "dogwalker"
解释： "dogwalker"可由"dog"和"walker"组成。
提示：

0 <= len(words) <= 200
1 <= len(words[i]) <= 100

# 思路：
https://leetcode.cn/problems/longest-word-lcci/solutions/901541/setzi-dian-shu-zu-pai-xu-su-du-93bao-mu-hewl7/?languageTags=java

set字典+数组排序，速度93%，保姆式讲解
解题思路
思路很简单，先把字符串数组按字符串长度进行排序，如果长度相同按字符串的字典序进行倒序

于是我们直接从字符串数组尾部开始寻找结果，对每个字符串直接使用暴力法，例如dogwalker
从第一个字符匹配到最后一个字符，每次往后移一个位置，都去判断当前字符之前的所有字符能否匹配一个字符串
流程如下 d ogwalker,d 字典中无匹配，后移 do gwalker,do 字典中无匹配，后移 dog walker,dog 字典有匹配,递归判断walker ......
* */
public class longestWord {
    class Solution {
        public String longestWord(String[] words) {
            // 降序排序:先按照长度排序，长度相同时，按照字典序排序
            Arrays.sort(words, ((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length()));

            Set<String> set = new HashSet<>();
            for (String word : words) {
                set.add(word);
            }

            for (String word : words) {
                //防止整个字符串与自身匹配返回true，且后续不会用到直接删除
                set.remove(word);

                // 递归判断是由那些单词组成
                if (check(word, set)) {
                    return word;
                }
            }
            return "";
        }

        private boolean check(String word, Set<String> set) {
            if (word.length() == 0) {
                return true;
            }
            for (int i = 1; i <= word.length(); i++) {
                // 0 ~ i-1
                if (set.contains(word.substring(0, i))) {
                    // i ~ word.length()-1
                    if (check(word.substring(i), set)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
