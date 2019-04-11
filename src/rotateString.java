public class rotateString {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.length() == 0) return true;
        char a = A.charAt(0);
        int i = 0;
        while(i < B.length()) {
            if(B.charAt(i) == a) {
                break;
            }
            i++;
        }
        if(i == B.length()) return false;
        System.out.println(B);
        B = reverse(B, 0, i - 1);
        System.out.println(B);
        B = reverse(B, i, B.length() - 1);
        System.out.println(B);
        B = reverse(B, 0, B.length() - 1);
        System.out.println(B);
        return B.equals(A);
    }

    private String reverse(String s, int l, int r) {
        StringBuilder sb = new StringBuilder(s);
        while(l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, s.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
        return sb.toString();
    }

    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static void main(String[] args) {
        System.out.println((new rotateString()).rotateString("abcde", "cdeab"));
    }
}
