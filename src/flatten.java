public class flatten {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root != null) {
            flatten(root.right);
            flatten(root.left);
            root.right = pre;
            root.left = null;
            pre = root;
        }
    }

    public void test(TreeNode node) {
        if(node != null) {

            test(node.right);
            test(node.left);
            System.out.print(node.val + ", ");
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.right = new TreeNode(6);
        (new flatten()).test(head);
    }
}
