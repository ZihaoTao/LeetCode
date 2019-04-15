public class binaryGap {
    public int binaryGap(int N) {
        String s = "";
        while(N > 0) {
            s = N % 2 + s;
            N /= 2;
        }
        int count = 0;
        int i;
        for(i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0' == 1) break;
        }
        for(int j = i + 1; j < s.length(); j++) {
            if(s.charAt(j) - '0' == 1) {
                count = Math.max(count, j - i);
                i = j;
            }
        }
        return count;
    }
}
