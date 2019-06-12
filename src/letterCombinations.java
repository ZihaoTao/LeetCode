import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    List<String> res;
    String[] arr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) return res;
        dfs(digits, 0, "");
        return res;
    }

    private void dfs(String digits, int index, String s) {
        if(index == digits.length()) {
            res.add(s);
        } else {
            String str = arr[digits.charAt(index) - '2'];
            for(int i = 0; i < str.length(); i++) {
                dfs(digits, index + 1, s + str.charAt(i));
            }
        }
    }
}
