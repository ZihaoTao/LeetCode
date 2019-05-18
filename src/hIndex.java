import java.util.Arrays;

public class hIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int l = 0;
        int r = citations.length - 1;
        while(l < r) {
            int temp = citations[l];
            citations[l] = citations[r];
            citations[r] = temp;
            l++;
            r--;
        }

        for(int i = 0; i < citations.length; i++) {
            if(citations[i] <= i) {
                return i;
            }
        }
        return citations.length;
    }

    public static void main(String[] args) {
        int[] test = {1,2,4,5,6};
        (new hIndex()).hIndex(test);
        System.out.println(Arrays.toString(test));
    }
}
