package str;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 * <p>
 * 题目链接：https://leetcode.cn/problems/compress-string-lcci/
 */
public class compressString {
    class Solution {
        public String compressString(String S) {
            if (S == null || S.length() <= 1) {
                return S;
            }
            StringBuffer ans = new StringBuffer();
            int cnt = 1;
            char ch = S.charAt(0);
            for (int i = 1; i < S.length(); ++i) {
                if (ch == S.charAt(i)) {
                    cnt++;
                } else {
                    ans.append(ch);
                    ans.append(cnt);
                    ch = S.charAt(i);
                    cnt = 1;
                }
            }
            ans.append(ch);
            ans.append(cnt);
            return ans.length() >= S.length() ? S : ans.toString();
        }
    }
}
