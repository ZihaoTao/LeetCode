public class convertBST {
    int count = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null) {
            convertBST(root.right);
            count += root.val;
            root.val = count;
            convertBST(root.left);
        }
        return root;
    }

}
