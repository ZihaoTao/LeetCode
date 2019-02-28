import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<Item> q = new LinkedList<>();
        List<List<Integer>> ll = new ArrayList<>();
        q.add(new Item(root, 0));
        while(!q.isEmpty()) {
            Item item = q.remove();
            TreeNode node = item.node;
            int level = item.level;
            if(level == ll.size()) {
                ll.add(new ArrayList<Integer>());
            }
            ll.get(ll.size() - 1).add(node.val);
            if(node.left != null) {
                q.add(new Item(node.left, level + 1));
            }
            if(node.right != null) {
                q.add(new Item(node.right, level + 1));
            }
        }

        for(List<Integer> i : ll) {
            list.add(i.get(i.size() - 1));
        }
        return list;
    }

    private class Item {
        TreeNode node;
        int level;
        private Item(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
