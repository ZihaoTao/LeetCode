import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int len = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String i : words) {
            len += i.length();
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        if(len > s.length() || len == 0) {
            return res;
        }
        int l = 0;
        int r = len - 1;
        while(r < s.length()) {
            String t = s.substring(l, r + 1);
            Map<String, Integer> temp = new HashMap<>(map);
            int k = words[0].length();
            int index = 0;
            while(index < t.length()) {
                String str = t.substring(index, index + k);
                if(temp.containsKey(str)) {
                    temp.put(str, temp.get(str) - 1);
                    if(check(temp)) {
                        res.add(l);
                    }
                    index = index + k;
                } else {
                    break;
                }
            }
            l++;
            r++;
        }
        return res;
    }
    private boolean check(Map<String, Integer> map) {
        for(String i : map.keySet()) {
            if(map.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}
