public class rob {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] a = new int[nums.length - 1];
        int[] b = new int[nums.length - 1];
        for(int i = 0; i < nums.length - 1; i++) {
            a[i] = nums[i];
        }
        for(int i = 1; i < nums.length; i++) {
            b[i - 1] = nums[i];
        }
        return Math.max(helper(a), helper(b));
    }

    private int helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < n ? dp[j + 2] : 0));
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        System.out.println((new rob()).rob(test));
    }
}
