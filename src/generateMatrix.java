public class generateMatrix {
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] res;
    public int[][] generateMatrix(int n) {
        res = new int[n][n];
        dfs(n, 1, 0, 0, 0);
        return res;
    }

    private void dfs(int n, int num, int count, int x, int y) {
        res[x][y] = num;
        int newX = x + d[count % 4][0];
        int newY = y + d[count % 4][1];
        if(inArea(newX, newY, n) && res[newX][newY] == 0) {
            dfs(n, num + 1, count, newX, newY);
        } else if(num != n * n) {
                dfs(n, num, count + 1, x, y);
        }
    }

    private boolean inArea(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
