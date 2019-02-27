import java.util.Arrays;

public class maximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length <= 1) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            res = Math.max(res, nums[i + 1] - nums[i]);
        }
        return res;
    }
}
