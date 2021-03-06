public class diStringMatch {
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int lo = 0;
        int hi = S.length();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'I') {
                res[i] = lo++;
            } else {
                res[i] = hi--;
            }
        }
        res[S.length()] = hi;
        return res;
    }
}
