public class nthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] temp = new int[primes.length];
        for(int i = 0; i < primes.length; i++) {
            temp[i] = primes[i];
        }
        int[] is = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                if(primes[j] < min) {
                    min = primes[j];
                }
            }
            dp[i] = min;
            for(int j = 0; j < primes.length; j++) {
                if(primes[j] == min) primes[j] = dp[++is[j]] * temp[j];
            }
        }
        return dp[n - 1];
    }
}
