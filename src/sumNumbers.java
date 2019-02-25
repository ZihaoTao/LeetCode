public class sumNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }

    private int helper(TreeNode node, int count) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return node.val + count;
        return helper(node.left, 10 * (node.val + count)) + helper(node.right, 10 * (node.val + count));
    }
}
