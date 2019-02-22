import java.util.ArrayList;
import java.util.List;

public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode node, int min, int max) {
        if(node == null) return true;

        if(node.val < min || node.val > max) {
            return false;
        }
        boolean res = true;

        if(node.left != null) {
            res = res && node.val > node.left.val;
        }
        if(node.right != null) {
            res = res && node.val < node.right.val;
        }
        return res && helper(node.left, min, node.val - 1) && helper(node.right, node.val + 1, max);
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
