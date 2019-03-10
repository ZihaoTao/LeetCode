import java.util.ArrayList;
import java.util.List;

public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[26];
        for(int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = -1;
        while(l < s.length()) {
            if(r + 1 < s.length() && r + 1 - l + 1 <= p.length()) {
                r++;
                freq[s.charAt(r) - 'a']--;
            } else {
                if(check(freq)) {
                    list.add(l);
                }
                freq[s.charAt(l) - 'a']++;
                l++;
            }
        }
        return list;
    }

    private boolean check(int[] freq) {
        for(int i : freq) {
            if(i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        (new findAnagrams()).findAnagrams("cbaebabacd", "abc");
    }
}
