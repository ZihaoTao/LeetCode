import java.util.Arrays;

public class buildTree3 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if(n == 0) return null;
        TreeNode node = new TreeNode(pre[0]);
        if(n == 1) return node;
        for(int i = 0; i < n; i++) {
            if(post[i] == pre[1]) {
                int l = i + 1;
                node.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, l + 1), Arrays.copyOfRange(post, 0, l));
                node.right = constructFromPrePost(Arrays.copyOfRange(pre, l + 1, n), Arrays.copyOfRange(post, l, n - 1));
                return node;
            }
        }
        return null;
    }
}
