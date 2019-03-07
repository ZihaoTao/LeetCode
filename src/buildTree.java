public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int index, int[] inorder, int l, int r) {
        if(l > r) return null;
        for(int i = 0; i < preorder.length; i++) {
            if(preorder[index] == inorder[i]) {
                TreeNode node = new TreeNode(preorder[index]);
                node.left = helper(preorder, index + 1, inorder, l, i - 1);
                node.right = helper(preorder, index + 1 + i - l, inorder, i + 1, r);
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {2, 1, 2};
        (new buildTree()).buildTree(nums1, nums2);
    }
}
