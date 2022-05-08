package incrStack;

import java.util.Stack;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例：
 * 0  1  2  3  4  5  6  7
 * 73,74,75,71,69,72,76,73
 * 1  1  4   2  1  1  0  0
 * <p>
 * 题解：https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
 */
public class dailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            if (temperatures == null) {
                return null;
            }
            int len = temperatures.length;
            if (len <= 0) {
                return null;
            }
            int[] res = new int[len];

            // 从底向上 递增 的 单调栈
            Stack<Integer> incrStack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!incrStack.isEmpty() && temperatures[i] > temperatures[incrStack.peek()]) {
                    // 计算 之前栈中堆积的元素的第 i 天数
                    res[incrStack.peek()] = i - incrStack.peek();
                    incrStack.pop();
                }
                // 还需要把当前的 index 推入 栈中
                incrStack.push(i);
            }
            return res;
        }
    }
}

