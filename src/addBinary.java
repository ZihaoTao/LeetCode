public class addBinary {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int[] res = new int[a.length() + b.length()];
        for(int i = 0; i < res.length; i++) {
            if(i < a.length()) res[i] += a.charAt(i) - '0';
            if(i < b.length()) res[i] += b.charAt(i) - '0';
        }

        int carry = 0;
        for(int i = 0; i < res.length; i++) {
            res[i] += carry;
            carry = res[i] / 2;
            res[i] %= 2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = res.length - 1; i >= 0; i--) {
            sb.append(res[i]);
        }

        while(sb.charAt(0) == '0' && sb.length() != 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        (new addBinary()).addBinary("11", "1");
    }
}
