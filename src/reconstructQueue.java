import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });

        List<int[]> res = new ArrayList<>();
        for(int[] i : people) {
            res.add(i[1], i);
        }

        for(int i = 0; i < res.size(); i++) {
            int[] t = res.get(i);
            people[i][0] = t[0];
            people[i][1] = t[1];
        }
        return people;
    }
}
