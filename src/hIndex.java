import java.util.Arrays;

public class hIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int[] t = new int[citations.length];
        for(int i = 0; i < citations.length; i++) {
            t[i] = citations[citations.length - 1 - i];
        }

        for(int i = 0; i < t.length; i++) {
            if(i >= t[i]) {
                return i;
            }
        }
        return t.length;
    }
}
