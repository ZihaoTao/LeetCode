import java.util.*;

public class cloneGraph {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return dfs(node, new HashMap<Node, Node>());
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if(!map.containsKey(node)) {
            map.put(node, new Node(node.val, new ArrayList<Node>()));
            for(Node i : node.neighbors) {
                map.get(node).neighbors.add(dfs(i, map));
            }
        }
        return map.get(node);
    }
}
