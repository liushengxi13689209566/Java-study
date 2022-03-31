//package search;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @Date: 2022-03-18 19:15
// * @Author: liushengxi
// * @Description:
// */
//
//public class permutation {
//
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
////        solution.permutation("abc");
////        char[] test = new char[2];
////        test[0] = 'a';
////        test[1] = 'b';
////        solution.swap(test[0], test[1]);
////        System.out.println(test);
//
//
//        String[] test01 = new String[2];
//        test01[0] = "a";
//        test01[1] = "b";
//        solution.swap(test01, test01[0], test01[1]);
//        for (int i = 0; i < test01.length; i++) {
//            System.out.println(test01[i]);
//        }
//
////
////        solution.swap(0, 1);
////        System.out.println(test);
//    }
//}
//
//class Solution {
//    Set<String> result = new HashSet<>();
//    char[] c;
//
//    public String[] permutation(String s) {
//        if (s == null) {
//            return null;
//        }
//        c = s.toCharArray();
//        dfs(0);
//        return result.toArray(new String[result.size()]);
//    }
//
//    void dfs(int x) {
//        if (x == c.length - 1) {
//            result.add(String.valueOf(c));      // 添加排列方案
//            return;
//        }
//        // 考虑 abc 以及 abb 的情况
//        HashSet<Character> set = new HashSet<>();
//        for (int i = x; i < c.length; i++) {
//            // 会存在重复，因此剪枝
//            if (set.contains(c[i]))
//                continue;
//            set.add(c[i]);
//            // swap(c[i], c[x]); (不能这样交换，这样子是值传递，并没有发生数组意义上的交换操作)
//            // 交换，将 c[i] 固定在第 x 位
//            swap(i, x);
//            // 开启固定第 x + 1 位字符
//            dfs(x + 1);
//            // 恢复交换
//            swap(i, x);
//        }
//    }
//
//    void swap(int a, int b) {
//        char tmp = c[a];
//        c[a] = c[b];
//        c[b] = tmp;
//    }
//}
