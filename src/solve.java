public class solve {
    int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        if(m == 0) return;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if(board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if(board[x][y] == 'O') {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    dfs(board, newX, newY);
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
