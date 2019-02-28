import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class largestNumber {
    int count = 0;
    public String largestNumber(int[] nums) {
        Arrays.sort(nums);
        int largest = nums[nums.length - 1];
        while(largest >= 10) {
            largest /= 10;
            count++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return ("" + o2 + o1).compareTo("" + o1 + o2);
            }
        });

        for(int i : nums) {
            pq.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.remove());
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int[] n = {3,30,34,5,9};
        System.out.println((new largestNumber()).largestNumber(n));
    }
}
