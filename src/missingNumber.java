import java.util.Arrays;

public class missingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        if (nums[0] != 0) {
            return 0;
        }
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1] + 1) return nums[i] - 1;
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for(int i : nums) {
            sum -= i;
        }
        return sum;
    }
}
