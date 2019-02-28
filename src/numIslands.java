public class numIslands {
    int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count ++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY) && grid[x][y] == '1' && !visited[newX][newY]) {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
