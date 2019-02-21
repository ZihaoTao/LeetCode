public class minWindow {
    public String minWindow(String s, String t) {
        int[] freq = new int[256];
        for(int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]--;
        }
        String res = "";
        int count = s.length() + 1;
        int l = 0;
        int r = -1;
        while(l < s.length()) {
            if(r + 1 < s.length() && !check(freq, t)) {
                freq[s.charAt(++r)] ++;
            } else {
                freq[s.charAt(l++)]--;
            }
            if(check(freq, t) && r - l + 1 < count) {
                res = s.substring(l, r + 1);
                count = r - l + 1;
            }
        }
        return res;
    }

    private boolean check(int[] freq, String t) {
        for(int i = 0; i < t.length(); i++) {
            if(freq[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
