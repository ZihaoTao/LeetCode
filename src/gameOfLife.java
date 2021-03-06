public class gameOfLife {
    int m, n;
    public void gameOfLife(int[][] board) {
        if(board.length == 0) return;
        m = board.length;
        n = board[0].length;
        boolean[][] live = new boolean[m][n];
        int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = 0;
                for(int[] dd : d) {
                    int newX = i + dd[0];
                    int newY = j + dd[1];
                    if(inArea(newX, newY)) {
                        if(board[newX][newY] == 1) {
                            count++;
                        }
                    }
                }
                if(board[i][j] == 1) {
                    if(count == 2 || count == 3) {
                        live[i][j] = true;
                    }
                } else {
                    if(count == 3) {
                        live[i][j] = true;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(live[i][j]) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public void gameOfLife2(int[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        int[] d = {-1, 0, 1};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        if (!(d[k] == 0 && d[l] == 0)) {
                            int newX = i + d[k];
                            int newY = j + d[l];
                            if(newX >= 0 && newX < m && newY >= 0 && newY < n) {
                                if(board[newX][newY] > 0) liveNeighbors++;
                            }
                        }
                    }
                }
                //live -> dead
                if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2;
                }

                //dead -> live
                if(board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1 || board[i][j] == -1) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
