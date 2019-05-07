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

        String res = "" + out;
        if (s1 * s2 == -1 && (out > 0 || rem > 0)) res = "-" + res;
        if (rem == 0) return res;
        res += ".";
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        int pos = 0;
        while(rem != 0) {
            if(map.containsKey(rem)) {
                return res +
                        sb.toString().substring(0, map.get(rem)) + '('
                        + sb.toString().substring(map.get(rem)) + ')';
            }
            map.put(rem, pos);
            sb.append(rem * 10 / den);
            rem = (rem * 10) % den;
            ++pos;
        }
        return res + sb.toString();
    }

    public String fractionToDecimal2(int numerator, int denominator) {
        Map<Integer, Integer> map = new HashMap<>();
        int a = numerator / denominator;
        int b = numerator % denominator;
        String s = "";
        b *= 10;
        while(!map.containsKey(b)) {
            map.put(b, s.length());
            s += (b / denominator);
            b = (b % denominator) * 10;
            if(b == 0) return a + "." + s;
        }

        int index = map.get(b);
        s = s.substring(0, index - 1) + '(' + s.substring(index - 1) + ')';
        return a + "." + s;
    }

    public static void main(String[] args) {

        System.out.println((new fractionToDecimal()).fractionToDecimal2(4, 69));
    }
}
