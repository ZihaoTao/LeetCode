import java.util.LinkedList;
import java.util.Queue;

public class updateMatrix {
    int[][] res;
    int m, n;
    int[][] d = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public class Pair {
        int x;
        int y;
        int level;
        public Pair(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        if(m == 0) return matrix;
        n = matrix[0].length;
        res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j, 0));
                    while(!q.isEmpty()) {
                        Pair pair = q.remove();
                        int level = pair.level;
                        if(matrix[pair.x][pair.y] == 0) {
                            res[i][j] = level;
                            break;
                        }
                        for(int k = 0; k < 4; k++) {
                            int newX = pair.x + d[k][0];
                            int newY = pair.y + d[k][1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                                q.add(new Pair(newX, newY, level + 1));
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] arr = (new updateMatrix()).updateMatrix(test);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
