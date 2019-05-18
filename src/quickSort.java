import java.util.Arrays;

public class quickSort {

    public void quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int l, int r) {
        if(l > r) return;
        int p = partition(nums, l, r);
        helper(nums, l, p - 1);
        helper(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int i = l + 1;
        int j = r;
        while(true) {
            while(i <= r && nums[i] > v) i++;
            while(j >= l && nums[j] < v) j--;
            if(i > j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {2,4,21,25,7,52,45,7,9};
        (new quickSort()).quickSort(test);
        System.out.println(Arrays.toString(test));
    }
}
