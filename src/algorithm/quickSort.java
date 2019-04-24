package algorithm;

import java.util.Arrays;

public class quickSort {
    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int l, int r) {
        if(l > r) return;
        int p = partition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int i = l + 1;
        int j = r;
        while(true) {
            while(i <= r && nums[i] < v) i++;
            while(j >= l && nums[j] > v) j--;
            if(i > j) break;
            swap(nums, i , j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] test = {3,2,1,55,7,8,90,543,2,13,5,65,8876,34,4636,68,4231};
        (new quickSort()).quickSort(test);
        System.out.println(Arrays.toString(test));
    }

}
