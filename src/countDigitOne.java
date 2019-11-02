import java.util.Arrays;

public class countDigitOne {
    public int countDigitOne(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(i);
        }
        int count = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println((new countDigitOne()).countDigitOne(13));
    }
}
