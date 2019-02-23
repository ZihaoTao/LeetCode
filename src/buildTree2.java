public class buildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int l, int r, int[] postorder, int index) {
        if(l > r) return null;
        for(int i = l; i <= r; i++) {
            if(postorder[index] == inorder[i]) {
                TreeNode node = new TreeNode(postorder[index]);
                node.right = helper(inorder, i + 1, r, postorder, index - 1);
                node.left = helper(inorder, l, i - 1, postorder, index - 1 - (r - i));
                return node;
            }
        }
        return null;
    }
}
