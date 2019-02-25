import java.util.ArrayList;
import java.util.List;

public class partitionPalindrome {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s.length() == 0) return res;
        List<String> list = new ArrayList<>();
        dfs(s, 0, list);
        return res;
    }

    private void dfs(String s, int index, List<String> list) {
        if(index == s.length()) {
            res.add(new ArrayList<String>(list));
        } else {
            for(int i = index + 1; i < s.length() + 1; i++) {
                String temp = s.substring(index, i);
                if(isPalindrome(temp)) {
                    list.add(temp);
                    dfs(s, i, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
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
}
