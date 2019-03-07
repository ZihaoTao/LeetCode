import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ']') {
                stack.push(s.charAt(i) + "");
            } else {
                String t = "";
                while(!stack.peek().equals("[")) {
                    t = stack.pop() + t;
                }
                stack.pop();
                String n = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    n = stack.pop() + n;
                }
                int num = Integer.parseInt(n);
                String res;
                if(stack.isEmpty() || stack.peek().equals("[")) {
                    res = "";
                } else {
                    res = stack.pop();
                }
                for(int j = 0; j < num; j++) {
                    res += t;
                }
                stack.push(res);
            }
        }
        while(stack.size() > 1) {
            String t = stack.pop();
            stack.push(stack.pop() + t);
        }

        return stack.size() == 0 ? "" : stack.pop();
    }
}
