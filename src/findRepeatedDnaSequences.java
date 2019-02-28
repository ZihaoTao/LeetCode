import java.util.*;

public class findRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() < 10) {
            return list;
        }

        Set<String> set = new HashSet<>();
        Set<String> sett = new HashSet<>();
        int l = 0;
        int r = 10;
        while(r <= s.length()) {
            String t = s.substring(l, r);
            if(!set.contains(t)) {
                set.add(t);
            } else {
                sett.add(t);
            }
            l++;
            r++;
        }

        for(String i : sett) {
            list.add(i);
        }
        return list;
    }
}
