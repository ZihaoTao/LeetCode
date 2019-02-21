import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsValue(c)) {
                stack.push(c);
            } else {
                // if there is no element left in the map or does not match
                if(stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // the stack must be empty at the end
    }
}
