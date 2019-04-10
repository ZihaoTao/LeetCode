public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int count = 0;
        for(int i : nums) {
            count = Math.max(count + i, i);
            res = Math.max(res, count);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        for(int i = 1; i < n; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {-1, -1,  -3, 3, 1};
        System.out.println((new maxSubArray()).maxSubArray(test));
    }
}
