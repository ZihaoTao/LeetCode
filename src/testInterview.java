public class testInterview {
    public int[][] test(int m, int n, int a, int b, int r) {
        int[][] area = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(Math.pow(i - a, 2) + Math.pow(j - b, 2) <= r * r) {
                    area[i][j] = 1;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] test = (new testInterview()).test(10, 10, 4, 4, 3);
        for(int i = 0; i < test.length; i++) {
            for(int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }
}
