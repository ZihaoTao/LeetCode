public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int f1 = 2, f2 = 3, f3 = 5;
        int i1 = 0, i2 = 0, i3 = 0;
        for(int i = 1; i < n; i++) {
            int min = Math.min(f1, Math.min(f2, f3));
            dp[i] = min;
            if (min == f1)
                f1 = 2 * dp[++i1];
            if (min == f2)
                f2 = 3 * dp[++i2];
            if (min == f3)
                f3 = 5 * dp[++i3];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println((new nthUglyNumber()).nthUglyNumber(10));
    }
}
