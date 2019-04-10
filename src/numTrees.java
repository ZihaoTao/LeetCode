public class numTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];//dp[i] the number of unique bst when n == i
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        if (n <= 1) return 1;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            // left node num : i - 1; right node num : n - i
            sum += numTrees2(i - 1) * numTrees2(n - i);
        }
        return sum;
    }

    public int numTrees3(int n) {
        return helper(1, n);
    }

    private int helper(int l, int r) {
        if(l > r) {
            return 1;
        } else {
            int res = 0;
            for(int i = l; i <= r; i++) {
                int left = helper(l, i - 1);
                int right = helper(i + 1, r);
                res += left * right;
            }
            return res;
        }
    }
}
