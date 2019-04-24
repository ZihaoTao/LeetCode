import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class dict {

    public class Trie {
        boolean isWord;
        List<Trie> children;
        String str;
        public Trie() {
            children = new ArrayList<>();
        }

        public Trie(String str) {
            this.str = str;
            children = new ArrayList<>();
        }
    }
    private void dict(String str, Trie trie) {

        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < str.length()) {
            char c = str.charAt(i);
            if(c == '{') {
                stack.push(i);
            } else if (c == '}') {
                String s = str.substring(stack.pop() + 1, i);
                String key = s.split(":")[0];
                String res = s.split(":")[1];
                if(key.length() != 0) {
                    Trie t = new Trie(key);
                    dict(res, t);

                }
            }

        }
    }
}
