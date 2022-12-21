package other;

import java.util.Arrays;

/*
 * */
public class Temp {
    static class Solution {
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

            Arrays.stream(A).forEach(i->{
                System.out.print(i);
            });
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{4, 5, 6};
        solution.merge(A, 3, B, 3);
    }
}

