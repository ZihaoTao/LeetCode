public class maxPathSum {
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        res = Math.max(res, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    //int maxPathSum(TreeNode* root) {
    //        int res = INT_MIN;
    //        helper(root, res);
    //        return res;
    //    }
    //    int helper(TreeNode* node, int& res) {
    //        if (!node) return 0;
    //        int left = max(helper(node->left, res), 0);
    //        int right = max(helper(node->right, res), 0);
    //        res = max(res, left + right + node->val);
    //        return max(left, right) + node->val;
    //    }
}
