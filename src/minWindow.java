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

    public String minWindow2(String s, String t) {
        int[] freqT = new int[256];
        for(int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i)]++;
        }

        int[] freqS = new int[256];

        int l = 0;
        int r = -1;
        String res = "";
        int count = Integer.MAX_VALUE;
        int sCnt = 0;
        while(l < s.length()) {
            if(r + 1 < s.length() && sCnt < t.length()) {
                r++;
                freqS[s.charAt(r)]++;
                if(freqS[s.charAt(r)] <= freqT[s.charAt(r)]) {
                    sCnt++;
                }
            } else {
                if(r - l + 1 < count && sCnt == t.length()) {
                    count = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                freqS[s.charAt(l)] --;
                if(freqS[s.charAt(l)] < freqT[s.charAt(l)]) {
                    sCnt --;
                }
                l ++;
            }
        }
        return res;
    }
}
