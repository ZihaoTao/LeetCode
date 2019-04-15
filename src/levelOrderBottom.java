import java.util.*;

public class levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(0, root));
        while(!q.isEmpty()) {
            Item item = q.remove();
            TreeNode node = item.node;
            int level = item.level;
            if(level == res.size()) {
                res.add(0, new ArrayList<Integer>());
            }
            res.get(0).add(node.val);
            if(node.left != null) q.add(new Item(level + 1, node.left));
            if(node.right != null) q.add(new Item(level + 1, node.right));
        }
        return res;
    }

    private class Item {
        int level;
        TreeNode node;
        public Item(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        (new levelOrderBottom()).levelOrderBottom(node);
    }
}
