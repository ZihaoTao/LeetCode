public class isMatchRegExpress {
    //'.' Matches any single character.
    //'*' Matches zero or more of the preceding element.
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for(int i = 2; i <= n; i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char cs = s.charAt(i - 1);
                char cp = p.charAt(j - 1);
                if(cp == '.' || cs == cp) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp == '*') {
                    if (p.charAt(j - 2) != cs && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
