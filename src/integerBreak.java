public class integerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        StringBuilder b = new StringBuilder("dsa");
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println((new integerBreak()).integerBreak(10));
    }
}
