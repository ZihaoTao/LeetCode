import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    //public boolean wordBreak(String s, List<String> wordDict) {
    //        if(s.length() == 0) return true;
    //        return dfs(s, wordDict, "");
    //    }
    //
    //    private boolean dfs(String s, List<String> wordDict, String str) {
    //        if(str.equals(s)) {
    //            return true;
    //        }
    //        for(String i : wordDict) {
    //            int length = i.length();
    //            str += i;
    //            if(str.length() <= s.length()) {
    //                if(dfs(s, wordDict, str)) {
    //                    return true;
    //                }
    //            }
    //            str = str.substring(0, str.length() - length);
    //        }
    //        return false;
    //    }
    HashMap<String, List<String>> map;
    public List<String> wordBreak2(String s, List<String> wordDict) {
        map = new HashMap<>();
        if (s == null || s.length() == 0 || wordDict == null) {
            return null;
        }

        return dfs(s, wordDict);
    }

    public List<String> dfs(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<>();
        int len = s.length();
        if(len == 0) {
            list.add("");
        } else {
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);
                if (wordDict.contains(sub)) {
                    List<String> listRight = dfs(s.substring(i, len), wordDict);
                    for (String r : listRight) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(sub + " " + r);
                        sb.deleteCharAt(sb.length() - 1);
                        list.add(sb.toString());
                    }
                }
            }
        }
        map.put(s, list);
        return list;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] ss = {"cat", "cats", "and", "sand", "dog"};
        List<String> list= new ArrayList<>();
        for(String i : ss) {
            list.add(i);
        }
        List<String> res = (new wordBreak()).wordBreak2(s, list);
        for(String i : res) {
            System.out.println(i);
        }
    }
}
