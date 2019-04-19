import java.util.LinkedList;
import java.util.Queue;

public class addOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(root, 1));
        while(!q.isEmpty()) {
            Item item = q.remove();
            int level = item.level;
            TreeNode node = item.node;
            if(node.left != null) q.add(new Item(node.left, level + 1));
            if(node.right != null) q.add(new Item(node.right, level + 1));
            if(level + 1 == d) {
                TreeNode temp1 = new TreeNode(v);
                temp1.left = node.left;
                node.left = temp1;
                TreeNode temp2 = new TreeNode(v);
                temp2.right = node.right;
                node.right = temp2;
            }
        }
        return root;
    }
    class Item {
        TreeNode node;
        int level;
        public Item(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
