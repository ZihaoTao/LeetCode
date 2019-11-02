import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
            for(int j : coins) {
                if(i >= j) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] test = {1,5,10};
        System.out.print((new coinChange()).coinChange(test, 11));
    }
}
