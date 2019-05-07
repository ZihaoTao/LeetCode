import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public class DoubleLinkedListNode {
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;
        int val;
        int key;
        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    int capacity;
    int size;
    DoubleLinkedListNode head;
    DoubleLinkedListNode end;
    Map<Integer, DoubleLinkedListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            node.val = value;
            removeNode(node);
            setHead(node);
        } else {
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            if(size < capacity) {
                size++;
            } else {
                map.remove(end.key);
                end = end.pre;
                if(end != null) {
                    end.next = null;
                }
            }
            map.put(key, node);
            setHead(node);
        }
    }

    private void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;
        if(head != null) {
            head.pre = node;
        }
        head = node;
        if(end == null) {
            end = node;
        }
    }

    private void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode pre = node.pre;
        DoubleLinkedListNode post = node.next;

        if(pre != null) {
            pre.next = post;
        } else {
            head = post;
        }
        if(post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */