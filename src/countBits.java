import java.util.Arrays;

public class countBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            if(i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString((new countBits()).countBits(5)));
    }
}
