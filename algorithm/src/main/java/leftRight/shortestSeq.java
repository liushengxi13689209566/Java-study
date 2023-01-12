package leftRight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/shortest-supersequence-lcci/
 * 面试题 17.18. 最短超串
 * 中等
 * 64
 * 相关企业
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 * <p>
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * 提示：
 * <p>
 * big.length <= 100000
 * 1 <= small.length <= 100000
 * <p>
 * 思路：
 * 一般滑动窗口维护两个指针，左指针和右指针。
 *
 * 当窗口内的元素未达到题目条件时，右指针右移，探索未知的区间来满足条件
 * 当窗口内的元素达到题目条件时，左指针右移，压缩区间，使窗口尽可能短得满足题目条件
 * https://leetcode.cn/problems/shortest-supersequence-lcci/solutions/622093/xiang-xi-tu-jie-hua-dong-chuang-kou-chao-qi7g/
 */
public class shortestSeq {
    class Solution {
        public int[] shortestSeq(int[] big, int[] small) {
            //结果数组
            int[] res = {};
            // TODO：用来维护临界值 3
            int smallLen = small.length;
            int bigLen = big.length;
            int left = 0;
            int right = 0;
            //存放结果子串长度
            int minLen = bigLen;
            // map<int, int> need：记录要完全覆盖small数组，滑动窗口内需要覆盖的数字及其对应的个数
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < smallLen; i++) {
                map.putIfAbsent(small[i], 1); //存放小数组所有元素，因为不会重复，直接赋为1
            }
            // 边界条件
            while (right < bigLen) {
                // 判断right指针代表的元素是否出现在map
                if (map.containsKey(big[right])) {
                    // 即使含有该元素，只有当map中该元素数量大于0才可以让 smallLen--！！在该处浪费了很多时间，
                    // 比如 big：1123，small：123，1在big里出现两次，但只有第一次出现会被统计
                    // TODO：这里只能统计第一次：后续的窗口压缩在 left 那里做
                    if (map.get(big[right]) > 0) {
                        smallLen--;
                    }
                    // 每次都要将map含有的big数组元素-1
                    map.put(big[right], map.get(big[right]) - 1);
                }
                // big里找到了一个子串
                while (smallLen == 0) {
                    if (right - left < minLen) {
                        minLen = right - left;
                        res = new int[]{left, right};
                    }
                    // 对左指针判断
                    if (map.containsKey(big[left])) {
                        // 每次都要将 map 含有的big数组元素+1
                        map.put(big[left], map.get(big[left]) + 1);
                        // 只有当 map 中该元素数量大于0才可以让 smallLen++
                        if (map.get(big[left]) > 0) {
                            smallLen++;
                        }
                    }
                    left++;
                }
                right++;
            }
            return res;
        }
    }
}
