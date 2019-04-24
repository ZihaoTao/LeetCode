import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        if(root == null) return res;
        Stack<Item> stack = new Stack<>();
        stack.push(new Item(root, "Go"));
        while(!stack.isEmpty()) {
            Item item = stack.pop();
            String command = item.command;
            Node node = item.node;
            if(command.equals("Print")) {
                res.add(node.val);
            } else {
                stack.push(new Item(node, "Print"));
                List<Node> children = node.children;
                for(int i = children.size() - 1; i >= 0; i--) {
                    stack.push(new Item(children.get(i), "Go"));
                }
            }
        }
        return res;
    }

    public class Item {
        Node node;
        String command;
        public Item(Node node, String command) {
            this.node = node;
            this.command = command;
        }
    }


    //List<Integer> res;
    public List<Integer> postorder2(Node root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    private void helper(Node node) {
        if(node != null) {
            for(Node i : node.children) {
                helper(i);
            }
            res.add(node.val);
        }
    }
}
