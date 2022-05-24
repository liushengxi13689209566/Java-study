package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 035. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 * <p>
 * <p>
 * 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/
 */
public class findMinDifference {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            // 直接排序后，两两相邻之间 再求差值
            // 首尾还需要单独计算一下
            Collections.sort(timePoints);
            int result = Integer.MAX_VALUE;
            int pre = getMinutes(timePoints.get(0));
            int t0Minutes = pre;
            for (int i = 1; i < timePoints.size(); i++) {
                int now = getMinutes(timePoints.get(i));
                result = Math.min(now - pre, result);
                pre = now;
            }
            // 首尾时间的时间差
            result = Math.min(result, t0Minutes + 1440 - pre);
            return result;
        }

        public int getMinutes(String t) {
            return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60
                    + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
        }
    }
}

