public class shortestToChar {
    public int[] shortestToChar(String S, char C) {
        int[] dp = new int[S.length()];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = S.length();
        }

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) {
                dp[i] = 0;
                for(int j = i - 1; j >= 0; j--) {
                    dp[j] = Math.min(dp[j], dp[j + 1] + 1);
                }
            }
        }

        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) == C) {
                dp[i] = 0;
                for(int j = i + 1; j < S.length(); j++) {
                    dp[j] = Math.min(dp[j], dp[j - 1] + 1);
                }
            }
        }
        return dp;
    }
}
