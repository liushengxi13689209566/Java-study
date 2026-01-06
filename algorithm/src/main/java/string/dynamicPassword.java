package string;

/*
LCR 182. 动态口令
已解答
简单
相关标签
premium lock icon
相关企业
某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：

设定一个正整数目标值 target
将 password 前 target 个字符按原顺序移动至字符串末尾
请返回更新后的密码字符串。

示例 1：

输入: password = "s3cur1tyC0d3", target = 4
输出: "r1tyC0d3s3cu"
示例 2：

输入: password = "lrloseumgh", target = 6
输出: "umghlrlose"


提示：

1 <= target < password.length <= 10000
https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
https://www.bilibili.com/video/BV1KP411L7VH?share_source=copy_web&vd_source=84bc93df2b2303ee8b4b580aaaaec521&spm_id_from=333.788.player.switch&p=65

* */
public class dynamicPassword {
    class Solution {
        public String dynamicPassword(String password, int target) {
            if (password == null || password.isEmpty()) {
                return password;
            }
            int len = password.length();
            StringBuilder sb = new StringBuilder();
            for (int i = target; i < target + len; i++) {
                sb.append(password.charAt(i % len));
            }
            return sb.toString();
        }
    }
}
