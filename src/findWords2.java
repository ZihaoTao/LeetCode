import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findWords2 {
    List<String> res;
    boolean[][] visited;
    int m,n;
    int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        if(words.length == 0) return res;
        m = board.length;
        if(m == 0) return res;
        n = board[0].length;
        visited = new boolean[m][n];
        TrieNode root = build(words);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int x, int y, TrieNode node) {
        visited[x][y] = true;
        char c = board[x][y];
        if(node.children[c - 'a'] != null) {
            if(node.children[c - 'a'].isWord != null) {
                String s = node.children[c - 'a'].isWord;
                if(!res.contains(s)) res.add(s);
            }
            for(int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    dfs(board, newX, newY, node.children[c - 'a']);
                }
            }
        }
        visited[x][y] = false;
    }

    private class TrieNode {
        String isWord;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode build(String[] words) {
        TrieNode root = new TrieNode();
        for(String i : words) {
            TrieNode node = root;
            for(int j = 0; j < i.length(); j++) {
                char c = i.charAt(j);
                if(node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isWord = i;
        }
        return root;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b'},{'a','a'}};

        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        System.out.println((new findWords2()).findWords(board, words));
    }
}
