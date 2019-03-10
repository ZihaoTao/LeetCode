public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}