public class getMoneyAmount {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int len = 1; len <= n; len++) {
            for(int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                if(i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = i; x <= j; x++) {
                        dp[i][j] = Math.min(dp[i][j], x + Math.max(x - 1 >= i ? dp[i][x - 1] : 0, x + 1 <= j ? dp[x + 1][j] : 0));
                    }
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println((new getMoneyAmount()).getMoneyAmount(2));
    }
}
