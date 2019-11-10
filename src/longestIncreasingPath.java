public class longestIncreasingPath {
    int m, n;
    int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if(m == 0) return 0;
        n = matrix[0].length;
        dp = new int[m][n];
        int res = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int x, int y) {
        if(dp[x][y] != 0) return dp[x][y];
        int res = 1;
        for(int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[x][y]) {
                res = Math.max(res, dfs(matrix, newX, newY) + 1);
            }
        }
        dp[x][y] = res;
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                          {9,9,4},
                          {6,6,8},
                          {2,1,1}
                         };
        System.out.println((new longestIncreasingPath()).longestIncreasingPath(matrix));
    }
}
