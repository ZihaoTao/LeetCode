import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while(l < s.length()) {
            if(r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(++r));
                res = Math.max(res, r - l + 1);
            } else {
                set.remove(s.charAt(l++));
            }
        }
        return res;
    }
}
