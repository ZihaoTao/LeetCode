public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0 || matrix[0].length == 0) return false;
        int l = 0;
        int r = m - 1;
        int res = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(matrix[mid][0] <= target) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }
        return searchRow(matrix, target, res);
    }

    private boolean searchRow(int[][] matrix, int target, int mid) {
        int l = 0;
        int r = matrix[0].length - 1;
        while(l <= r) {
            int middle = l + (r - l) / 2;
            if(matrix[mid][middle] == target) {
                return true;
            } else if (matrix[mid][middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{1}, {3}};
        System.out.println((new searchMatrix()).searchMatrix(test, 3));
    }
}
