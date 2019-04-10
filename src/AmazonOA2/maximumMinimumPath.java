package AmazonOA2;

public class maximumMinimumPath {
    public int maximumMinimumPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], matrix[i][j]);
                } else if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], matrix[i][j]);
                } else {
                    dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]), matrix[i][j]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] test = {{8, 4, 7}, {6, 5, 9}};
        System.out.println((new maximumMinimumPath()).maximumMinimumPath(test));
    }
}
