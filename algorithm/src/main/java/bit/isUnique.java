package bit;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * 题目链接：https://leetcode.cn/problems/is-unique-lcci/
 * 思路；
 * 把int的前26位的二进制当做boolean数组，其中0代表不存在，1代表存在； 接下来最重要的是字符串转化为数组的思路： int num = 0；
 * 为初始化的长度为32的空字符串 k为第i个字符所在的索引位置；
 * 判断第k个位置是否存在使用： num & 1<<k != 0 则存在
 * 改变第k个位置为存在 num = num | 1<<k
 */
public class isUnique {
    class Solution {
        public boolean isUnique(String astr) {
            if (astr == null || astr.length() <= 1) {
                return true;
            }
            int mask = 0;
            for (int i = 0; i < astr.length(); i++) {
                int k = astr.charAt(i) - 'a';
                if ((mask & 1 << k) != 0) {
                    return false;
                }
                mask = mask | 1 << k;
            }
            return true;
        }
    }
}
