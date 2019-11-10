public class increasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] == 3) return true;
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i <= min) {
                min = i;
            } else if (i <= secMin) {
                secMin = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
