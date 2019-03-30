class TrieNode {
    char c;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    public TrieNode(char c) {
        this.c = c;
    }
}

class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, root);
    }

    private boolean helper(String word, TrieNode node) {
        if(word.length() == 0) return node.isWord;

        char c = word.charAt(0);
        boolean res = false;
        if(c != '.') {
            if(node.children[c - 'a'] == null) return false;
            return helper(word.substring(1), node.children[c - 'a']);
        } else {
            for (TrieNode j : node.children) {
                if(j != null) {
                    res = res || helper(word.substring(1), j);
                }
            }
            return res;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */