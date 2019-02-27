import java.util.Stack;

public class evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String s = "+-*/";
        for(int i = 0; i < tokens.length; i++) {
            if(!s.contains(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if(tokens[i].equals("+")) {
                    stack.push(b + a);
                }
                if(tokens[i].equals("-")) {
                    stack.push(b - a);
                }
                if(tokens[i].equals("*")) {
                    stack.push(b * a);
                }
                if(tokens[i].equals("/")) {
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }
}
