import java.util.HashMap;
import java.util.Map;

public class copyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(head, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if(!map.containsKey(node)) {
            map.put(node, new Node(node.val, null, null));
            if(node.next != null) {
                map.get(node).next = dfs(node.next, map);
            }
            if(node.random != null) {
                map.get(node).random = dfs(node.random, map);
            }
        }
        return map.get(node);
    }



    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}
