import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = s.pop();
        int res = n.val;
        TreeNode node = n.right;
        while(node != null) {
            s.push(node);
            node = node.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}