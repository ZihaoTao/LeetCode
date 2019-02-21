import java.util.ArrayList;
import java.util.List;

public class combine {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list);
        return res;
    }

    private void dfs(int n, int k, int index, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for(int i = index; i <= n; i ++) {
                    list.add(i);
                    dfs(n, k, i + 1, list);
                    list.remove(list.size() - 1);
            }
        }
    }
}
