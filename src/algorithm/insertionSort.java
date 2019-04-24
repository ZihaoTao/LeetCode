package algorithm;

import java.util.Arrays;

public class insertionSort {
    public void insertionSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] < nums[j]) {
                    swap(nums, i, j);
                    i--;
                }
            }
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
