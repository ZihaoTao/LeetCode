public class countNodes {
    public int countNodes(TreeNode root) {
        int hL = 0, hR = 0;
        TreeNode left = root, right = root;
        while(left != null) {
            left = left.left;
            hL++;
        }

        while(right != null) {
            right = right.right;
            hR++;
        }
        if(hL == hR) return (int)Math.pow(2, hR) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
