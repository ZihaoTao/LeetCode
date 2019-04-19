import java.util.Stack;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    res = Math.max(res, (stack.isEmpty() ? i - start + 1 : i - stack.peek()));
                }
            }
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty())
                    res = Math.max(res, i - stack.peek());
                else stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new longestValidParentheses()).longestValidParentheses2("))"));
    }
}
