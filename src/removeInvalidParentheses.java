import java.util.*;

public class removeInvalidParentheses {
    List<String> ret;
    Set<String> set;
    int length;
    public List<String> removeInvalidParentheses(String s) {
        length = 0;
        ret = new ArrayList<>();
        set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        dfs(s, 0, "", stack);
        for(String i : set) {
            ret.add(i);
        }
        return ret;
    }

    private void dfs(String s, int index, String str, Stack<Character> stack) {
        if(stack.isEmpty() && index == s.length()) {
            if(str.length() >= length) {
                if(str.length() > length) {
                    set = new HashSet<>();
                    length = str.length();
                }
                set.add(str);
            }
        } else if (index < s.length()){
            char c = s.charAt(index);
            if(c != '(' && c != ')') {
                dfs(s, index + 1, str + c, stack);
            } else if(c == '(') {
                dfs(s, index + 1, str, stack);
                stack.push(c);
                dfs(s, index + 1, str + c, stack);
                stack.pop();
            } else {
                if(stack.isEmpty()) {
                    dfs(s, index + 1, str, stack);
                } else {
                    dfs(s, index + 1, str, stack);
                    char t = stack.pop();
                    dfs(s, index + 1, str + c, stack);
                    stack.push(t);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new removeInvalidParentheses()).removeInvalidParentheses(""));
    }
}
