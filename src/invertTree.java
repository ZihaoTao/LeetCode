import java.util.LinkedList;
import java.util.Queue;

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return root;
    }
}
