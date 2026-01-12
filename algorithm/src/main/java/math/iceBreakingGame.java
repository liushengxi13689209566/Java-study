package math;


/*
LCR 187. 破冰游戏
尝试过
简单
相关标签
premium lock icon
相关企业
社团共有 num 位成员参与破冰游戏，编号为 0 ~ num-1。成员们按照编号顺序围绕圆桌而坐。社长抽取一个数字 target，从 0 号成员起开始计数，排在第 target 位的成员离开圆桌，且成员离开后从下一个成员开始计数。请返回游戏结束时最后一位成员的编号。



示例 1：

输入：num = 7, target = 4
输出：1
示例 2：

输入：num = 12, target = 5
输出：0


提示：

1 <= num <= 10^5
1 <= target <= 10^6


思路：
x = f(num - 1, target)
f(num, target) = (target % num + x) % num = (target + x) % num
* */
public class iceBreakingGame {
    class Solution {
        public int iceBreakingGame(int num, int target) {
            if (num == 0) {
                return 0;
            }
            int res = 0;
            for (int i = 1; i <= num; i++) {
                res = (target + res) % i;
            }
            return res;
        }
    }
}
