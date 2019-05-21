import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class removeDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;
        // 使用charCounter array，我们可以知道在某一个字符后面是否还有另一个字符。
        int[] charCounter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charCounter[s.charAt(i)]++;
        }

        Set<Character> hashSet = new HashSet<Character>();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (!hashSet.contains(s.charAt(i))) {
                while (!stack.isEmpty() && stack.peek() > s.charAt(i) && charCounter[stack.peek()] >= 1) {
                    hashSet.remove(stack.peek());
                    stack.pop();
                }
                stack.push(s.charAt(i));
                hashSet.add(s.charAt(i));
            }
            charCounter[s.charAt(i)]--;
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}
