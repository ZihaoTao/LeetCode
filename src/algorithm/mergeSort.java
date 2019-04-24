package algorithm;

import java.util.Arrays;

public class mergeSort {
    public void mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int l, int r) {
        if(l >= r) return;
        int mid = l + (r - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        if(nums[mid] >= nums[mid + 1])
            merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for(int i = l; i <= r; i++) {
            aux[i - l] = nums[i];
        }

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {

            if(i > mid) {
                nums[k] = aux[j - l];
                j++;
            } else if(j > r) {
                nums[k] = aux[i - l];
                i++;
            } else if(aux[i - l] < aux[j - l]) {
                nums[k] = aux[i - l];
                i++;
            } else {
                nums[k] = aux[j - l];
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        (new mergeSort()).mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
