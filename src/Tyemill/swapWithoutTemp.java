package Tyemill;

public class swapWithoutTemp {

    public void swapWithoutTemp(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
