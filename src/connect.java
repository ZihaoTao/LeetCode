import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class connect {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(0, root));
        List<List<Node>> list = new ArrayList<>();
        while(!q.isEmpty()) {
            Item item = q.remove();
            int level = item.level;
            Node node = item.node;
            if(level == list.size()) {
                list.add(new ArrayList<Node>());
            }
            list.get(list.size() - 1).add(node);
            if(node.left != null) q.add(new Item(level + 1, node.left));
            if(node.right != null) q.add(new Item(level + 1, node.right));
        }

        for(List<Node> i : list) {
            for(int j = 0; j < i.size() - 1; j++) {
                i.get(j).next = i.get(j + 1);
            }
        }
        return root;
    }

    public class Item {
        int level;
        Node node;
        private Item(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }
}
