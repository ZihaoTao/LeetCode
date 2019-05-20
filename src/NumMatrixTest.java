public class NumMatrixTest {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        for(int[] i : matrix) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        NumMatrix numMatrix = new NumMatrix(matrix);
        numMatrix.update(1, 2, 6);
        System.out.println(numMatrix.sumRegion(1, 1, 4, 3));
    }
}
