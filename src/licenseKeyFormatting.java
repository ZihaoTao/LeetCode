public class licenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String s = "";
        for(String i : S.split("-")) {
            s += i;
        }
        s = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        if(s.length() % K == 0) {
            int i = 0;
            while(i < s.length()) {
                sb.append(s.substring(i, i + K) + "-");
                i = i + K;
            }

        } else {
            int i = s.length() % K;
            sb.append(s.substring(0, s.length() % K) + "-");
            while(i < s.length()) {
                sb.append(s.substring(i, i + K) + "-");
                i = i + K;
            }
        }
        if(sb.length() == 0) return "";
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println((new licenseKeyFormatting()).licenseKeyFormatting("2-5g-3-J", 2));
    }
}
