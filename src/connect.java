import java.util.LinkedList;
import java.util.Queue;

public class connect {

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(root, 0));
        int count = -1;
        Node pre = null;
        while(!q.isEmpty()) {
            Item item = q.remove();
            Node node = item.node;
            int level = item.level;
            if(level != count) {
                if(pre != null) pre.next = null;
                count++;
            } else {
                pre.next = node;
            }
            pre = node;

            if(node.left != null) q.add(new Item(node.left, level + 1));
            if(node.right != null) q.add(new Item(node.right, level + 1));
        }
        if(pre != null) pre.next = null;
        return root;
    }

    public class Item{
        Node node;
        int level;
        public Item(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void helper(Node root){
        if(root != null){
            Node leftTemp = root.left;
            Node rightTemp = root.right;
            while(leftTemp != null && rightTemp != null){
                leftTemp.next = rightTemp;
                leftTemp = leftTemp.right;
                rightTemp = rightTemp.left;
            }
            helper(root.left);
            helper(root.right);
        }
    }

    public Node connect2(Node root) {
        helper(root);
        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1, null, null, null);
        node.left = new Node(2, null, null, null);
        node.left.left = new Node(3, null, null, null);
        node.left.right = new Node(4, null, null, null);
        node.right = new Node(3, null, null, null);
        node.right.left = new Node(6, null, null, null);
        node.right.right = new Node(7, null, null, null);
        (new connect()).connect2(node);
    }

}
