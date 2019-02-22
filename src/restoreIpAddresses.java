import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    List<List<String>> res;
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s == null || s.length() == 0) return ret;
        res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list);
        for(int i = 0; i < res.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for(String j : res.get(i)){
                sb.append(j + ".");
            }
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
        }
        return ret;
    }

    private void dfs(String s, int index, List<String> list) {
        if(index == s.length() && list.size() == 4) {
            res.add(new ArrayList<>(list));
        } else if (list.size() < 4) {
            for(int i = index; i < index + 4 && i < s.length(); i++) {
                String temp = s.substring(index, i + 1);
                if(Integer.parseInt(temp) <= 255) {
                    if(temp.length() != 1 && temp.charAt(0) == '0') {
                        continue;
                    }
                    list.add(s.substring(index, i + 1));
                    dfs(s, i + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        (new restoreIpAddresses()).restoreIpAddresses("010010");
    }
}
