package dp;

/*LCR 188. 买卖芯片的最佳时机
已解答
中等
相关标签
premium lock icon
相关企业
数组 prices 记录了某芯片近期的交易价格，其中 prices[i] 表示的 i 天该芯片的价格。你只能选择 某一天 买入芯片，并选择在 未来的某一个不同的日子 卖出该芯片。请设计一个算法计算并返回你从这笔交易中能获取的最大利润。

如果你不能获取任何利润，返回 0。



示例 1：

输入：prices = [3, 6, 2, 9, 8, 5]
输出：7
解释：在第 3 天（芯片价格 = 2）买入，在第 4 天（芯片价格 = 9）卖出，最大利润 = 9 - 2 = 7。
示例 2：

输入：prices = [8, 12, 15, 7, 3, 10]
输出：7
解释：在第 5 天（芯片价格 = 3）买入，在第 6 天（芯片价格 = 10）卖出，最大利润 = 10 - 3 = 7。


提示：

0 <= prices.length <= 10^5
0 <= prices[i] <= 10^4


注意：本题与主站 121 题相同：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
* https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 思路：
 显然，如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！
 太好了，在题目中，我们只要用一个变量记录一个历史最低价格 minprice，
 我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。

因此，我们只需要遍历价格数组一遍，记录历史最低点，
然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，
那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
* */
public class bestTiming {
    class Solution {
        public int bestTiming(int[] prices) {
            if (prices == null) {
                return 0;
            }
            int len = prices.length;
            int minPrice = Integer.MAX_VALUE;
            int res = 0;
            for (int i = 0; i < len; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                res = Math.max(res, prices[i] - minPrice);
            }
            return res;
        }
    }
}
