package algorithm;

import java.util.Arrays;

public class heapSort {
    public void heapSort(int[] nums) {
        sort(nums, nums.length - 1);
    }

    private void sort(int[] nums, int n) {
        for(int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(nums, n, i);
        }

        for(int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            shiftDown(nums, i, 0);
        }
    }

    private void shiftDown(int[] nums, int n, int k) {
        while(2 * k + 1 < n) {
            int j = 2 * k + 1;
            if(j + 1 < n && nums[j + 1] > nums[j]) {
                j++;
            }
            if(nums[k] > nums[j]) break;
            swap(nums, k, j);
            k = j;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new heapSort()).heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
