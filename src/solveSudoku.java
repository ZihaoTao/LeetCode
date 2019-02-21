public class solveSudoku {
    boolean[][] row;
    boolean[][] col;
    boolean[][] block;
    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        block = new boolean[9][10];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    row[i][n] = true;
                    col[j][n] = true;
                    block[i / 3 * 3 + j / 3][n] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int index) {
        if(index == 81) {
            return true;
        }
        int x = index / 9;
        int y = index % 9;
        if(board[x][y] == '.') {
            for(int i = 1; i <= 9; i++) {
                if(!row[x][i] && !col[y][i] && !block[x / 3 * 3 + y /3][i]) {
                    board[x][y] = (i + "").charAt(0);
                    row[x][i] = true;
                    col[y][i] = true;
                    block[x / 3 * 3 + y /3][i] = true;
                    if(dfs(board, index + 1)) {
                        return true;
                    }
                    board[x][y] = '.';
                    row[x][i] = false;
                    col[y][i] = false;
                    block[x / 3 * 3 + y /3][i] = false;
                }
            }
        } else {
            return dfs(board, index + 1);
        }
        return false;
    }
}
