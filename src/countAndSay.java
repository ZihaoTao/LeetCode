public class countAndSay {
    public String countAndSay(int n) {
        return dfs(n, "1");
    }

    private String dfs(int n, String s) {
        if(n == 1) {
            return s;
        }
        int count = 1;
        String str = "";
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                str += "" + count + s.charAt(i - 1);
                count = 1;
            }
        }
        str += "" + count + s.charAt(s.length() - 1);
        return dfs(n - 1, str);
    }

    public static void main(String[] args) {
        System.out.println((new countAndSay()).countAndSay(1));
    }
}
