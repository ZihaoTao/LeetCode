public class countDigitOne {
    public int countDigitOne(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(i);
        }
        int[] num = new int[sb.length()];
        for(int i = 0; i < sb.length(); i++) {
            num[i] = sb.charAt(i) - '0';
        }
        int count = 0;
        for(int i : num) {
            if(i == 1) {
                count++;
            }
        }
        return count;
    }
}
