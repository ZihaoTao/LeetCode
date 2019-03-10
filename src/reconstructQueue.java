import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for(int[] i : people) {
            pq.add(i);
        }
        List<int[]> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            list.add(pq.remove());
        }
        List<int[]> res = new ArrayList<>();
        for(int[] i : list) {
            res.add(i[1], i);
        }
        int[][] ret = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            int[] t = res.get(i);
            ret[i][0] = t[0];
            ret[i][1] = t[1];
        }
        return ret;
    }
}
