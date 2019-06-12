public class NumMatrixNaive {

    int[][] matrix;
    public NumMatrixNaive(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] += (i >= 1 ? matrix[i - 1][j] : 0) +
                        (j >= 1 ? matrix[i][j - 1] : 0) -
                        ((i >= 1 && j >= 1) ? matrix[i - 1][j - 1] : 0);
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix.length == 0) return 0;
        return matrix[row2][col2] - ((col1 >= 1 ? matrix[row2][col1 - 1] : 0 ) +
                (row1 >= 1 ? matrix[row1 - 1][col2] : 0) -
                ((row1 >= 1 && col1 >= 1) ? matrix[row1 - 1][col1 - 1] : 0));
    }

    public static void main(String[] args) {
        int[][] matrix = {{}};
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

       int[][] test = (new NumMatrixNaive(matrix)).matrix;

        for(int i = 0; i < test.length; i++) {
            for(int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }

}
