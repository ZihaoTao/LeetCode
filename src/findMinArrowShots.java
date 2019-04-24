import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = points[0][1];
        int num = 1;
        for(int[] i : points) {
            if(i[0] <= end) continue;
            num++;
            end = i[1];
        }
        return num;
    }
}
