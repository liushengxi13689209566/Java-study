package other;

import org.junit.Test;

/**
 * @Date: 2022-02-28 23:04
 * @Author: liushengxi
 * @Description:
 */
public class MyPow {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? helper(x, N) : 1.0 / helper(x, -N);
    }

    public double helper(double x, long N) {
        long dump_n = N;
        double result = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // X^n   X^n/2  X^n/4 X^n/8  最终都会到 X^1
        while (N > 1) {
            System.out.println("N ==" + N);
            System.out.println("result ==" + result);
            System.out.println("x_contribute ==" + x_contribute);
            System.out.println();
            System.out.println();
//            if (N % 2 == 1) {
//                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
//                result *= x_contribute;
//            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        // 奇数
        if (dump_n % 2 == 1) {
            result = x_contribute * x;
        }
        result = x_contribute;
        return result;
    }

    @Test
    public void test() {
        System.out.println("2^8 == " + this.myPow(2, 8));
        System.out.println("2^6 == " + this.myPow(2, 6));
//        System.out.println(this.myPow(2, 8));
//        System.out.println(this.myPow(2, 8));
    }

    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? helper(x, N) : 1.0 / helper(x, -N);
        }

        public double helper(double x, long N) {
            double result = 1.0;
            // 贡献的初始值为 x
            double x_contribute = x;
            // 在对 N 进行二进制拆分的同时计算答案
            while (N > 0) {
                if ((N & 2) == 1) {
                    // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                    result *= x_contribute;
                }
                // 将贡献不断地平方
                x_contribute *= x_contribute;
                // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
                N = N >> 2;
            }
            return result;
        }
    }
}
