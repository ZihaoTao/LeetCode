import java.util.*;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String i : strs) {
            char[] cs = i.toCharArray();
            Arrays.sort(cs);
            String s = String.valueOf(cs);
            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(i);
        }
        return new ArrayList<>(map.values());
    }
}
