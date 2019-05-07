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

    public int reverse2(int x) {
        boolean isNeg = false;;
        if(x < 0) {
            isNeg = true;
            x = -x;
        }
        int res = 0;
        while(x > 0) {
            int temp = res * 10 + x % 10;
            if((temp - x % 10) / 10 != res) {
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return isNeg ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println((new reverse()).reverse(-322212120));
    }
}
