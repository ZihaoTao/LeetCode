import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class generateParenthesis {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            stack.push('(');
        }
        dfs("", n, n);
        return res;
    }

    private void dfs(String str, int left, int right) {
        if(left == 0 && right == 0) {
            res.add(str);
        } else {
            if(left <= right) {
                if(left > 0) dfs(str + '(', left - 1, right);;
                if(right > 0) dfs(str + ')', left, right - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new generateParenthesis()).generateParenthesis(3));
    }
}
