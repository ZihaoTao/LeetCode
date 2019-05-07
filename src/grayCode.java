import java.util.*;

public class grayCode {
    Set<String> set;
    List<Integer> res;
    public List<Integer> grayCode(int n) {
        set = new HashSet<>();
        res = new ArrayList<>();
        String s = "";
        for(int i = 0; i < n; i++) {
            s += "0";
        }
        dfs(n, s);
        return res;
    }

    private void dfs(int n, String s) {
        if(!set.contains(s) && res.size() < Math.pow(2, n)) {
            set.add(s);
            res.add(toInt(s));
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(s);
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                } else {
                    sb.setCharAt(i, '0');
                }
                dfs(n, sb.toString());
            }
        }
    }

    private int toInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res = res * 2 + (s.charAt(i) - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new grayCode()).grayCode(2));
    }
}
