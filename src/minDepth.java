public class minDepth {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            return root.left != null ? minDepth(root.left) + 1 : minDepth(root.right) + 1;
        }
    }
}
