import java.util.ArrayList;
import java.util.List;

public class findLadders {
    List<List<String>> res;
    boolean[] used;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        used = new boolean[wordList.size()];
        dfs(beginWord, endWord, wordList, list);

        int min = Integer.MAX_VALUE;
        for(List<String> i : res) {
            min = Math.min(min, i.size());
        }
        List<List<String>> ret = new ArrayList<>();
        for(List<String> i : res) {
            if(i.size() == min) {
                ret.add(i);
            }
        }
        return ret;
    }

    private void dfs(String input, String end, List<String> wordList, List<String> list) {
        if(input.equals(end)) {
            res.add(new ArrayList<String>(list));
        } else {
            for(int i = 0; i < wordList.size(); i++) {
                String temp = wordList.get(i);
                if(similar(input, temp) && !used[i]) {
                    list.add(temp);
                    used[i] = true;
                    dfs(temp, end, wordList, list);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    private boolean similar(String a, String b) {
        if(a.length() == b.length()) {
            int count = 0;
            for(int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
        return false;
    }
}
