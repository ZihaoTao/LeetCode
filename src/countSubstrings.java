public class countSubstrings {
    //pal
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1]);
                if(dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}

