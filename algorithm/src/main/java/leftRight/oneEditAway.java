package leftRight;

/*
*  https://leetcode.cn/problems/one-away-lcci/
* 面试题 01.05. 一次编辑

字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。



示例 1:

输入:
first = "pale"
second = "ple"
输出: True



示例 2:

输入:
first = "pales"
second = "pal"
输出: False

思路：见代码
* 时间：O(max(n,m))
* 空间：O(1)
*
*
* */
public class oneEditAway {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int len = first.length() - second.length();
            if (len > 1 || len < -1) {
                return false;
            }
            // 表示只能编辑一次
            int count = 1;
            for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
                if (first.charAt(i) != second.charAt(j)) {
                    // len 等于 1，说明 first 长于 second
                    // second要不要添加一个字符
                    if (len == 1) {
                        j--;
                        // len 等于 1，说明 first 短于 second
                        // second 要不要删除一个字符
                    } else if (len == -1) {
                        i--;
                    }
                    count--;
                }
                if (count < 0) {//最多编辑一次
                    return false;
                }
            }
            return true;
        }
    }
}
