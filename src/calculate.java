import java.util.Stack;

public class calculate {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                res += sign * num;
                i--;
            } else if(s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if(s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0; // reset
                sign = 1; // reset
            } else if(s.charAt(i) == ')') {
                res *= stack.pop(); // * sign
                res += stack.pop(); // + num
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new calculate()).calculate("0"));
    }
}
