import java.util.Arrays;
import java.util.Comparator;

public class maxProductString {
    public int maxProduct(String[] words) {
        int res = 0;
        for(int i = 0; i < words.length; i++) {
            char[] cs = new char[words[i].length()];
            for(int j = 0; j < words[i].length(); j++) {
                cs[j] = words[i].charAt(j);
            }
            Arrays.sort(cs);
            for(int j = i + 1; j < words.length; j++) {
                if(!check(cs, words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private boolean check(char[] cs, String s2) {
        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int l = 0;
            int r = cs.length - 1;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(cs[mid] == c) {
                    return true;
                } else if (cs[mid] < c) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"a","ab","abc","d","cd","bcd","abcd"};
        System.out.println((new maxProductString()).maxProduct(words));
    }
}
