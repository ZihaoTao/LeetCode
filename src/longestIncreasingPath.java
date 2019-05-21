public class longestIncreasingPath {
    int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        int res = 0;
        if(m == 0) return res;
        n = matrix[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int x, int y) {
        if(dp[x][y] != 0) return dp[x][y];
        int max = 1;
        for(int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[x][y]) {
                max = Math.max(max, 1 + dfs(matrix, newX, newY));
            }
        }
        dp[x][y] = max;
        return max;
    }
}
