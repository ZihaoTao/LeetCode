import java.util.ArrayList;
import java.util.List;

public class findWords {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for(String i : words) {
            if(!list.contains(i) && exist(board, i)) {
                list.add(i);
            }
        }
        return list;
    }


    int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;
    boolean[][] visited;
    private boolean exist(char[][] board, String word) {
        m = board.length;
        if(m == 0) return false;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if(index == word.length() - 1) {
            return board[x][y] == word.charAt(word.length() - 1);
        }
        if(word.charAt(index) == board[x][y]) {
            visited[x][y] = true;
            for(int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if(intArea(newX, newY) && !visited[newX][newY]) {
                    if(dfs(board, word, newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean intArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
