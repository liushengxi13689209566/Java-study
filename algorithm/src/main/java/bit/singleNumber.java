package bit;

/**
 * @Date: 2022-04-03 23:51
 * @Author: liushengxi
 * @Description: 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class singleNumber {

    static class Solution {
        public int[] singleNumber(int[] nums) {
            int temp = 0;
            //求出异或值
            for (int x : nums) {
                temp ^= x;
            }
            //保留最右边的一个 1
            int group = temp & (-temp);

            System.out.println(group);

            int[] arr = new int[2];
            for (int y : nums) {
                //分组位为0的组，组内异或
                if ((group & y) == 0) {
                    arr[0] ^= y;
                    //分组位为 1 的组，组内异或
                } else {
                    arr[1] ^= y;
                }
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.singleNumber(new int[]{4, 1, 4, 6});
    }

}
