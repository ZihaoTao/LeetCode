public class canJump {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= i + nums[i]; j++) {
                if(j < nums.length) {
                    dp[j] = dp[j] || dp[i];
                } else {
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
