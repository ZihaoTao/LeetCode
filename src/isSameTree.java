public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            if(p != null || q != null) {
                return false;
            } else {
                return true;
            }
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
