import java.util.ArrayList;
import java.util.List;

public class totalNQueens {
    int count;
    boolean[] col, dia1, dia2;
    public int totalNQueens(int n) {
        count = 0;
        if(n == 0) return count;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> list = new ArrayList<>();
        dfs(n, 0, list);
        return count;
    }

    private void dfs(int n, int index, List<Integer> list) {
        if(index == n) {
            count++;
        } else {
            for(int i = 0; i < n; i++) {
                if(!col[i] && !dia1[i + index] && !dia2[i - index + n - 1]) {
                    list.add(i);
                    col[i] = true;
                    dia1[i + index] = true;
                    dia2[i - index + n - 1] = true;
                    dfs(n, index + 1, list);
                    list.remove(list.size() - 1);
                    col[i] = false;
                    dia1[i + index] = false;
                    dia2[i - index + n - 1] = false;
                }
            }
        }
    }
}
