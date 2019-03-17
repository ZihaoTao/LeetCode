import java.util.Arrays;

public class wiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 2; i < nums.length; i += 2) {
            swap(nums, i, i -1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
