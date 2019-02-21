import java.util.*;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            String key = sort(str);
            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String i : map.keySet()) {
            res.add(map.get(i));
        }
        return res;
    }

    private String sort(String s) {
        Character[] cs = new Character[s.length()];
        for(int i = 0; i < s.length(); i++) {
            cs[i] = s.charAt(i);
        }
        Arrays.sort(cs);
        StringBuilder sb = new StringBuilder();
        for(Character i : cs) {
            sb.append(i);
        }
        return sb.toString();
    }
}
