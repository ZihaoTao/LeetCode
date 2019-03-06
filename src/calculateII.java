import java.util.Stack;

public class calculateII {
    public long calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                stack.push(num);
                i--;
            } else if(s.charAt(i) == '+') {
                stack.push(1);
            } else if (s.charAt(i) == '-') {
                stack.push(-1);
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                char c = s.charAt(i);
                int b = stack.pop();
                int num = 0;
                while(!Character.isDigit(s.charAt(i))) i++;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                if(c == '*') {
                    stack.push(b * num);
                } else {
                    stack.push(b / num);
                }
                i--;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            int a = stack.pop();
            int b = stack.pop();
            res += a * b;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new calculateII()).calculate("9223372036854775807"));
    }
}
