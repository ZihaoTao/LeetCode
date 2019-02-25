import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<Item> q =new LinkedList<>();
        q.add(new Item(beginWord, 1));
        while(!q.isEmpty()) {
            Item item = q.remove();
            String str = item.str;
            int step = item.step;
            if(str.equals(endWord)) {
                return step;
            }
            for(int i = 0; i < wordList.size(); i++) {
                String t = wordList.get(i);
                if(!visited[i] && similar(str, t)) {
                    visited[i] = true;
                    q.add(new Item(t, step + 1));
                }
            }
        }
        return 0;
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

    private class Item{
        String str;
        int step;
        private Item(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }
}
