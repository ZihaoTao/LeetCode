import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class merge {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(Interval i : intervals) {
            pq.add(i);
        }

        while(!pq.isEmpty()) {
            Interval t = pq.remove();
            if(res.size() == 0) {
                res.add(t);
            } else {
                Interval pre = res.get(res.size() - 1);
                if(pre.end < t.start) {
                    res.add(t);
                } else if(pre.end < t.end) {
                    res.remove(res.size() - 1);
                    pre.end = t.end;
                    res.add(pre);
                }
            }
        }
        return res;
    }
}
