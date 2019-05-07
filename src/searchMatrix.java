public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int index = searchRow(matrix, target);
        if(index == -1) return false;
        int[] row = matrix[index];
        int res = bs(row, target);
        return res != -1;
    }

    private int searchRow(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(matrix[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private int bs(int[] num, int target) {
        int l = 0;
        int r = num.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(num[mid] == target) {
                return mid;
            } else if (num[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] test = {{-5}};
        System.out.println((new searchMatrix()).searchMatrix(test, -10));
    }
}
