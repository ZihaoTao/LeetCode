public class shortestPalindrome {

    public String shortestPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        int i = r;
        while(l < r) {
            if(s.charAt(l) == s.charAt(i)) {
                l++;
                i--;
            } else {
                l = 0;
                r--;
                i = r;
            }
        }
        return (new StringBuilder(s.substring(r + 1))).reverse().toString() + s;
    }

    public static void main(String[] args) {
        System.out.println((new shortestPalindrome()).shortestPalindrome("abbacd"));
    }
}
