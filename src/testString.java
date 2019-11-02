import java.util.Arrays;

public class testString {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                a += b;
            } else {
                b += a;
            }
        }
        if(n % 2 == 0) return a;
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new testString().climbStairs(4));
    }
}
