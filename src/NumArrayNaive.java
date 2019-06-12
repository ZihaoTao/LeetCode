public class NumArrayNaive {
    int[] nums;
    public NumArrayNaive(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        return nums[j] - (i - 1 >= 0 ? nums[i - 1] : 0);
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        (new NumArrayNaive(nums)).sumRange(0, 0);
    }
}
