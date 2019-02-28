import java.util.PriorityQueue;

class BSTIterator {
    TreeNode root;
    PriorityQueue<Integer> pq;
    public BSTIterator(TreeNode root) {
        this.root = root;
        pq = new PriorityQueue();
        getPQ(root);
    }

    /** @return the next smallest number */
    public int next() {
        return pq.remove();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !pq.isEmpty();
    }

    private void getPQ(TreeNode node) {
        if(node != null) {
            pq.add(node.val);
            getPQ(node.left);
            getPQ(node.right);
        }
    }
}