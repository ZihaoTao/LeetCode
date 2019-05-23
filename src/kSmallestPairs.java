import java.util.*;

public class kSmallestPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for(int i = 0; i < nums1.length && i < k; i++) {
            for(int j = 0; j < nums2.length && j < k; j++) {
                int[] arr = new int[2];
                arr[0] = nums1[i];
                arr[1] = nums2[j];
                pq.add(arr);
            }
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < k && !pq.isEmpty(); i++) {
            res.add(pq.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        List<int[]> list = (new kSmallestPairs()).kSmallestPairs(nums1, nums2, 3);
        for(int[] i : list) {
            System.out.println(Arrays.toString(i));
        }
    }
}
