package leftRight;

/**
https://leetcode.cn/problems/sorted-merge-lcci/description/

面试题 10.01. 合并排序的数组
简单
163
相关企业

给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

示例:

输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

说明:

    A.length == n + m

# 思路：
 方法三：逆向双指针

 算法

 方法二中，之所以要使用临时变量，是因为如果直接合并到数组 AAA 中，AAA 中的元素可能会在取出之前被覆盖。那么如何直接避免覆盖 AAA 中的元素呢？
 观察可知，AAA 的后半部分是空的，可以直接覆盖而不会影响结果。因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 AAA 的最后面。

 时间：O(m+n)
 空间：O(1)

 作者：力扣官方题解
 链接：https://leetcode.cn/problems/sorted-merge-lcci/solutions/124952/mian-shi-ti-1001-he-bing-pai-xu-de-shu-zu-by-leetc/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

* */

public class merge {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {

            int index = m + n - 1;
            int l1 = m - 1;
            int l2 = n - 1;

            while (l1 >= 0 && l2 >= 0) {
                if (A[l1] >= B[l2]) {
                    A[index] = A[l1--];
                } else {
                    A[index] = B[l2--];
                }
                index--;
            }
            while (l1 >= 0 && index >= 0) {
                A[index--] = A[l1--];
            }
            while (l2 >= 0 && index >= 0) {
                A[index--] = B[l2--];
            }

            // Arrays.stream(A).forEach(i->{
            //     System.out.println(i);
            // });
        }
    }
}
