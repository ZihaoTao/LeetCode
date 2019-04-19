import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderII {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(root, 0));
        while(!q.isEmpty()) {
            Item item = q.remove();
            int level = item.level;
            Node node = item.node;
            if(level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            res.get(res.size() - 1).add(node.val);
            for(Node i : node.children) {
                q.add(new Item(i, level + 1));
            }
        }
        return res;
    }

    class Item {
        Node node;
        int level;
        public Item(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
