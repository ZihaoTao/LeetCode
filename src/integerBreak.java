public class integerBreak {
    public int integerBreak(int n) {
        if(n <= 1) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }
        int res = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                if(i == j){
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    if(j - i > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - i] * i);
                    }
                    if (j - i >= i) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - i] * i);
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new integerBreak()).integerBreak(2));
    }
}
