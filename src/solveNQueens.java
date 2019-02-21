import java.util.ArrayList;
import java.util.List;

public class solveNQueens {

    List<List<String>> res;
    boolean[] col, dia1, dia2;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n == 0) return res;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> list = new ArrayList<>();
        dfs(n, 0, list);
        return res;
    }

    private void dfs(int n, int index, List<Integer> list) {
        if(index == n) {
            res.add(generate(list, n));
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

    private List<String> generate(List<Integer> list, int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append('.');
        }
        for(int i : list) {
            sb.setCharAt(i, 'Q');
            res.add(sb.toString());
            sb.setCharAt(i, '.');
        }
        return res;
    }
}
