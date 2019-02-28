import java.util.HashMap;
import java.util.Map;

public class isIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);
            if(!map.containsKey(key) && !map.containsValue(val)) {
                map.put(key, val);
            } else if(map.containsKey(key)){
                if(map.get(key) != val) {
                    return false;
                }
            } else {
                // map.containsValue(val)
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((new isIsomorphic()).isIsomorphic("egg", "aaa"));
    }
}
