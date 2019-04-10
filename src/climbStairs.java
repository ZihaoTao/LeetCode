public class climbStairs {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        return helper(1, 1, n, 0);
    }

    private int helper(int a, int b, int n, int c) {
        if(n == 0) {
            if(c % 2 == 0) {
                return a;
            } else {
                return b;
            }
        } else if(c % 2 == 0) {
            return helper(a + b, b, n - 1, c + 1);
        } else {
            return helper(a, a + b, n - 1, c + 1);
        }
    }

    public int climbStairs3(int n) {
        int a = 1;
        int b = 1;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                a = a + b;
            } else {
                b = a + b;
            }
        }
        if(n % 2 == 0) {
            return a;
        } else {
            return b;
        }
    }



    public static void main(String[] args) {
        System.out.println((new climbStairs()).climbStairs(40));
        System.out.println((new climbStairs()).climbStairs2(40));
        System.out.println((new climbStairs()).climbStairs3(40));
    }
}
