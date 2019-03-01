import java.util.LinkedList;
import java.util.Queue;

public class countNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node != null) {
                res ++;
                q.add(node.left);
                q.add(node.right);
            }
        }
        return res;
    }
}
