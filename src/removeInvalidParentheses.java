import java.util.*;

public class removeInvalidParentheses {
    Set<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        max = 0;
        set = new HashSet<>();
        dfs(s, 0, "", 0);
        for(String i : set) {
            res.add(i);
        }
        return res;
    }

    private void dfs(String s, int index, String str, int left) {
        if(left == 0 && index == s.length()) {
            if(str.length() >= max) {
                if(str.length() > max) {
                    max = str.length();
                    set = new HashSet<>();
                }
                set.add(str);
            }
        } else if (index < s.length() && s.length() - index + 1 >= left){
            char c = s.charAt(index);
            if(c != '(' && c != ')') {
                dfs(s, index + 1, str + c, left);
            } else if(c == '(') {
                dfs(s, index + 1, str, left);
                dfs(s, index + 1, str + c, left + 1);
            } else {
                if(left != 0) {
                    dfs(s, index + 1, str, left);
                    dfs(s, index + 1, str + c, left - 1);
                } else {
                    dfs(s, index + 1, str, left);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new removeInvalidParentheses()).removeInvalidParentheses(""));
    }
}
