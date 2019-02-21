import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    List<Integer> res;
    boolean[][] visited;
    public List<Integer> spiralOrder(int[][] matrix) {
        res = new ArrayList<>();
        if(matrix.length == 0) return res;
        visited = new boolean[matrix.length][matrix[0].length];

        dfs(matrix, 0, 0, 0, 0);
        return res;
    }

    private void dfs(int[][] matrix, int count, int index, int x, int y) {
        if (!visited[x][y]) {
            visited[x][y] = true;
            res.add(matrix[x][y]);
        }
        int newx = x + d[count % 4][0];
        int newy = y + d[count % 4][1];
        if (inArea(matrix, newx, newy) && !visited[newx][newy]) {
            dfs(matrix, count, index + 1, newx, newy);
        } else if(index != matrix.length * matrix[0].length - 1) {
            dfs(matrix, count + 1, index, x, y);
        }

    }

    private boolean inArea(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
