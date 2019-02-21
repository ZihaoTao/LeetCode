import java.util.LinkedList;
import java.util.Queue;

public class reverse {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);
        Queue<Integer> q = new LinkedList<>();
        while(x > 0) {
            q.add(x % 10);
            x /= 10;
        }
        int sum = 0;
        while(!q.isEmpty()) {
            int n = q.remove();
            int temp = 10 * sum + n;
            if((temp - n) / 10 != sum) {
                return 0;
            }
            sum = temp;
        }
        return isNeg ? -sum : sum;
    }

    public static int reverse2(int x) {
        int result = 0;
        int dig;
        int temp;
        while(x != 0){
            dig = x % 10;
            temp = dig + result * 10;
            if((temp - dig)/10 != result){
                return 0;
            }
            result = temp;
            x /= 10;
        }
        return result;
    }
}
