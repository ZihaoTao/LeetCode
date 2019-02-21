import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class insert {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for(Interval i : intervals) {
            pq.add(i);
        }

        pq.add(newInterval);

        while(!pq.isEmpty()) {
            Interval temp = pq.remove();
            if(res.size() == 0) {
                res.add(temp);
            } else {
                Interval temp2 = res.get(res.size() - 1);
                if(!(temp.start > temp2.end || temp.end < temp2.start)) {
                    res.remove(res.size() - 1);
                    int start = Math.min(temp.start, temp2.start);
                    int end = Math.max(temp.end, temp2.end);
                    res.add(new Interval(start, end));
                } else {
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
