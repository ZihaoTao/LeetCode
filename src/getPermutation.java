import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class getPermutation {
    List<String> res;
    Set<Integer> set;
    public String getPermutation(int n, int k) {
        res = new ArrayList<>();
        if(n == 0) return "";
        set = new HashSet<>();
        dfs(n,"");
        return res.get(k - 1);
    }

    private void dfs(int n, String s) {
        if(n == s.length()) {
            res.add(s);
        } else {
            for(int i = 1; i <= n; i++) {
                if(!set.contains(i)) {
                    set.add(i);
                    s += i;
                    dfs(n, s);
                    s = s.substring(0, s.length() - 1);
                    set.remove(i);
                }
            }
        }
    }
}
