import java.util.Stack;

public class kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
        int i = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            i++;
            if(i == k) {
                return node.val;
            }
            TreeNode t = node.right;
            while(t != null) {
                stack.push(t);
                t = t.left;
            }
        }
        return -1;
    }
}
