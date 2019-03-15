public class flatten {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
        } else if (root.left != null) {
            TreeNode t = root.left;
            while(t.right != null) {
                t = t.right;
            }
            t.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.right = new TreeNode(6);
        (new flatten()).flatten(head);
    }
}
