///**
// * @Date: 2022-03-26 18:07
// * @Author: liushengxi
// * @Description:
// */
//
///**
// *
// */
//public class LCS {
//
//}
//
//
///*
// public String LCS(String str1, String str2) {
//        int maxLenth = 0;//记录最长公共子串的长度
//        //记录最长公共子串最后一个元素在字符串str1中的位置
//        int maxLastIndex = 0;
//        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
//        for (int i = 0; i < str1.length(); i++) {
//            for (int j = 0; j < str2.length(); j++) {
//                //递推公式，两个字符相等的情况
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    dp[i + 1][j + 1] = dp[i][j] + 1;
//                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
//                    //以及最长子串最后一个元素的位置
//                    if (dp[i + 1][j + 1] > maxLenth) {
//                        maxLenth = dp[i + 1][j + 1];
//                        maxLastIndex = i;
//                    }
//                } else {
//                    //递推公式，两个字符不相等的情况
//                    dp[i + 1][j + 1] = 0;
//                }
//            }
//        }
//        //最字符串进行截取，substring(a,b)中a和b分别表示截取的开始和结束位置
//        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex + 1);
//    }*/
//
//import java.util.*;
//
//
//public class Solution {
//    /**
//     * longest common substring
//     *
//     * @param str1 string字符串 the string
//     * @param str2 string字符串 the string
//     * @return string字符串
//     */
//    public String LCS(String str1, String str2) {
//        if (str1 == null || "".equals(str1) || str2 == null || "".equals(str2)) {
//            return "";
//        }
//        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
//        int maxLen = 0;
//        int maxLenEndIndex = 0;
//        for (int i = 0; i < str1.length(); i++) {
//            for (int j = 0; j < str2.length(); j++) {
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    // DP 方程
//                    dp[i + 1][j + 1] = dp[i][j] + 1;
//                    if (dp[i + 1][j + 1] > maxLen) {
//                        maxLen = dp[i + 1][j + 1];
//                        maxLenEndIndex = i;
//                    }
//                } else {
//
//                    dp[i + 1][j + 1] = 0;
//                }
//            }
//        }
//        return str1.substring(maxLenEndIndex - maxLen + 1, maxLenEndIndex + 1);
//    }
//}
//
//public class Solution {
//    /**
//     * longest common substring
//     *
//     * @param str1 string字符串 the string
//     * @param str2 string字符串 the string
//     * @return string字符串
//     */
//    public String LCS(String str1, String str2) {
//        if (str1 == null || "".equals(str1) || str2 == null || "".equals(str2)) {
//            return "";
//        }
//        char[] charArr1 = str1.toCharArray();
//        char[] charArr2 = str2.toCharArray();
//        int maxLen = 0;
//        int maxLenEndIndex = 0;
//        for (int i = 0; i < charArr1.length; i++) {
//            for (int j = 0; j < charArr2.length; j++) {
//                if (charArr1[i] == charArr2[j]) {
//                    int tempIndex1 = i;
//                    int tempIndex2 = j;
//                    int tempMax = 0;
//                    while (tempIndex1 < charArr1.length && tempIndex2 < charArr2.length
//                            && charArr1[tempIndex1] == charArr2[tempIndex2]) {
//                        tempIndex1++;
//                        tempIndex2++;
//                        tempMax++;
//                    }
//                    if (tempMax > maxLen) {
//                        maxLen = tempMax;
//                        maxLenEndIndex = tempIndex1;
//                    }
//                }
//            }
//        }
//        return str1.substring(maxLenEndIndex - maxLen, maxLenEndIndex);
//    }
//}
