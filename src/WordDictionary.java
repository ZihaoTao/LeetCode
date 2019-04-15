class WordDictionary {

    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
        public TrieNode(char c) {
            children = new TrieNode[26];
            this.c = c;
        }
    }

    TrieNode node;
    /** Initialize your data structure here. */
    public WordDictionary() {
        node = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ws = node;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ws.children[ch - 'a'] == null)
                ws.children[ch - 'a'] = new TrieNode(ch);
            ws = ws.children[ch - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        return helper(word, 0, node);
    }


    private boolean helper(String word, int index, TrieNode trie) {
        if(index < word.length()) {
            TrieNode ws = trie;
            char ch = word.charAt(index);
            if(ch != '.') {
                if(ws.children[ch - 'a'] == null) return false;
                ws = ws.children[ch - 'a'];
                return helper(word, index + 1, ws);
            } else {
                for(TrieNode j : ws.children) {
                    if(j != null && helper(word, index + 1, j)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            return trie.isWord;
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */