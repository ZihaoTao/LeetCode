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

    int res = -1;
    public int kthSmallest2(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    private void helper(TreeNode root, int k) {
        if(root != null) {
            helper(root.left, k - 1);
            if (k == 0) {
                res = root.val;
            }
            helper(root.right, k - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        System.out.println((new kthSmallest()).kthSmallest2(node, 1));
    }
}
