import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class addOperators {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        if(num.length() == 0) return res;
        dfs(num, target, 0, "");
        List<String> list = new ArrayList<>();
        for(String i : res) {
            int count = 0;
            for(int j = 0; j < i.length(); j++) {
                if(Character.isDigit(i.charAt(j))) {
                    count++;
                }
            }
            if(count == num.length()) {
                list.add(i);
            }
        }
        return list;
    }

    private void dfs(String num, int target, int index, String s) {
        if(index == num.length() && calculate(s) == target) {
            res.add(s);
        } else if(index < num.length()){
            if(s.length() == 0 || !Character.isDigit(s.charAt(s.length() - 1)) || check(s)) {
                s += num.charAt(index);
                dfs(num, target, index + 1, s);
            }
            if(index != num.length() - 1) {
                s += "+";
                dfs(num, target, index + 1, s);
                s = s.substring(0, s.length() - 1);
                s += "-";
                dfs(num, target, index + 1, s);
                s = s.substring(0, s.length() - 1);
                s += "*";
                dfs(num, target, index + 1, s);
            }
        }
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                int j = i;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                if(s.substring(j, i).equals("" + num)) {
                    stack.push(num);
                } else {
                    return 0;
                }
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

    private boolean check(String s) {
        int i = s.length() - 1;
        while(i >= 0 && Character.isDigit(s.charAt(i))) {
            i--;
        }
        return s.charAt(i + 1) != '0';
    }

    public static void main(String[] args) {
        System.out.println((new addOperators()).addOperators("2147483648", -2147483648));
    }

    //"2147483648"
    //-2147483648
}
