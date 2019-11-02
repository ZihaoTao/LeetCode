import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] chars = new int[128];
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.contains(c)) {
                while(!stack.isEmpty() && stack.peek() > c && chars[stack.peek()] >= 1) stack.pop();
                stack.push(c);
            }
            chars[c]--;
        }
        String res = "";
        while(!stack.isEmpty()) res = stack.pop() + res;
        return res;
    }
}
