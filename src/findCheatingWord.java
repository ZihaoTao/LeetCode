import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findCheatingWord {

    int[][] d = {{1, 0}, {0, 1}};
    int m, n;
    List<int[]> list;
    public void findCheatingWord(String word, char[][] matrix) {
        if(word.length() == 0) return;
        m = matrix.length;
        if(m == 0) return;
        n = matrix[0].length;
        list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(word, matrix, i, j, 0)) {
                    print(list);
                } else {
                    list = new ArrayList<>();
                }
            }
        }
    }

    private boolean dfs(String word, char[][] matrix, int x, int y, int index) {
        if(word.length() == index) {

            return true;

        } else if(word.charAt(index) == matrix[x][y]) {
            list.add(new int[]{x, y});
            for(int i = 0; i < 2; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if(newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if(dfs(word, matrix, newX, newY, index+1)) {
                        return true;
                    }
                }
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

    private void print(List<int[]> list) {
        for(int[] i : list) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'c', 'r', 'c', 'a', 'r', 's'}, {'a', 'b', 'i', 't', 'n', 'b'}, {'t', 'f', 'n', 'n', 't', 'i'}, {'x', 's', 'i', 'i', 'p', 't'}};

        for(char[] i : matrix) {
            for(char j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        (new findCheatingWord()).findCheatingWord("nip", matrix);
    }
}
