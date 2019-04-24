package algorithm;

public class selectionSort {
    public void selectionSort(int[] nums) {
        sort(nums, nums.length - 1);
    }

    private void sort(int[] nums, int n) {
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(nums[j] < (nums[minIndex])) minIndex = j;
            }
            swap(nums, i, minIndex);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
