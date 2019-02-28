import java.util.HashMap;
import java.util.Map;

public class fractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        int s1 = numerator >= 0 ? 1 : -1;
        int s2 = denominator >= 0 ? 1 : -1;
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long out = num / den;
        long rem = num % den;

        Map<Long, Integer> map = new HashMap<>();
        String res = "" + out;
        if (s1 * s2 == -1 && (out > 0 || rem > 0)) res = "-" + res;
        if (rem == 0) return res;
        res += ".";
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while(rem != 0) {
            if( map.containsKey(rem)) {
                sb.setCharAt(map.get(rem), '(');
                sb.append(')');
                return sb.toString();
            }
            map.put(rem, pos);
            sb.append(rem * 10 / den);
            rem = (rem * 10) % den;
            ++pos;
        }
        return res + sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((new fractionToDecimal()).fractionToDecimal(4, 69));
    }
}
