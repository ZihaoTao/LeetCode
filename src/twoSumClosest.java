import java.util.Arrays;

public class twoSumClosest {
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(Math.abs(target - sum) < diff) {
                diff = Math.abs(target - sum);
            }
            if(sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return 0;
            }
        }
        return diff;
    }
}
