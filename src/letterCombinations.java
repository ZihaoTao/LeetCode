import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    List<String> res;
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.length() == 0) {
            return res;
        }

        dfs(digits, "", 0);
        return res;
    }

    private void dfs(String digits, String str, int index) {
        if(index == digits.length()) {
            res.add(str);
        } else {
            String temp = map.get(digits.charAt(index));
            for(int j = 0; j < temp.length(); j++) {
                str += temp.charAt(j);
                dfs(digits, str, index + 1);
                str = str.substring(0, str.length() - 1);
            }
        }
    }
}
