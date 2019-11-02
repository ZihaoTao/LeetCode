import java.util.Arrays;
import java.util.Map;

public class nthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] nums = new int[primes.length];
        for(int i = 0; i < primes.length; i++) {
            nums[i] = primes[i];
        }
        int[] indices = new int[primes.length];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j : nums) {
                min = Math.min(min, j);
            }
            dp[i] = min;
            for(int j = 0; j < nums.length; j++) {
                if(min == nums[j]) nums[j] = primes[j] * dp[++indices[j]];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println((new nthSuperUglyNumber()).nthSuperUglyNumber(12, primes));
    }
}
