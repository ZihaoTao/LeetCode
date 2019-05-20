public class NumMatrix {
    int[][] matrix;
    int m, n;
    int bit[][];
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        if(m == 0) return;
        n = matrix[0].length;
        bit = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                init(i, j, matrix[i][j]);
            }
        }
    }

    private void init(int x, int y, int val) {
        x++;
        y++;
        for(int i = x; i <= m; i += i & -i) {
            for(int j = y; j <= n; j += j & -j) {
                bit[i][j] += val;
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        init(row, col, diff);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - (getSum(row2, col1 - 1) + getSum(row1 - 1, col2) - getSum(row1 - 1, col1 - 1));
    }

    private int getSum(int x, int y) {
        x++;
        y++;
        int sum = 0;
        for(int i = x; i > 0; i -= i & -i) {
            for(int j = y; j > 0; j -= j & -j) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
}
