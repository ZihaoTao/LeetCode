import java.util.*;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Item> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(new Item(0, root));
        while(!q.isEmpty()) {
            Item item = q.remove();
            int level = item.level;
            TreeNode node = item.node;
            if(res.size() == level) {
                if(level % 2 == 0 && level > 0) {
                    while(!s.isEmpty()) {
                        res.get(res.size() - 1).add(s.pop());
                    }
                }
                res.add(new ArrayList<Integer>());
            }
            if(level % 2 == 0) {
                res.get(res.size() - 1).add(node.val);
            } else {
                s.push(node.val);
            }

            if(node.left != null) {
                q.add(new Item(level + 1, node.left));
            }
            if(node.right != null) {
                q.add(new Item(level + 1, node.right));
            }
        }
        while(!s.isEmpty()) {
            res.get(res.size() - 1).add(s.pop());
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
}
