package dp;

import java.util.List;

/**
 * @Date: 2022-03-05 23:31
 * @Author: liushengxi
 * @Description:
 */
public class minimumTotal {


    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            /**
             先下向上进行状态递推。
             对应的数值表示：到达该点的最小路径和
             从 倒数第二行 开始，因为倒数第一行就是它本身
             */
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    Integer current = triangle.get(i).get(j);
                    // 正下方
                    Integer xiaFang = triangle.get(i + 1).get(j);
                    // 斜下方
                    Integer xieXiafang = triangle.get(i + 1).get(j + 1);
                    // 状态转移方程
                    current = current + Math.min(xieXiafang, xiaFang);

                    List<Integer> tmp = triangle.get(i);
                    tmp.set(j, current);
                    triangle.set(i, tmp);
                }
            }
            return triangle.get(0).get(0);
        }
    }


}
