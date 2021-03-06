import java.util.ArrayList;
import java.util.List;

public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long l, long r) {
        if(root == null) return true;
        if(root.val <= l || root.val >= r) return false;
        return helper(root.left, l, root.val) && helper(root.right, root.val, r);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if(node != null) {
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }
    }
}
