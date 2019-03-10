public class pathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root != null) {
            return check(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }
        return 0;
    }

    private int check(TreeNode root, int sum) {
        if(root == null) return 0;
        if(root.val == sum) return 1 + check(root.left, sum - root.val) + check(root.right, sum - root.val);
        return check(root.left, sum - root.val) + check(root.right, sum - root.val);
    }
}
