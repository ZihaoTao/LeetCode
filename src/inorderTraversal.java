import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return list;
    }

    private void inorder(TreeNode node) {
        if(node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        list = new ArrayList<>();
        Stack<Item> stack = new Stack<>();
        stack.push(new Item("Go", root));
        while(!stack.isEmpty()) {
            Item item = stack.pop();
            String s = item.s;
            TreeNode node = item.node;
            if(s.equals("Print")) {
                list.add(node.val);
            } else if(node != null) {
                stack.push(new Item("Go", node.right));
                stack.push(new Item("Print", node));
                stack.push(new Item("Go", node.left));
            }
        }
        return list;
    }

    private class Item{
        String s;
        TreeNode node;
        private Item(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }
}
