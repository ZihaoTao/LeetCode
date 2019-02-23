import java.util.*;

public class levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Item> q = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        q.add(new Item(0, root));
        while(!q.isEmpty()) {
            Item item = q.remove();
            int level = item.level;
            TreeNode node = item.node;

            if(stack.size() == level) {
                stack.push(new ArrayList<Integer>());
            }
            List<Integer> list = stack.pop();
            list.add(node.val);
            stack.push(list);
            if(node.left != null) {
                q.add(new Item(level + 1, node.left));
            }
            if(node.right != null) {
                q.add(new Item(level + 1, node.right));
            }
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        (new levelOrderBottom()).levelOrderBottom(node);
    }
}
