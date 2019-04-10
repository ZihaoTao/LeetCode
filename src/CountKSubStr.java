import java.util.ArrayList;
import java.util.List;

public class CountKSubStr {
    public List<String> countkDist(String str, int k) {
        List<String> res = new ArrayList<>();
        int l = 0;
        int r = -1;
        int t = 0;
        int max = 0;
        while(l < str.length()) {
            if(r + 1 < str.length() && (t < k || (t == k && str.substring(l, r + 1).contains("" + str.charAt(r + 1))))) {
                if(!str.substring(l, r + 1).contains("" + str.charAt(r + 1))) {
                    t++;
                }
                r++;
            } else {
                if(!str.substring(l + 1, r + 1).contains("" + str.charAt(l))) {
                    t--;
                }
                l++;
            }
            if(t > 0 && t <= k) {
                if(max < t) {
                    max = t;
                    res = new ArrayList<>();
                }
                if(max == t) res.add(str.substring(l, r + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new CountKSubStr()).countkDist("eceba", 2));
    }
}
