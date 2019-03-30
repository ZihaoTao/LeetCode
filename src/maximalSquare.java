public class maximalSquare {
    public int[][] maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return null;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = dp[0][0];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        char[][] test = {{'1', '1', '1'}, {'1', '1', '1'}, {'1', '1', '1'}};
        int[][] res = (new maximalSquare()).maximalSquare(test);
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
