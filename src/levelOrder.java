import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(0, root));
        while(!q.isEmpty()) {
            Item item = q.remove();
            int level = item.level;
            TreeNode node = item.node;
            if(res.size() == level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(res.size() - 1).add(node.val);

            if(node.left != null) {
                q.add(new Item(level + 1, node.left));
            }
            if(node.right != null) {
                q.add(new Item(level + 1, node.right));
            }
        }
        return res;
    }

    private class Item {
        int level;
        TreeNode node;
        private Item(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if(node != null) {
            if(res.size() == level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(node.val);
            if(node.left != null) helper(node.left, level + 1, res);
            if(node.right != null) helper(node.right, level + 1, res);
        }
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            for(int i = q.size(); i > 0; i--) {
                TreeNode t = q.remove();
                oneLevel.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            res.add(oneLevel);
        }
        return res;
    }

}
