import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int temp = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[l] + nums[r];
                int value = Math.abs(sum - temp);
                if(diff > value) {
                    diff = value;
                    res = nums[i] + sum;
                }
                if(sum < temp) {
                    l++;
                } else if(sum > temp) {
                    r--;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
