public class canPartition {
    public boolean[][] canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }

        int C = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][C + 1];
        if(sum % 2 == 1) return dp;

        if(n == 0) return dp;
        for(int j = 0; j <= C; j++) {
            dp[0][j] = nums[0] == j;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i]) {
                    dp[i][j] =  dp[i][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean[][] dp = (new canPartition()).canPartition(nums);
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
