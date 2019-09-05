import java.util.*;

public class findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) return res;
        int len = words[0].length();
        int size = words.length * len;
        Map<String, Integer> map = new HashMap<>();
        for(String i : words) {
            if(!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(s.length() - i < size) return res;
            Map<String, Integer> temp = new HashMap<>(map);
            for(int j = i + len;  j - i <= size && j <= s.length(); j += len) {
                String str = s.substring(j - len, j);
                if(temp.containsKey(str) && temp.get(str) > 0) {
                    if(temp.get(str) == 1) temp.remove(str);
                    else temp.put(str, temp.get(str) - 1);
                } else {
                    break;
                }
                if(temp.size() == 0) res.add(i);
            }
        }
        return res;
    }
}
