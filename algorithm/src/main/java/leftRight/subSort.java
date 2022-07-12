package leftRight;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sub-sort-lcci/
 * 面试题 16.16. 部分排序
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * 示例：
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 * 0 <= len(array) <= 1000000
 * 思路：
 * 一：排序+双指针
 * 将数组进行排序，然后进行夹逼，找到对应的中间最短序列即可。时间复杂度：O(NLogN+N) 空间:O(n)
 *
 * 二：时间复杂度：O(N) 空间:O(1)
 * 我们只需要寻找 最靠右的那个数（满足左边存在大于它的数），和 最靠左的那个数（满足右边存在小于它的数），
 * 那么这两个数之间就是要排序的区间了。
 * <p>
 * 为什么最靠右的那个（满足左边存在大于它的数）数一定能保证右边没有更小的数了呢？
 * 因为如果右边还有更小的数，那么那个更小的数才是更靠右的啊，这就矛盾了。
 * <p>
 * 所以我们只需要从左到右扫描一遍，用一个变量维护一下最大值就行了，然后反向再遍历一遍，维护一个最小值。
 * 示例：
 * [1,3,9,7,5,24,56]
 * [0,1]
 * [1,0]
 * [1,2,4,7,10,11,7,12,6,7,16,18,19]
 */
public class subSort {
    /**
     * 思路二
     */
    int[] subSort02(int[] array) {
        if (array == null || array.length <= 1) {
            return new int[]{-1, -1};
        }
        int n = array.length;
        int maxx = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;

        int l = -1, r = -1;
        // 找 最靠右的那个数（满足左边存在大于它的数
        for (int i = 0; i < n; ++i) {
            if (array[i] < maxx) r = i;
            else maxx = array[i];
        }
        // 找 最靠左的那个数（满足右边存在小于它的数）
        for (int i = n - 1; i >= 0; --i) {
            if (array[i] > minn) l = i;
            else minn = array[i];
        }
        return new int[]{l, r};
    }

    /**
     * 思路一
     */
    int[] subSort(int[] array) {
        if (array == null || array.length <= 1) {
            return new int[]{-1, -1};
        }
        int[] array_dump = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array_dump[i] = array[i];
        }

        Arrays.sort(array_dump);

        int left = 0;
        int right = array_dump.length - 1;
        while (left < right && array_dump[left] == array[left]) {
            left++;
        }
        while (left < right && array_dump[right] == array[right]) {
            right--;
        }
        return left >= right ? new int[]{-1, -1} : new int[]{left, right};
    }
}
