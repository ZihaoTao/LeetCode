public class isPalindromeString {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while(l <= r) {
            if(!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
                r--;
            } else {
                if(s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            while(l < r && !Character.isLetter(s.charAt(l))) {
                l++;
            }
            while(l < r && !Character.isLetter(s.charAt(r))) {
                r--;
            }
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        (new isPalindromeString()).isPalindrome2("0P");
    }
}
