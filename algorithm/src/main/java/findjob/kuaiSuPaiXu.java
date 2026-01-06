package findjob;

import java.util.Arrays;

public class kuaiSuPaiXu {
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSortFun(nums, 0, nums.length - 1);
    }

    public static void quickSortFun(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quickSortFun(nums, start, pivot - 1);
            quickSortFun(nums, pivot + 1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }


    public static void main(String[] args) {
        int[] arr1 = {10, 7, 8, 9, 1, 5};
        quickSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
