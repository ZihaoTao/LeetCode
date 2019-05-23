import java.util.*;

public class topKFrequent {
    Map<Integer, Integer> map;
    public List<Integer> topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for(int i : map.keySet()) {
            pq.add(i);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(pq.remove());
        }
        return res;
    }
}
