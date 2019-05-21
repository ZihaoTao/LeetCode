public class maxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][n];

        for(int len = 1; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for(int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            (k - 1 < 0 ? 0 : dp[i][k - 1])
                                    + (i - 1 < 0 ? 1 : nums[i - 1]) * nums[k] * (j + 1 < n ? nums[j + 1] : 1)
                                    + (k + 1 < n ? dp[k + 1][j] : 0));
                }
            }
        }
        return dp[0][n - 1];
    }
}
