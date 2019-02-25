public class minCut {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];

        boolean[][] P = new boolean[len][len];


        for(int i = 0; i < len; i++) {
            dp[i] = i;
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 1 || P[i - 1][j + 1])) {
                    P[i][j] = true;
                    dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
