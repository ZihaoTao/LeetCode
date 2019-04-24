import java.util.Arrays;

public class swaptest {
    public void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] + nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] = nums[a] - nums[b];
    }

    public static void main(String[] args) {
        int[] test = {1,4,23,5,243,8,6,90};
        System.out.println(Arrays.toString(test));
        (new swaptest ()).swap(test, 1, 1);
        System.out.println(Arrays.toString(test));
    }
}
