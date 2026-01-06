package leftRight;

/*
* LCR 181. 字符串中的单词反转
已解答
简单
相关标签
premium lock icon
相关企业
你在与一位习惯从右往左阅读的朋友发消息，他发出的文字顺序都与正常相反但单词内容正确，为了和他顺利交流你决定写一个转换程序，把他所发的消息 message 转换为正常语序。

注意：输入字符串 message 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。



示例 1：

输入: message = "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: message = "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: message = "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


提示：

0 <= message.length <= 104
message 中包含英文大小写字母、空格和数字
注意：

本题与主站 151 题相同：https://leetcode.cn/problems/reverse-words-in-a-string/
https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/description/
*
* https://www.bilibili.com/video/BV1KP411L7VH/?p=63&share_source=copy_web&vd_source=84bc93df2b2303ee8b4b580aaaaec521
* */
public class reverseMessage {
    class Solution {
        public String reverseMessage(String message) {
            if (message == null || message.isEmpty()) {
                return message;
            }
            message = message.trim();
            int left = message.length() - 1;
            int right = left;

            StringBuilder sb = new StringBuilder();
            while (left >= 0) {
                while (left >= 0 && message.charAt(left) != ' ') left--;
                sb.append(message.substring(left + 1, right + 1) + " ");
                while (left >= 0 && message.charAt(left) == ' ') left--;
                right = left;
            }
            return sb.toString().trim();
        }
    }
}
