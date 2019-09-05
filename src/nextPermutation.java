import java.util.Arrays;

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int l) {
        int r = nums.length - 1;
        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,5,4};
        (new nextPermutation()).nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }
}
