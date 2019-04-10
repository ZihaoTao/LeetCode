import java.util.ArrayList;
import java.util.List;

public class addOperators {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        dfs(num, target, 0, 0, "");
        return res;
    }

    private void dfs(String num, int target, long diff, long curNum,  String out) {
        if(num.length() == 0 && target == curNum) {
            res.add(out);
        } else {
            for(int i = 0; i < num.length(); i++) {
                String cur = num.substring(0, i + 1);
                if(cur.length() > 1 && cur.charAt(0) == '0') return;
                String next = num.substring(i + 1);
                if(out.length() > 0) {
                    dfs(next, target, Long.parseLong(cur), curNum + Long.parseLong(cur), out + "+" + cur);
                    dfs(next, target, -Long.parseLong(cur), curNum - Long.parseLong(cur), out + "-" + cur);
                    dfs(next, target, diff * Long.parseLong(cur), (curNum - diff) + diff * Long.parseLong(cur), out + "*" + cur);
                } else {
                    dfs(next, target, Long.parseLong(cur), Long.parseLong(cur), cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new addOperators()).addOperators("2147483648", -2147483648));
    }

    //"2147483648"
    //-2147483648
}
