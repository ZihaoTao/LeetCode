public class isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] col = new boolean[9][10];
        boolean[][] row = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for(int i = 0; i < 81; i++) {
            int x = i / 9;
            int y = i % 9;
            if(board[x][y] != '.') {
                int n = board[x][y] - '0';
                if(!row[x][n] && !col[y][n] && !block[x / 3 * 3 + y / 3][n]) {
                    row[x][n] = true;
                    col[y][n] = true;
                    block[x / 3 * 3 + y / 3][n] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
