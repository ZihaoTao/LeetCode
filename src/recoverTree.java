public class recoverTree {
    TreeNode pre, first, second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(first, second);
    }

    private void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            if(pre == null) {
                pre = root;
            } else {
                if(pre.val > root.val) {
                    if(first == null) {
                        first = pre;
                    }
                    second = root;
                }
                pre = root;
            }
            inorder(root.right);
        }
    }

    private void swap(TreeNode p, TreeNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        (new recoverTree()).recoverTree(root);
    }
}
