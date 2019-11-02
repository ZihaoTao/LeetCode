public class temp {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 0; i < n - 1; i++) {
            s = count(s);
        }
        return s;
    }

    private String count(String s) {
        String res = "";
        int n = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                n++;
            } else {
                res += "" + n + s.charAt(i - 1);
                n = 1;
            }
        }
        res += "" + n + s.charAt(s.length() - 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new temp()).countAndSay(5));
    }
}
