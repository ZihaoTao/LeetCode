import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n == 0) return res;
        dfs("", n, n);
        return res;
    }

    private void dfs(String s, int left, int right) {
        if(left == 0 && right == 0) {
            res.add(s);
        } else if(left <= right){
            if(left > 0) dfs(s + "(", left - 1, right);
            if(right > 0) dfs(s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println((new generateParenthesis()).generateParenthesis(3));
    }
}
