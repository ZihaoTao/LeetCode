public class rotate {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        for(int i = 0; i < m; i++) {
            int l = 0;
            int r = m - 1;
            while(l < r) {
                swap(matrix, l, i, r, i);
                l++;
                r--;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = i; j < m; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int a, int b, int c, int d) {
        int t = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = t;
    }
}
