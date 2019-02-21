public class rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i; j++) {
                swap(matrix, i, j, n - j - 1, n - i - 1);
            }
        }

        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                swap(matrix, i, j, n - i - 1, j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int a, int b) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = temp;
    }
}
