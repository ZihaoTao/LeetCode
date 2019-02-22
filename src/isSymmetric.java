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
}
