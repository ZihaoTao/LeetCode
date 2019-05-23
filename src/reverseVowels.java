public class reverseVowels {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        String check = "aeiouAEIOU";
        while(l < r) {
            while(l < r && !check.contains(sb.charAt(l) + "")) l++;
            while(l < r && !check.contains(sb.charAt(r) + "")) r--;
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
        return sb.toString();
    }
}
