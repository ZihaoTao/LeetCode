public class reverseVowels {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            while(l < r && !vowels.contains("" + sb.charAt(l))) {
                l++;
            }

            while(r > l && !vowels.contains("" + sb.charAt(r))) {
                r--;
            }

            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
        return sb.toString();
    }
}
