import java.util.Comparator;
import java.util.PriorityQueue;

public class test {
    public int test (int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int i : arr) {
            pq.add(i);
        }

        return pq.remove();
    }

    public static void main(String[] args) {
        int[] test = {3,6,2,9,5,2,1};

        System.out.println(Integer.parseInt("2147483648"));
    }
}
