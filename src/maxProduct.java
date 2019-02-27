public class maxProduct {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];

        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
