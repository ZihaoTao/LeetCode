import java.util.*;

public class topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        PriorityQueue<Item> pq = new PriorityQueue<>(new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                return o2.freq - o1.freq;
            }
        });

        for(int i : map.keySet()) {
            pq.add(new Item(i, map.get(i)));
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            list.add(pq.remove().n);
        }
        return list;
    }

    private class Item {
        int n;
        int freq;
        public Item(int n, int freq) {
            this.n = n;
            this.freq = freq;
        }
    }
}
