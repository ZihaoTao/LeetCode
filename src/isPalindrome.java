public class isPalindrome {
    public boolean isPalindrome(int x) {
        String s = x + "";
        int l = 0;
        int r = s.length() - 1;
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    // no string
    public boolean isPalindrome2(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while(x > rev) {
            rev = 10 * rev + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}
