import java.util.LinkedList;
import java.util.List;

class LRUCache {
    int capacity;
    int count;
    List<Integer> list;
    List<Integer> nums;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        list = new LinkedList<>();
        nums = new LinkedList<>();
    }

    public int get(int key) {
        if(!list.contains(key)) {
            return -1;
        } else {
            int index = list.indexOf(key);
            return nums.get(index);
        }
    }

    public void put(int key, int value) {
        if(count != capacity) {
            if(list.contains(key)) {
                int index = list.indexOf(key);
                nums.set(index, value);
            } else {
                list.add(key);
                nums.add(value);
                count++;
            }
        } else {
            list.remove(list.size() - 1);
            nums.remove(nums.size() - 1);
            list.add(0, key);
            nums.add(0, value);
        }
    }

    // TODO: 2019-02-26 not right
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4, 1);
        System.out.println(cache.get(2));       // returns -1 (not found)
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */