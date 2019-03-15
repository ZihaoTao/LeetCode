import java.util.LinkedList;
import java.util.Queue;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            if (left != null || right != null) {
                return false;
            }
            return true;
        }
        return left.val == right.val && mirror(left.left, right.right) && mirror(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
