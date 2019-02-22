import java.util.*;

public class grayCode {
    Set<String> set;
    List<String> list;
    public List<Integer> grayCode(int n) {
        set = new HashSet<>();
        list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        String s = "";
        for(int i = 0; i < n; i++) {
            s += "0";
        }
        dfs(n, 0, s);
        for(String i : list) {
            res.add(toInt(i));
        }
        return res;
    }

    private void dfs(int n, int index, String s) {
        if(!set.contains(s) && set.size() < Math.pow(2, n)) {
            list.add(s);
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(s);
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                } else {
                    sb.setCharAt(i, '0');
                }
                dfs(n, index + 1, sb.toString());
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
        (new grayCode()).grayCode(2);
    }
}
