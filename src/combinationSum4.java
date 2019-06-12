public class combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++) {
            for(int j : nums) {
                if(i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }

    public int combinationSum4II(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for(int i : nums) {
            if(i <= target) {
                dp[i] = 1;
            }
        }

        for(int i = 1; i <= target; i++) {
            for(int j : nums) {
                if(i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1};
        int target = 32;
        System.out.println((new combinationSum4()).combinationSum4(nums, target));
        System.out.println((new combinationSum4()).combinationSum4II(nums, target));
    }
}
