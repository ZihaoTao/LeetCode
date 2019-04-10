import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permuteTest {
    List<String> res;
    Set<Integer> set;
    public List<String> permuteTest(int n) {
        res = new ArrayList<>();
        set = new HashSet<>();

        for(int i = 1; i <= n; i++) {
            set.add(i);
        }
        dfs(n, 0, "");
        return res;
    }

    private void dfs(int n, int index, String s) {
        if(index == n) {
            res.add(s);
        } else {
            for(int i = 1; i <= n; i++) {
                if(set.contains(i)) {
                    set.remove(i);
                    s += i;
                    dfs(n, index + 1, s);
                    s = s.substring(0, s.length() - 1);
                    set.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new permuteTest()).permuteTest(3));
    }
}
