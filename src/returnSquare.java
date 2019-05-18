public class returnSquare {
    public int[][] NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return null;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {1, 1, 1, 0, 1}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println();
        int[][] res = (new returnSquare()).NumMatrix(matrix);
        for(int[] i : res) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
