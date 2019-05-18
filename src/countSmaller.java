import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class countSmaller {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums) {
            pq.add(i);
        }

        for(int i : nums) {
            pq.remove(i);
            PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
            int count = 0;
            while(!temp.isEmpty()) {
                if (temp.remove() < i) {
                    count++;
                } else {
                    break;
                }
            }
            res.add(count);
        }
        return res;
    }
}
