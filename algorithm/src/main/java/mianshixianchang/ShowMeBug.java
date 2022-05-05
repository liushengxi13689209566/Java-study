package mianshixianchang;

import java.util.ArrayList;
import java.util.List;

// 给定长度为 n+1 单调递增的整数数组，数组 取值为 1 到 n 的 连续区间，其中有一个数是重复的，找出这个重复的数
import java.util.*;

// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法

/**
 * 探探 面试
 * 没理解好 题意，我去。。。
 */

public class ShowMeBug {
    static private int fun(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int len = nums.length;
        if (len <= 0) {
            return -1;
        }
        int left = 0, right = len - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= mid) {
                right = mid - 1;
                res = nums[mid];
            } else if (nums[mid] > mid) {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fun(new int[]{1, 2, 3, 4, 5, 5}));
        System.out.println(fun(new int[]{1, 2, 3, 4, 4, 5}));
        System.out.println(fun(new int[]{1, 2, 2, 3, 4, 5}));
        System.out.println(fun(new int[]{1, 1, 2, 3, 4, 5}));
        System.out.println(fun(new int[]{1, 1}));
        System.out.println(fun(new int[]{1, 1, 2, 3}));
        System.out.println(fun(new int[]{1, 1, 2, 3, 4}));
    }
}
