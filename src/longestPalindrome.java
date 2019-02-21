public class longestPalindrome {
    public String longestPalindrome(String s) {
        String ret = "";
        int max = 0;
        int len = s.length();

        if(s.length() == 0) {
            return ret;
        }

        boolean[][] dp = new boolean[len][len];
        for(int j = 0; j < len; j++) {
            for(int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if(dp[i][j]) {
                    if(j - i + 1 > max) {
                        max = j - i + 1;
                        ret = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ret;
    }
}
