public class flatten {
    public void flatten(TreeNode root) {
        if(root != null) {
            flatten(root.left);
            flatten(root.right);
            TreeNode t = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) root = root.right;
            root.right = t;
        }
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
