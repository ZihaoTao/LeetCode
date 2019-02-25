import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
    List<Integer> list;
    public List<Integer> preorderTraversal(TreeNode root) {
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
                stack.push(new Item("Go", node.left));
                stack.push(new Item("Print", node));
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
